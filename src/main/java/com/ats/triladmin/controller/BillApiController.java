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
import com.ats.triladmin.model.MrnExcelPuch;
import com.ats.triladmin.model.Vendor;
import com.ats.triladmin.model.mrn.GetMrnHeaderWithAmt;
import com.ats.triladmin.model.mrn.MrnDetailForBillBook;
import com.ats.triladmin.repository.BillBookDetailRepo;
import com.ats.triladmin.repository.BillBookHeaderRepo;
import com.ats.triladmin.repository.GetBillHeaderRepo;
import com.ats.triladmin.repository.MrnExcelPuchRepository;
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
	
	@Autowired
	MrnExcelPuchRepository mrnExcelPuchRepository;
	
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
		
		@RequestMapping(value = {"/getBillBookExcelReport"}, method = RequestMethod.POST)
		public @ResponseBody List<MrnExcelPuch> getMrnHsnwiseExcelReport(@RequestParam("mrnIdList") List<String> mrnIdList)

		{
			List<MrnExcelPuch> report = new ArrayList<MrnExcelPuch>();

			try {

				report = mrnExcelPuchRepository.getBillBookExcelReport(mrnIdList);
			} catch (Exception e) {
				System.out.println("Exce In /getBillBookExcelReport " + e.getMessage());

				e.printStackTrace();
			}
			return report;
		}
}


//SELECT
//t_mrn_detail.mrn_detail_id,
//t_mrn_detail.mrn_id,
//m_category.cat_id as mrn_type_id,
//m_category.cat_id,
//m_category.cat_desc as mrn_type,
//t_mrn_header.mrn_no,
//t_mrn_header.mrn_date,
//t_mrn_header.bill_no,
//t_mrn_header.bill_date,
//po_header.po_no,
//po_header.po_frt_remark As remark,
//po_header.po_date,
//'Purchase' as type,
//m_vendor.vendor_id,
//m_vendor.vendor_id as supplier_id,
//m_vendor.vendor_code as supplier_code,
//m_vendor.vendor_name as supplier_name,
//m_vendor.vendor_add4 as supp_erp_code,
//m_vendor.vendor_gst_no as gst_no,
//m_vendor.vendor_state as state,
//m_item.item_id,
//m_item.item_wt as vendor_erp_code,
//m_item.item_desc as item_name,
//m_tax_form.tax_desc as hsn_code,
//dtl.mrn_qty as qty,
//dtl.item_uom as uom,
//dtl.item_rate as rate,
//(dtl.mrn_qty * dtl.item_rate)AS amount,
//dtl.sgst as sgst_per,
//dtl.cgst as cgst_per,
//dtl.igst as igst_per,
//0 as cess_per,
//0 as cess_rs,
//(((dtl.tax_value/2)/dtl.item_qty)*dtl.mrn_qty) as sgst_rs,
//(((dtl.tax_value/2)/dtl.item_qty)*dtl.mrn_qty) as cgst_rs ,
//(((dtl.tax_value)/dtl.item_qty)*dtl.mrn_qty) as igst_rs,
//dtl.disc_per as item_discount,
//dtl.disc_value as total_discount,
//dtl.pack_value,
//dtl.freight_value,
//dtl.insu,
//dtl.other_charges_befor,
//dtl.other_charges_after  
//FROM
//t_mrn_detail,
//t_mrn_header,
//po_header,
//po_detail,
//m_vendor,
//m_tax_form,
//indtrans,
//indent,
//m_category,
//m_item,
//t_bill_book_header head,
//t_bill_book_detail dtl
//WHERE
// head.bill_id=dtl.bill_id 
//AND dtl.mrn_detail_id=t_mrn_detail.mrn_detail_id          
//AND t_mrn_detail.mrn_id=t_mrn_header.mrn_id 
//AND po_header.po_id=t_mrn_detail.po_id 
//AND po_detail.po_detail_id=t_mrn_detail.po_detail_id 
//AND po_header.po_id=po_detail.po_id 
//AND m_vendor.vendor_id=head.vend_id 
//AND dtl.item_id=m_item.item_id 
//AND m_tax_form.tax_id=m_item.item_is_capital         
//AND indtrans.ind_d_id=po_detail.ind_id 
//AND indtrans.ind_m_id=indent.ind_m_id 
//AND indent.cat_id=m_category.cat_id 
//AND head.bill_id IN(11,12,13,17) 
//ORDER BY
//t_mrn_header.mrn_date
