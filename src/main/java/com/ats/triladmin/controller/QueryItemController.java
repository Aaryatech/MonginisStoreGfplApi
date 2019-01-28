package com.ats.triladmin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.common.DateConvertor;
import com.ats.triladmin.model.getqueryitems.GetDamageQueryItem;
import com.ats.triladmin.model.getqueryitems.GetEnquiryQueryItem;
import com.ats.triladmin.model.getqueryitems.GetIndentQueryItem;
import com.ats.triladmin.model.getqueryitems.GetIssueQueryItem;
import com.ats.triladmin.model.getqueryitems.GetMrnQueryItem;
import com.ats.triladmin.model.getqueryitems.GetPoQueryItem;
import com.ats.triladmin.model.getqueryitems.GetRejMemoQueryItem;
import com.ats.triladmin.model.getqueryitems.GetRetNonRetQueryItem;
import com.ats.triladmin.repository.queryitems.GetDamageQueryItemRepo;
import com.ats.triladmin.repository.queryitems.GetEnquiryQueryItemRepo;
import com.ats.triladmin.repository.queryitems.GetIndentQueryItemRepo;
import com.ats.triladmin.repository.queryitems.GetIssueQueryItemRepo;
import com.ats.triladmin.repository.queryitems.GetMrnQueryItemRepo;
import com.ats.triladmin.repository.queryitems.GetPoQueryItemRepo;
import com.ats.triladmin.repository.queryitems.GetRejMemoQueryItemRepo;
import com.ats.triladmin.repository.queryitems.GetRetNonRetQueryItemRepo;

@RestController
public class QueryItemController {

	@Autowired
	GetIndentQueryItemRepo getIndentQueryItemRepo;
	
	@Autowired
	GetPoQueryItemRepo getPoQueryItemRepo;
	
	@Autowired
	GetMrnQueryItemRepo getMrnQueryItemRepo;
	
	@Autowired
	GetIssueQueryItemRepo getIssueQueryItemRepo;
	
	@Autowired
	GetEnquiryQueryItemRepo getEnquiryQueryItemRepo;
	
	@Autowired
	GetRetNonRetQueryItemRepo getRetNonRetQueryItemRepo;

	@Autowired
	GetRejMemoQueryItemRepo getRejMemoQueryItemRepo;
	
	@Autowired
	GetDamageQueryItemRepo getDamageQueryItemRepo;
	
	@RequestMapping(value = { "/getIndentQueryItems" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIndentQueryItem> getIndentQueryItems(@RequestParam("fromDate") String fromDate,
			@RequestParam("itemId") int itemId) {

		System.err.println("inside web api /getIndentQueryItems QueryItemController");

		List<GetIndentQueryItem> indentList = new ArrayList<GetIndentQueryItem>();

		try {

			Date fromD=DateConvertor.convertToSqlDate(fromDate);
			indentList = getIndentQueryItemRepo.getIndentQueryItem(fromD,itemId);

			System.err.println(" getIndentQueryItems  List " + indentList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getIndentQueryItems  QueryItemController  " + e.getMessage());

			e.printStackTrace();

		}

		return indentList;

	}

	
	@RequestMapping(value = { "/getPoQueryItem" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoQueryItem> getPoQueryItem(@RequestParam("fromDate") String fromDate,
			@RequestParam("itemId") int itemId) {

		System.err.println("inside web api /getPoQueryItem QueryItemController");

		List<GetPoQueryItem> poQueryItemList = new ArrayList<GetPoQueryItem>();

		try {

			Date fromD=DateConvertor.convertToSqlDate(fromDate);
			poQueryItemList = getPoQueryItemRepo.getPoQueryItem(fromD,itemId);

			System.err.println(" getPoQueryItem  List " + poQueryItemList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getPoQueryItem  QueryItemController  " + e.getMessage());

			e.printStackTrace();

		}

		return poQueryItemList;

	}

	@RequestMapping(value = { "/getMrnQueryItem" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnQueryItem> getMrnQueryItem(@RequestParam("fromDate") String fromDate,
			@RequestParam("itemId") int itemId) {

		System.err.println("inside web api /getPoQueryItem QueryItemController");

		List<GetMrnQueryItem> mrnqueryItemList = new ArrayList<GetMrnQueryItem>();

		try {

			Date fromD=DateConvertor.convertToSqlDate(fromDate);
			mrnqueryItemList = getMrnQueryItemRepo.getMnrQueryItem(fromD,itemId);

			System.err.println(" getMrnQueryItem  List " + mrnqueryItemList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getMrnQueryItem  QueryItemController  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnqueryItemList;

	}
	
	
	@RequestMapping(value = { "/getIssueQueryItem" }, method = RequestMethod.POST)
	public @ResponseBody List<GetIssueQueryItem> getIssueQueryItemRepo(@RequestParam("fromDate") String fromDate,
			@RequestParam("itemId") int itemId) {

		System.err.println("inside web api /getIssueQueryItem QueryItemController");

		List<GetIssueQueryItem> issueQueryItemList = new ArrayList<GetIssueQueryItem>();

		try {

			Date fromD=DateConvertor.convertToSqlDate(fromDate);
			issueQueryItemList = getIssueQueryItemRepo.getIssueQueryItem(fromD,itemId);

			System.err.println(" getIssueQueryItem  List " + issueQueryItemList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getIssueQueryItem  QueryItemController  " + e.getMessage());

			e.printStackTrace();

		}

		return issueQueryItemList;

	}
	
	@RequestMapping(value = { "/getEnquiryQueryItem" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEnquiryQueryItem> getEnquiryQueryItem(@RequestParam("fromDate") String fromDate,
			@RequestParam("itemId") int itemId) {

		System.err.println("inside web api /getEnquiryQueryItem QueryItemController");

		List<GetEnquiryQueryItem> enquiryQueryItemList = new ArrayList<GetEnquiryQueryItem>();

		try {

			Date fromD=DateConvertor.convertToSqlDate(fromDate);
			enquiryQueryItemList = getEnquiryQueryItemRepo.getEnquiryQueryItem(fromD,itemId);

			System.err.println(" getEnquiryQueryItem  List " + enquiryQueryItemList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getEnquiryQueryItem  QueryItemController  " + e.getMessage());

			e.printStackTrace();

		}

		return enquiryQueryItemList;

	}
	
	
	@RequestMapping(value = { "/getRetNonRetQueryItem" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRetNonRetQueryItem> getRetNonRetQueryItem(@RequestParam("fromDate") String fromDate,
			@RequestParam("itemId") int itemId) {

		System.err.println("inside web api /getRetNonRetQueryItem QueryItemController");

		List<GetRetNonRetQueryItem> retNonRetQueryItemList = new ArrayList<GetRetNonRetQueryItem>();

		try {

			Date fromD=DateConvertor.convertToSqlDate(fromDate);
			retNonRetQueryItemList = getRetNonRetQueryItemRepo.getRetNonRetQueryItem(fromD,itemId);

			System.err.println(" getRetNonRetQueryItem  List " + retNonRetQueryItemList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getRetNonRetQueryItem  QueryItemController  " + e.getMessage());

			e.printStackTrace();

		}

		return retNonRetQueryItemList;

	}
	
	@RequestMapping(value = { "/getRejMemoQueryItem" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRejMemoQueryItem> getRejMemoQueryItem(@RequestParam("fromDate") String fromDate,
			@RequestParam("itemId") int itemId) {

		System.err.println("inside web api /getRejMemoQueryItem QueryItemController");

		List<GetRejMemoQueryItem> rejMemoQueryItemList = new ArrayList<GetRejMemoQueryItem>();

		try {

			Date fromD=DateConvertor.convertToSqlDate(fromDate);
			rejMemoQueryItemList = getRejMemoQueryItemRepo.getRejeMemoQueryItem(fromD, itemId);

			System.err.println(" getRejMemoQueryItem  List " + rejMemoQueryItemList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getRejMemoQueryItem  QueryItemController  " + e.getMessage());

			e.printStackTrace();

		}

		return rejMemoQueryItemList;

	}
	
	@RequestMapping(value = { "/getDamageQueryItem" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDamageQueryItem> getDamageQueryItem(@RequestParam("fromDate") String fromDate,
			@RequestParam("itemId") int itemId) {

		System.err.println("inside web api /getDamageQueryItem QueryItemController");

		List<GetDamageQueryItem> rejMemoQueryItemList = new ArrayList<GetDamageQueryItem>();

		try {

			Date fromD=DateConvertor.convertToSqlDate(fromDate);
			rejMemoQueryItemList = getDamageQueryItemRepo.getDamageQueryItem(fromD, itemId);

			System.err.println(" getDamageQueryItem  List " + rejMemoQueryItemList.toString());
		} catch (Exception e) {

			System.err.println("Exception in getDamageQueryItem  QueryItemController  " + e.getMessage());

			e.printStackTrace();

		}

		return rejMemoQueryItemList;
	}
	
}
