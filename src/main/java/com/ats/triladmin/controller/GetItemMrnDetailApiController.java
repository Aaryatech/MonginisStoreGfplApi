package com.ats.triladmin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.model.mrn.GetMrnItemDetail;
import com.ats.triladmin.repository.GetItemMrnDetailRepo;

@RestController
public class GetItemMrnDetailApiController {

	@Autowired
	GetItemMrnDetailRepo  itemMrnRepo;
	
	
	@RequestMapping(value="/GetItemMrnDetailsByExpDt",
			method=RequestMethod.POST)
	public @ResponseBody List<GetMrnItemDetail> getDetailByExpDt(@RequestParam String fromDt,
																@RequestParam String toDt) {
		try {
			List<GetMrnItemDetail> mrnItemDetaiList=new ArrayList<GetMrnItemDetail>();
			mrnItemDetaiList= itemMrnRepo.getMrnItemDetailByExpDt(fromDt, toDt);
			return mrnItemDetaiList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	
	}
	
	
}
