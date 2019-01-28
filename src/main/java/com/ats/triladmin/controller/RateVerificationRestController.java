package com.ats.triladmin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.common.DateConvertor;
import com.ats.triladmin.model.GetRmRateVerificationRecord;
import com.ats.triladmin.model.ItemListByRateVerification;
import com.ats.triladmin.model.RmRateVerificationList;
import com.ats.triladmin.model.RmRateVerificationRecord;
import com.ats.triladmin.repository.GetRmRateVerificationRecordRepo;
import com.ats.triladmin.repository.ItemListByRateVerificationRepo;
import com.ats.triladmin.repository.RmRateVerificationListRepo;
import com.ats.triladmin.repository.RmRateVerificationRecordRepo; 

@RestController
public class RateVerificationRestController {
	 
	 @Autowired
	 RmRateVerificationListRepo rmRateVerificationListRepo;
	
	 @Autowired
	 RmRateVerificationRecordRepo rmRateVerificationRecordRepo;
	 
	 @Autowired
	 GetRmRateVerificationRecordRepo getRmRateVerificationRecordRepo;
	 
	 @Autowired
	 ItemListByRateVerificationRepo itemListByRateVerificationRepo;
	 
	@RequestMapping(value = { "/saveRmRateVarification" }, method = RequestMethod.POST)
	public @ResponseBody RmRateVerificationList  saveRmRateVarification(@RequestBody RmRateVerificationList rmRateVerification) {
 
		RmRateVerificationList save = new RmRateVerificationList();

		try {

			 
			save = rmRateVerificationListRepo.save(rmRateVerification);
 
		} catch (Exception e) {
 
			e.printStackTrace();

		}

		return save;

	} 
	
	@RequestMapping(value = { "/rmVarificationListByItemIdAndVendId" }, method = RequestMethod.POST)
	public @ResponseBody RmRateVerificationList  rmVarificationListByItemIdAndVendId(@RequestParam("itemId") int itemId,
			@RequestParam("vendId") int vendId) {
 
		RmRateVerificationList rmVarificationListByItemIdAndVendId = new RmRateVerificationList();

		try {

			 
			rmVarificationListByItemIdAndVendId = rmRateVerificationListRepo.findByRmIdAndSuppId(itemId,vendId);
			
			if(rmVarificationListByItemIdAndVendId==null) {
				rmVarificationListByItemIdAndVendId = new RmRateVerificationList();
				Date date = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
				rmVarificationListByItemIdAndVendId = new RmRateVerificationList();
				rmVarificationListByItemIdAndVendId.setRateDate(sf.format(date));
				rmVarificationListByItemIdAndVendId.setDate1(sf.format(date));
				rmVarificationListByItemIdAndVendId.setDate2(sf.format(date));
			}
			else {
				rmVarificationListByItemIdAndVendId.setRateDate(DateConvertor.convertToDMY(rmVarificationListByItemIdAndVendId.getRateDate()));
				rmVarificationListByItemIdAndVendId.setDate1(DateConvertor.convertToDMY(rmVarificationListByItemIdAndVendId.getDate1()));
				rmVarificationListByItemIdAndVendId.setDate2(DateConvertor.convertToDMY(rmVarificationListByItemIdAndVendId.getDate2()));
			}
 
		} catch (Exception e) {
 
			e.printStackTrace();
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
			rmVarificationListByItemIdAndVendId = new RmRateVerificationList();
			rmVarificationListByItemIdAndVendId.setRateDate(sf.format(date));
			rmVarificationListByItemIdAndVendId.setDate1(sf.format(date));
			rmVarificationListByItemIdAndVendId.setDate2(sf.format(date));
		}

		return rmVarificationListByItemIdAndVendId;

	} 
	
	@RequestMapping(value = { "/rmVarificationListByVendId" }, method = RequestMethod.POST)
	public @ResponseBody List<RmRateVerificationList>  rmVarificationListByVendId( @RequestParam("vendId") int vendId) {
 
		List<RmRateVerificationList> rmVarificationListByVendId = new ArrayList<>();

		try {

			 
			rmVarificationListByVendId = rmRateVerificationListRepo.findStsteCodeTaxPerBySuppId(vendId);
			 
 
		} catch (Exception e) {
 
			e.printStackTrace();
			 
		}

		return rmVarificationListByVendId;

	} 
	
	@RequestMapping(value = { "/saveRateVarificationRecord" }, method = RequestMethod.POST)
	public @ResponseBody RmRateVerificationRecord saveRateVarificationRecord(@RequestBody RmRateVerificationRecord rmRateVerificationRecord) {
 
		RmRateVerificationRecord save = new RmRateVerificationRecord();

		try {
 
			save = rmRateVerificationRecordRepo.save(rmRateVerificationRecord);
 
		} catch (Exception e) {
 
			e.printStackTrace();

		}

		return save;

	} 
	
	@RequestMapping(value = { "/getRateVerificationRecordList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetRmRateVerificationRecord> getRateVerificationRecordList() {
 
		List<GetRmRateVerificationRecord> list = new ArrayList<GetRmRateVerificationRecord>();

		try {

			 
			list = getRmRateVerificationRecordRepo.getRateVerificationRecordList();
			 
 
		} catch (Exception e) {
 
			e.printStackTrace();
			 
		}

		return list;

	}
	
	@RequestMapping(value = { "/getRateVerificationRecordListDateWise" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRmRateVerificationRecord> getRateVerificationRecordListDateWise(@RequestParam("itemId") int itemId,
			@RequestParam("vendId") int vendId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
 
		List<GetRmRateVerificationRecord> list = new ArrayList<GetRmRateVerificationRecord>();

		try {

			if(vendId!=0 && itemId!=0) {
				
				list = getRmRateVerificationRecordRepo.getRateVerificationRecordListByVendIdAndItemId(fromDate,toDate,vendId,itemId);
			}else if(vendId!=0 && itemId==0) {
				
				list = getRmRateVerificationRecordRepo.getRateVerificationRecordListByVendId(fromDate,toDate,vendId);
			}else if(vendId==0 && itemId!=0) {
				
				list = getRmRateVerificationRecordRepo.getRateVerificationRecordListByItemId(fromDate,toDate,itemId);
			}else {
				
				list = getRmRateVerificationRecordRepo.getRateVerificationRecordListByDate(fromDate,toDate);
			}
			
			
			 
 
		} catch (Exception e) {
 
			e.printStackTrace();
			 
		}

		return list;

	}
	
	@RequestMapping(value = { "/getItemListByVendId" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemListByRateVerification> getItemListByVendId( 
			@RequestParam("vendId") int vendId ) {
 
		List<ItemListByRateVerification> list = new ArrayList<ItemListByRateVerification>();

		try {

			 
				list = itemListByRateVerificationRepo.getRateVerificationItemListByVendId(vendId);
			 
 
		} catch (Exception e) {
 
			e.printStackTrace();
			 
		}

		return list;

	}
	
	@RequestMapping(value = { "/getItemRateListByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRmRateVerificationRecord> getItemRateListByCatId( 
			@RequestParam("catId") int catId ) {
 
		List<GetRmRateVerificationRecord> list = new ArrayList<GetRmRateVerificationRecord>();

		try {

			 
			list = getRmRateVerificationRecordRepo.getItemRateListByCatId(catId);
			 
 
		} catch (Exception e) {
 
			e.printStackTrace();
			 
		}

		return list;

	}
	
	/*@RequestMapping(value = { "/getItemRateListByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRmRateVerificationRecord> getItemRateListByCatId( 
			@RequestParam("catId") int catId ) {
 
		List<GetRmRateVerificationRecord> list = new ArrayList<GetRmRateVerificationRecord>();

		try {

			 
			list = getRmRateVerificationRecordRepo.getItemRateListByCatId(catId);
			 
 
		} catch (Exception e) {
 
			e.printStackTrace();
			 
		}

		return list;

	}*/
 
}
