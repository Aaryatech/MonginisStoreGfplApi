package com.ats.triladmin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.model.ownerapp.PurchaseDetailDisplayForApp;
import com.ats.triladmin.model.ownerapp.PurchaseHeaderDisplayForApp;
import com.ats.triladmin.repo.ownerapp.PurchaseDetailDisplayForAppRepo;
import com.ats.triladmin.repo.ownerapp.PurchaseHeaderDisplayForAppRepo;


@RestController
public class OwnerAppController {

	@Autowired
	PurchaseHeaderDisplayForAppRepo purchaseHeaderDisplayForAppRepo;

	@Autowired
	PurchaseDetailDisplayForAppRepo purchaseDetailDisplayForAppRepo;
	
	
	@RequestMapping(value = { "/getPurchaseHeaderByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<PurchaseHeaderDisplayForApp> getPurchaseHeader(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		List<PurchaseHeaderDisplayForApp> result= new ArrayList<PurchaseHeaderDisplayForApp>();

		try {
			result = purchaseHeaderDisplayForAppRepo.getPurchaseHeaderByDate(fromDate, toDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	@RequestMapping(value = { "/getPurchaseDetailByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<PurchaseDetailDisplayForApp> getPurchaseDetail(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		List<PurchaseDetailDisplayForApp> result= new ArrayList<PurchaseDetailDisplayForApp>();

		try {
			result = purchaseDetailDisplayForAppRepo.getPurchaseDetailByDate(fromDate, toDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
