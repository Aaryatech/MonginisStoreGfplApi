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
import com.ats.triladmin.model.MrnItemList;
import com.ats.triladmin.model.mrn.MrnDetail;
import com.ats.triladmin.model.rejection.GetRejectionMemo;
import com.ats.triladmin.model.rejection.GetRejectionMemoDetail;
import com.ats.triladmin.model.rejection.RejectionMemo;
import com.ats.triladmin.model.rejection.RejectionMemoDetail;
import com.ats.triladmin.model.rejection.RejectionReport;
import com.ats.triladmin.model.rejection.repo.GetRejectionMemoDetailRepo;
import com.ats.triladmin.model.rejection.repo.GetRejectionMemoRepo;
import com.ats.triladmin.model.rejection.repo.RejectionMemoDetailRepo;
import com.ats.triladmin.model.rejection.repo.RejectionMemoRepo;
import com.ats.triladmin.model.rejection.repo.RejectionReportRepo;
import com.ats.triladmin.repository.mrn.MrnDetailRepo;

@RestController
public class RejectionController {

	@Autowired
	RejectionMemoRepo rejectionMemoRepo;

	@Autowired
	GetRejectionMemoRepo getRejectionMemoRepo;

	@Autowired
	GetRejectionMemoDetailRepo getRejectionMemoDetailRepo;

	@Autowired
	RejectionMemoDetailRepo rejectionMemoDetailRepo;

	@Autowired
	RejectionReportRepo rejectionReportRepo;
	
	@Autowired
	MrnDetailRepo mrnDetailRepo;

	@RequestMapping(value = { "/saveRejectionMemoHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<RejectionMemo> saveRejectionMemoHeaderDetail(
			@RequestBody List<RejectionMemo> rejectionMemoList) {
		RejectionMemo rejMemo = new RejectionMemo();

		try {
			for (int j = 0; j < rejectionMemoList.size(); j++) {

				rejMemo = rejectionMemoRepo.saveAndFlush(rejectionMemoList.get(j));
				System.out.println("List" + rejMemo);
				for (int i = 0; i < rejectionMemoList.get(j).getRejectionMemoDetailList().size(); i++)
					rejectionMemoList.get(j).getRejectionMemoDetailList().get(i)
							.setRejectionId(rejMemo.getRejectionId());

				List<RejectionMemoDetail> rejectionMemoDetail = rejectionMemoDetailRepo
						.saveAll(rejectionMemoList.get(j).getRejectionMemoDetailList());
				System.out.println("rejectionMemoDetail" + rejectionMemoDetail.toString());
				rejMemo.setRejectionMemoDetailList(rejectionMemoDetail);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejectionMemoList;

	}

	@RequestMapping(value = { "/getRejectionHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetRejectionMemo getGetpassItemHeaderAndDetail(@RequestParam("rejectionId") int rejectionId) {

		GetRejectionMemo rejectionMemo = new GetRejectionMemo();

		try {

			rejectionMemo = getRejectionMemoRepo.getRejectionMemoById(rejectionId);
			List<GetRejectionMemoDetail> rejectionMemoDetailList = getRejectionMemoDetailRepo
					.getRejectionMemoDetailById(rejectionId);
			rejectionMemo.setGetRejectionMemoDetail(rejectionMemoDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejectionMemo;

	}

	@RequestMapping(value = { "/deleteRejectionMemo" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRejectionMemo(@RequestParam("rejectionId") int rejectionId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = rejectionMemoRepo.deleteRejectionMemo(rejectionId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Dept Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getRejectionMemoByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRejectionMemo> getRejectionMemoByDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetRejectionMemo> rejectionMemoList = new ArrayList<GetRejectionMemo>();

		try {
			rejectionMemoList = getRejectionMemoRepo.getRejectionMemoByDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return rejectionMemoList;

	}

	@RequestMapping(value = { "/getRejectionListReport" }, method = RequestMethod.POST)
	public @ResponseBody List<RejectionReport> getRejectionListReport(

			@RequestParam("vendorIdList") List<Integer> vendorIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<RejectionReport> indentList = new ArrayList<RejectionReport>();

		try {

			if (vendorIdList.contains(0)) {
				indentList = rejectionReportRepo.getRejectionMemoBetDate(fromDate, toDate);

			} else {

				indentList = rejectionReportRepo.getRejectionMemoBetDateAndList(fromDate, toDate, vendorIdList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return indentList;

	}

	@RequestMapping(value = { "/getRejectionListItemwise" }, method = RequestMethod.POST)
	public @ResponseBody List<RejectionReport> getRejectionListItemwise(

			@RequestParam("itemIdList") List<Integer> itemIdList, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<RejectionReport> rejList = new ArrayList<RejectionReport>();

		try {

			if (itemIdList.contains(0)) {
				rejList = rejectionReportRepo.getAllRejectionMemoItemwise(fromDate, toDate);

			} else {

				rejList = rejectionReportRepo.getRejectionMemoItemwise(fromDate, toDate, itemIdList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rejList;

	}
	
	@RequestMapping(value = { "/updateApprovedQtyWhileReturnProcess" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateApprovedQtyWhileReturnProcess(@RequestBody List<MrnItemList> mrnItemList) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			for(int i=0 ; i< mrnItemList.size() ; i++) {
				 
				float remQty = mrnItemList.get(i).getPendingQty() - mrnItemList.get(i).getReturnQty(); 
				int update = mrnDetailRepo.updaetQty(mrnItemList.get(i).getMrnDetailedId(),remQty);
			} 
				errorMessage.setError(false);
				errorMessage.setMessage("Updated Successfully");
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Updation Failed :EXC");

		}
		return errorMessage;
	}
	
	@RequestMapping(value = { "/updatePendingQtyWhileDeleteReturnProcess" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updatePendingQtyWhileDeleteReturnProcess(@RequestBody List<MrnItemList> mrnItemList) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			for(int i=0 ; i< mrnItemList.size() ; i++) {
				 
				MrnDetail mrnDetail = mrnDetailRepo.findByMrnDetailId(mrnItemList.get(i).getMrnDetailedId());
				float remQty = mrnDetail.getRemainingQty() + mrnItemList.get(i).getReturnQty(); 
				int update = mrnDetailRepo.updaetQty(mrnItemList.get(i).getMrnDetailedId(),remQty);
			} 
				errorMessage.setError(false);
				errorMessage.setMessage("Updated Successfully");
			 

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Updation Failed :EXC");

		}
		return errorMessage;
	}

}
