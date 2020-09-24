package com.ats.triladmin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.model.BillBookDetail;
import com.ats.triladmin.model.BillBookHeader;
import com.ats.triladmin.model.GetBillHeader;
import com.ats.triladmin.model.Info;
import com.ats.triladmin.model.Vendor;
import com.ats.triladmin.model.mrn.GetMrnHeaderWithAmt;
import com.ats.triladmin.model.mrn.MrnDetailForBillBook;
import com.ats.triladmin.repository.BillBookDetailRepo;
import com.ats.triladmin.repository.BillBookHeaderRepo;
import com.ats.triladmin.repository.GetBillHeaderRepo;
import com.ats.triladmin.repository.VendorRepository;
import com.ats.triladmin.repository.mrn.GetMrnHeaderWithAmtRepository;
import com.ats.triladmin.repository.mrn.MrnDetailForBillBookRepo;
@RestController
public class BillApiController {
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	BillBookHeaderRepo billBookHeaderRepo;
	
	@Autowired
	BillBookDetailRepo billBookDetailRepo;
	
	@Autowired
	GetMrnHeaderWithAmtRepository getMrnHeaderWithAmtRepository;
	
	@Autowired
	MrnDetailForBillBookRepo mrnDetailForBillBookRepo;
	
	@Autowired
	GetBillHeaderRepo getBillHeaderRepo;
	
	@RequestMapping(value = { "/getVendorForBillBook" }, method = RequestMethod.POST)
	public @ResponseBody List<Vendor> getVendorForBillBook() {

		List<Vendor> vendor = new ArrayList<>();
		try {
			vendor = vendorRepository.getVendorForBillBook();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vendor;

	}
	
	@RequestMapping(value = { "/getBillNoFoBillBook" }, method = RequestMethod.POST)
	public @ResponseBody Info getBillNoFoBillBook() {

		Info info = new Info();

		try {

			int count = billBookHeaderRepo.getBillListCount() + 1;

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy--");
			Calendar cal = Calendar.getInstance();
			String billNo = sdf.format(cal.getTimeInMillis());

			info.setMessage(billNo + "" + String.format("%04d", count));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return info;

	}
	
	// GET ALL MRN HEADERS BY STATUS=4

		@RequestMapping(value = { "/getAllMrnHeaderByVendor" }, method = RequestMethod.POST)
		public @ResponseBody List<GetMrnHeaderWithAmt> getAllMrnHeaderByVendor(@RequestParam("vendorId") int vendorId) {

			List<GetMrnHeaderWithAmt> mrnHeaderList = new ArrayList<GetMrnHeaderWithAmt>();

			try {

				mrnHeaderList = getMrnHeaderWithAmtRepository.getMrnHeaderByVendor(vendorId);

			} catch (Exception e) {

				e.printStackTrace();

			}

			return mrnHeaderList;

		}
		
	

		@RequestMapping(value = { "/getMrnDetailForBillBookByMrnId" }, method = RequestMethod.POST)
		public @ResponseBody List<MrnDetailForBillBook> getMrnDetailForBillBookByMrnId(@RequestParam("mrnId") int mrnId) {

			List<MrnDetailForBillBook> mrnDetailList = new ArrayList<>();

			try {

				mrnDetailList = mrnDetailForBillBookRepo.getMrnDetailForBillBook(mrnId);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return mrnDetailList;

		}
		
		@RequestMapping(value = { "/getAccountLevelItemListForBill" }, method = RequestMethod.POST)
		public @ResponseBody List<MrnDetailForBillBook> getAccountLevelItemListForBill() {

			List<MrnDetailForBillBook> itemList = new ArrayList<>();

			try {
				itemList = mrnDetailForBillBookRepo.getAccountLevelItemListForBill();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return itemList;

		}
		
		@RequestMapping(value = { "/getVendorById" }, method = RequestMethod.POST)
		public @ResponseBody Vendor getVendorById(@RequestParam("vendId") int vendId) {

			Vendor vendor = new Vendor();
			try {
				vendor = vendorRepository.getVendorById(vendId);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return vendor;

		}
		
		@RequestMapping(value = { "/saveBillBookHeaderAndDetail" }, method = RequestMethod.POST)
		public @ResponseBody BillBookHeader saveBillBookHeaderAndDetail(@RequestBody BillBookHeader billBookHeader) {

			BillBookHeader save = new BillBookHeader();

			try {

				save = billBookHeaderRepo.save(billBookHeader);
				System.err.println("BILL SAVE - " + save);

				for (int i = 0; i < billBookHeader.getBillBookDetail().size(); i++) {

					BillBookDetail model = billBookHeader.getBillBookDetail().get(i);
					model.setBillId(save.getBillId());

					billBookDetailRepo.save(model);
					
					System.err.println("DETAIL  "+(i+1)+" = "+model);
				}

			} catch (Exception e) {

				e.printStackTrace();

			}
			return save;

		}
		
		@RequestMapping(value = { "/getBillHeaderBetDate" }, method = RequestMethod.POST)
		public @ResponseBody List<GetBillHeader> getBillHeaderBetDate(@RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate) {

			List<GetBillHeader> list = new ArrayList<GetBillHeader>();

			try {

				list = getBillHeaderRepo.getBillHeaderListByDate(fromDate, toDate);

			} catch (Exception e) {

				e.printStackTrace();

			}
			return list;

		}
		
		@RequestMapping(value = { "/getBillHeaderById" }, method = RequestMethod.POST)
		public @ResponseBody BillBookHeader getBillHeaderById(@RequestParam("billId") int billId) {

			BillBookHeader header = null;

			try {

				header = billBookHeaderRepo.getBillHeaderById(billId);

				if (header == null) {
					header = new BillBookHeader();
				} else {

					List<BillBookDetail> billBookDetailList = new ArrayList<>();
					billBookDetailList = billBookDetailRepo.findAllByBillId(billId);
					header.setBillBookDetail(billBookDetailList);
				}

			} catch (Exception e) {

				e.printStackTrace();

			}
			return header;

		}
		

}
