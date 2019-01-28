package com.ats.triladmin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.model.ErrorMessage;
import com.ats.triladmin.model.GeneralGrnDetail;
import com.ats.triladmin.model.GeneralGrnHeader;
import com.ats.triladmin.model.GetGeneralGrnDetail;
import com.ats.triladmin.model.GetGeneralGrnHeader;
import com.ats.triladmin.repository.GeneralGrnDetailRepository;
import com.ats.triladmin.repository.GeneralGrnHeaderRepository;
import com.ats.triladmin.repository.GetGeneralGrnDetailRepository;
import com.ats.triladmin.repository.GetGeneralGrnHeaderRepository; 

@RestController
public class GeneralGrnRestController {
	
	
	@Autowired
	GeneralGrnHeaderRepository generalGrnHeaderRepository;
	
	@Autowired
	GeneralGrnDetailRepository generalGrnDetailRepository;
	
	@Autowired
	GetGeneralGrnHeaderRepository getGeneralGrnHeaderRepository;
	
	@Autowired
	GetGeneralGrnDetailRepository getGeneralGrnDetailRepository;
	  

	@RequestMapping(value = { "/saveGeneralGrnHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody GeneralGrnHeader saveGeneralGrnHeaderAndDetail(@RequestBody GeneralGrnHeader generalGrnHeader) {

		GeneralGrnHeader save = new GeneralGrnHeader();

		try {
			
			save = generalGrnHeaderRepository.save(generalGrnHeader);

			for (int i = 0; i < generalGrnHeader.getGeneralGrnDetailList().size(); i++) {
				
				generalGrnHeader.getGeneralGrnDetailList().get(i).setGrnId(save.getGrnId());
			}
			
			List<GeneralGrnDetail> generalGrnDetailList = generalGrnDetailRepository.saveAll(generalGrnHeader.getGeneralGrnDetailList());
			save.setGeneralGrnDetailList(generalGrnDetailList);

		} catch (Exception e) {

			e.printStackTrace(); 

		}
		return save;

	}
	
	@RequestMapping(value = { "/getGeneralGrnHeaderListBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetGeneralGrnHeader> getGeneralGrnHeaderListBetweenDate(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetGeneralGrnHeader> getGeneralGrnHeaderList = new ArrayList<GetGeneralGrnHeader>();

		try {

			getGeneralGrnHeaderList = getGeneralGrnHeaderRepository.getGeneralGrnHeaderListBetweenDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getGeneralGrnHeaderList;

	}
	
	@RequestMapping(value = { "/getGeneralGrnHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody  GetGeneralGrnHeader  getGeneralGrnHeaderAndDetail( @RequestParam("grnId") int grnId) {

		 GetGeneralGrnHeader  getGeneralGrnHeader = new  GetGeneralGrnHeader ();

		try {

			getGeneralGrnHeader = getGeneralGrnHeaderRepository.getGeneralGrnHeader(grnId);
			
			List<GetGeneralGrnDetail> getGeneralGrnDetailList = getGeneralGrnDetailRepository.getGeneralDetail(grnId);
			getGeneralGrnHeader.setGetGeneralGrnDetailList(getGeneralGrnDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getGeneralGrnHeader;

	}
	
	@RequestMapping(value = { "/deleteGeneralGrn" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteGeneralGrn(@RequestParam("grnId") int grnId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int update = generalGrnHeaderRepository.delete(grnId);

			if (update == 0) {
				errorMessage.setError(true);
				errorMessage.setMessage("failed to Delete ");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("  Deleted ");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Delete ");

		}
		return errorMessage;

	}

}
