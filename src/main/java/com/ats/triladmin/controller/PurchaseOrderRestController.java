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
import com.ats.triladmin.model.ErrorMessage;
import com.ats.triladmin.model.GetPODetail;
import com.ats.triladmin.model.GetPoDetailList;
import com.ats.triladmin.model.GetPoHeaderList;
import com.ats.triladmin.model.PoDetail;
import com.ats.triladmin.model.PoHeader;
import com.ats.triladmin.model.Vendor;
import com.ats.triladmin.model.getqueryitems.GetPoQueryItem;
import com.ats.triladmin.model.indent.IndentTrans;
import com.ats.triladmin.repository.GetPoDetailListRepository;
import com.ats.triladmin.repository.GetPoHeaderListRepository;
import com.ats.triladmin.repository.PoDetailRepository;
import com.ats.triladmin.repository.PoHeaderRepository;
import com.ats.triladmin.repository.VendorRepository;
import com.ats.triladmin.repository.getpodetail.GetPODetailRepo;
import com.ats.triladmin.repository.indent.IndentTransRepo;
import com.ats.triladmin.repository.queryitems.GetPoQueryItemRepo;

@RestController
public class PurchaseOrderRestController {

	@Autowired
	PoHeaderRepository poHeaderRepository;

	@Autowired
	PoDetailRepository poDetailRepository;

	@Autowired
	GetPODetailRepo getPODetailRepo;

	@Autowired
	GetPoHeaderListRepository getPoHeaderListRepository;

	@Autowired
	GetPoDetailListRepository getPoDetailListRepository;

	@Autowired
	IndentTransRepo indentTransRepo;
	
	@Autowired
	GetPoQueryItemRepo getPoQueryItemRepo;
	
	@Autowired
	VendorRepository vendorRepository;

	@RequestMapping(value = { "/getPODetailList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPODetail> getPODetails(@RequestParam("poIdList") List<Integer> poIdList) {

		System.err.println("Inside getPODetailList ");
		List<GetPODetail> poDetailList = new ArrayList<GetPODetail>();

		try {

			poDetailList = getPODetailRepo.getPoDetailsByPoIds(poIdList);
			System.err.println("poDetailList  " + poDetailList.toString());

		} catch (Exception e) {

			System.err.println("Exception /getPODetailList @PurchaseOrderRestControlle ");

			e.printStackTrace();

		}
		return poDetailList;

	}

	// Sachin 12-07-2018
	@RequestMapping(value = { "/getPOHeaderList" }, method = RequestMethod.POST)
	public @ResponseBody List<PoHeader> getPOHeaderList(@RequestParam("vendId") int vendId,
			@RequestParam("delStatus") int delStatus, @RequestParam("poType") int poType,
			@RequestParam("statusList") List<Integer> statusList) {

		List<PoHeader> poHeaderList = new ArrayList<PoHeader>();

		try {
			
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");

			poHeaderList = poHeaderRepository.findByVendIdAndDelStatusAndPoTypeAndPoStatusIn(vendId, delStatus, poType,
					statusList);
			
			for(int i =0 ; i<poHeaderList.size() ; i++) {
				
				List<Date> schDate = poHeaderRepository.getschDate(poHeaderList.get(i).getPoId());
				
				System.out.println(schDate);
				try {
					
					 poHeaderList.get(i).setOtherChargeBeforeRemark(sf.format(schDate.get(0)));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			

		} catch (Exception e) {

			System.err.println("Exception /getPOHeaderList @PurchaseOrderRestControlle ");

			e.printStackTrace();

		}
		return poHeaderList;

	}
	
	
	@RequestMapping(value = { "/getPoDetailScheduleDate" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage getPoDetailScheduleDate(  @RequestParam("poId") int poId ) {

		 ErrorMessage errorMessage = new ErrorMessage();

		try {
			
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");

			  
			 
				
				List<Date> schDate = poHeaderRepository.getschDate(poId);
				
				System.out.println(schDate);
				try {
					
					errorMessage.setMessage((sf.format(schDate.get(0))));
					errorMessage.setError(false);
				}catch(Exception e) {
					errorMessage.setError(true);
					e.printStackTrace();
				}
		 

		} catch (Exception e) {

			System.err.println("Exception /getPOHeaderList @PurchaseOrderRestControlle ");

			e.printStackTrace();

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/savePoHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody PoHeader savePoHeaderAndDetail(@RequestBody PoHeader poHeader) {

		PoHeader save = new PoHeader();

		try {

			save = poHeaderRepository.save(poHeader);

			for (int i = 0; i < poHeader.getPoDetailList().size(); i++) {
				poHeader.getPoDetailList().get(i).setPoId(save.getPoId());
				poHeader.getPoDetailList().get(i).setVendId(save.getVendId());
			}

			List<PoDetail> poDetailList = poDetailRepository.saveAll(poHeader.getPoDetailList());
			save.setPoDetailList(poDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}

	@RequestMapping(value = { "/deletePo" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deletePo(@RequestParam("poId") int poId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int delete = poHeaderRepository.delete(poId);
			if (delete != 0) {
				errorMessage.setError(false);
				errorMessage.setMessage("deleted");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getPoHeaderListBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeaderList> getPoHeaderListBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("catId") int catId,@RequestParam("typeId") int typeId) {

		List<GetPoHeaderList> list = new ArrayList<GetPoHeaderList>();

		try {
			
			
			if(catId!=0 && typeId!=0) {
				
				list = getPoHeaderListRepository.getPoHeaderListBetweenDateAndCatId(fromDate, toDate, catId,typeId);
			}else if(catId!=0 && typeId==0) {
				
				list = getPoHeaderListRepository.getPoHeaderListBetweenDateAndCatId(fromDate, toDate, catId);
			}else if(catId==0 && typeId!=0) {
				
				list = getPoHeaderListRepository.getPoHeaderListBetweenDateAndTypeId(fromDate, toDate, typeId);
			} else {
				
				list = getPoHeaderListRepository.getPoHeaderListBetweenDate(fromDate, toDate);
			}

			

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}
	
	@RequestMapping(value = { "/getPoHeaderListForApprove" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeaderList> getPoHeaderListForApprove(@RequestParam("status") List<Integer> status) {

		List<GetPoHeaderList> list = new ArrayList<GetPoHeaderList>();

		try {

			list = getPoHeaderListRepository.getPoHeaderListForApprove(status);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/getPoHeaderAndDetailByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody GetPoHeaderList getPoHeaderAndDetailByHeaderId(@RequestParam("poId") int poId) {

		GetPoHeaderList getPoHeaderList = new GetPoHeaderList();

		try {

			getPoHeaderList = getPoHeaderListRepository.getPoHeaderAndDetailByHeaderId(poId);

			List<GetPoDetailList> poDetailList = getPoDetailListRepository.getDetail(poId);
			getPoHeaderList.setPoDetailList(poDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getPoHeaderList;

	}

	@RequestMapping(value = { "/getPoHeaderListReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeaderList> getPoHeaderListReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("vendorIdList") List<Integer> vendorIdList,
			@RequestParam("poTypeList") List<Integer> poTypeList, @RequestParam("poStatus") List<Integer> poStatus) {

		List<GetPoHeaderList> list = new ArrayList<GetPoHeaderList>();

		try {
			if (vendorIdList.contains(0) && poTypeList.contains(0) && poStatus.contains(-1)) {

				list = getPoHeaderListRepository.getPoHeaderListBetweenDate(fromDate, toDate);
			} else if (vendorIdList.contains(0) && poTypeList.contains(0) && !poStatus.contains(-1)) {

				list = getPoHeaderListRepository.getPoHeaderByStatus(fromDate, toDate, poStatus);
			} else if (vendorIdList.contains(0) && !poTypeList.contains(0) && !poStatus.contains(-1)) {

				list = getPoHeaderListRepository.getPoHeaderByStatusAndPoTypeList(fromDate, toDate, poStatus,
						poTypeList);
			} else if (!vendorIdList.contains(0) && poTypeList.contains(0) && !poStatus.contains(-1)) {

				list = getPoHeaderListRepository.getPoHeaderByVendorAndPoType(fromDate, toDate, vendorIdList,
						poTypeList);
			}

			else if (!vendorIdList.contains(0) && poTypeList.contains(0) && poStatus.contains(-1)) {

				list = getPoHeaderListRepository.getPoHeaderByVendor(fromDate, toDate, vendorIdList);
			}

			else if (!vendorIdList.contains(0) && !poTypeList.contains(0) && poStatus.contains(-1)) {

				list = getPoHeaderListRepository.getPoHeaderByVendorAndPoTypeList(fromDate, toDate, poTypeList);
			}

			else {

				list = getPoHeaderListRepository.getPoHeaderByStatusAndPoTypeAndVendorList(fromDate, toDate, poStatus,
						poTypeList, vendorIdList);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/deletePoItem" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateIndendPendingQty(@RequestParam("poDetailId") int poDetailId) {

		ErrorMessage errorMessage = new ErrorMessage();
		try {

			poDetailRepository.delete(poDetailId);

			errorMessage.setError(false);
			errorMessage.setMessage("update");

		} catch (Exception e) {

			errorMessage.setError(true);
			errorMessage.setMessage("failed");

			e.printStackTrace();

		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/getPreviousRecordOfPoItem" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoQueryItem> getPreviousRecordOfPoItem(@RequestParam("itemId") int itemId) {
 
		List<GetPoQueryItem> getPreviousRecordOfPoItem = new ArrayList<GetPoQueryItem>();

		try {
 
			getPreviousRecordOfPoItem = getPoQueryItemRepo.getPreviousRecordOfPoItem(itemId);

			System.err.println(" getPoQueryItem  List " + getPreviousRecordOfPoItem.toString());
		} catch (Exception e) {
 
			e.printStackTrace();

		}

		return getPreviousRecordOfPoItem;

	}
	
	@RequestMapping(value = { "/updateStatusWhileApprov" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateStatusWhileApprov(@RequestParam("poId") int poId,
			@RequestParam("poDetalId") List<Integer> poDetalId,@RequestParam("status") int status) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int update = poHeaderRepository.updateStatusWhileApprov(poId,status); 
			
			/*for(int i=0 ; i<poDetalId.size() : i++)
			{
				
			}*/
			int updateDetail = poDetailRepository.updateStatusWhileApprov(poDetalId,status);
			
			errorMessage.setError(false);
			errorMessage.setMessage("approved");
			 
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed");

		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/getVendorByIndendId" }, method = RequestMethod.POST)
	public @ResponseBody List<Vendor> getVendorByIndendId(@RequestParam("indId") int indId) {

		List<Vendor> vendor = new ArrayList<>();
		try {
			vendor = vendorRepository.getVendorByIndendId(indId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vendor;

	}

}
