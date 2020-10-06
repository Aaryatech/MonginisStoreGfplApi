package com.ats.triladmin.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.common.DateConvertor;
import com.ats.triladmin.model.ErrorMessage;
import com.ats.triladmin.model.GetItem;
import com.ats.triladmin.model.Info;
import com.ats.triladmin.model.MrnInfo;
import com.ats.triladmin.model.PoDetail;
import com.ats.triladmin.model.PoHeader;
import com.ats.triladmin.model.TransModel;
import com.ats.triladmin.model.indent.DashIndentDetails;
import com.ats.triladmin.model.indent.GetIndents;
import com.ats.triladmin.model.mrn.GetMrnDetail;
import com.ats.triladmin.model.mrn.GetMrnDetailRej;
import com.ats.triladmin.model.mrn.GetMrnHeader;
import com.ats.triladmin.model.mrn.GetMrnHeaderRej;
import com.ats.triladmin.model.mrn.MrnDetail;
import com.ats.triladmin.model.mrn.MrnHeader;
import com.ats.triladmin.model.mrn.MrnReport;
import com.ats.triladmin.model.mrn.PoItemForMrnEdit;
import com.ats.triladmin.model.mrn.RateVerificationList;
import com.ats.triladmin.model.mrn.TempMrnItemDetail;
import com.ats.triladmin.model.mrn.VendorItemPurchaseReport;
import com.ats.triladmin.model.rejection.RejectionMemo;
import com.ats.triladmin.model.rejection.RejectionMemoDetail;
import com.ats.triladmin.model.rejection.repo.GetMrnDetailRejRepo;
import com.ats.triladmin.model.rejection.repo.GetMrnHeaderRejRepo;
import com.ats.triladmin.repository.GetItemRepository;
import com.ats.triladmin.repository.PoDetailRepository;
import com.ats.triladmin.repository.PoHeaderRepository;
import com.ats.triladmin.repository.RateVerificationListRepo;
import com.ats.triladmin.repository.VendorItemPurchaseReportRepo;
import com.ats.triladmin.repository.mrn.GetMrnDetailRepository;
import com.ats.triladmin.repository.mrn.GetMrnHeaderRepository;
import com.ats.triladmin.repository.mrn.MrnDetailRepo;
import com.ats.triladmin.repository.mrn.MrnHeaderRepository;
import com.ats.triladmin.repository.mrn.MrnInfoRepo;
import com.ats.triladmin.repository.mrn.MrnReportRepo;
import com.ats.triladmin.repository.mrn.PoItemForMrnEditRepo;
import com.ats.triladmin.repository.mrn.TempMrnItemDetailRepo;
import com.sun.org.apache.bcel.internal.util.SyntheticRepository;

@RestController
public class MrnApiController {

	@Autowired
	MrnHeaderRepository mrnHeaderRepository;

	@Autowired
	GetMrnHeaderRejRepo getMrnHeaderRejRepo;

	@Autowired
	GetMrnDetailRejRepo getMrnDetailRejRepo;

	@Autowired
	MrnDetailRepo mrnDetailRepo;

	@Autowired
	GetMrnHeaderRepository getMrnHeaderRepository;

	@Autowired
	GetMrnDetailRepository getMrnDetailRepository;

	@Autowired
	PoDetailRepository poDetailRepo;
	@Autowired
	PoHeaderRepository poHeaderRepository;

	@Autowired
	GetItemRepository getItemRepository;

	@Autowired
	PoItemForMrnEditRepo getPoItemForMrnEditRepo;

	@RequestMapping(value = { "/getOneMrnHeader" }, method = RequestMethod.POST)
	public @ResponseBody MrnHeader getMrnHeaderByMrnId(@RequestParam("mrnId") int mrnId) {
		System.err.println("inside web api save saveMrnHeadAndDetail");
		MrnHeader res = new MrnHeader();

		try {
			res = mrnHeaderRepository.findByMrnId(mrnId);

		} catch (Exception e) {

			System.err.println("Exce in /getMrnHeader @MrnApi  " + e.getMessage());
			e.printStackTrace();
		}

		return res;
	}

	@RequestMapping(value = { "/getPoItemForMrnEdit" }, method = RequestMethod.POST)
	public @ResponseBody List<PoItemForMrnEdit> getPoItemForMrnEdit(@RequestParam("mrnId") int mrnId) {

		List<PoItemForMrnEdit> poItemMrnEditList = new ArrayList<PoItemForMrnEdit>();
		try {

			poItemMrnEditList = getPoItemForMrnEditRepo.getPoItemForMrnEdit(mrnId);

		} catch (Exception e) {

			System.err.println("Exce in /getPoItemForMrnEdit @MrnApi  " + e.getMessage());
			e.printStackTrace();
		}

		return poItemMrnEditList;

	}

	@RequestMapping(value = { "/saveMrnHeadAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody MrnHeader saveMrnHeadAndDetail(@RequestBody MrnHeader mrnHeader) {
		System.err.println("inside web api save saveMrnHeadAndDetail");
		MrnHeader res = new MrnHeader();

		try {

			res = mrnHeaderRepository.saveAndFlush(mrnHeader);

			List<MrnDetail> mrnDetailList = mrnHeader.getMrnDetailList();

			int mrnId = res.getMrnId();
			String mrnNo = res.getMrnNo();
			String batchNo;

			for (int i = 0; i < mrnDetailList.size(); i++) {

				MrnDetail detail = mrnDetailList.get(i);

				GetItem item = getItemRepository.getItemByItemId(detail.getItemId());
				batchNo = new String();
				batchNo = mrnNo + "-" + item.getItemCode();

				detail.setBatchNo(batchNo);

				detail.setMrnId(mrnId);
				MrnDetail mrnDetailRes = mrnDetailRepo.save(detail);

				PoDetail poDetail = poDetailRepo.findByPoDetailId(mrnDetailRes.getPoDetailId());

				if (mrnDetailRes != null) {
					float remainingQty = 0;

					if (detail.getMrnQtyBeforeEdit() == -1) {

						System.err.println("Inside mrn qty before Edit ==-1");

						remainingQty = poDetail.getPendingQty() - mrnDetailRes.getMrnQty();

					} else {

						System.err.println("Inside mrn qty before edit is greater than 0");
						remainingQty = poDetail.getPendingQty()
								- (mrnDetailRes.getMrnQty() - detail.getMrnQtyBeforeEdit());

					}

					poDetail.setPendingQty(remainingQty);
					int status = 1;

					if (remainingQty <= 0) {
						System.err.println("Pending qty =0 keeping status=2");
						status = 2;
					}

					poDetail.setStatus(status);
					PoDetail poDetailStatusUpdate = poDetailRepo.save(poDetail);

					List<Integer> stss = new ArrayList<Integer>();
					stss.add(2);
					stss.add(9);
					stss.add(7);
					List<PoDetail> poDetailsList = poDetailRepo.findAllByStatusNotInAndPoId(stss,
							mrnDetailList.get(i).getPoId());

					if (poDetailsList.isEmpty()) {

						System.err.println("Po Detail list is Empty so Update po Header Status for POId "
								+ mrnDetailList.get(i).getPoId());

						int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(2,
								mrnDetailList.get(i).getPoId());

					} else {
						List<Integer> sts = new ArrayList<Integer>();
						sts.add(0);
						sts.add(1);
						List<PoDetail> details = poDetailRepo
								.findAllByPoIdAndStatusNotIn(mrnDetailList.get(i).getPoId(), sts);
						poDetailsList = new ArrayList<PoDetail>();

						poDetailsList = poDetailRepo.findAllByStatusAndPoId(1, mrnDetailList.get(i).getPoId());

						if (poDetailsList.isEmpty()) {

							int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(0,
									mrnDetailList.get(i).getPoId());

						} else {
							int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(1,
									mrnDetailList.get(i).getPoId());
						}
					}

				}

			}

		} catch (Exception e) {

			System.err.println("Exception in saving Mrn Header and Detail  " + e.getMessage());
			e.printStackTrace();

		}

		return res;
	}

	@RequestMapping(value = { "/getMrnHeaderList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnHeader> getMrnHeaderList(@RequestParam("venId") List<Integer> venId,
			@RequestParam("status") List<Integer> status) {

		List<GetMrnHeader> mrnHeaderList = new ArrayList<GetMrnHeader>();

		try {
			if (venId.contains(0) && !status.contains(-1)) {
				mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByStatus(status);
				System.err.println("a");
			} else if (!venId.contains(0) && status.contains(-1)) {
				System.err.println("b");
				mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByVenId(venId);

			} else if (!venId.contains(0) && !status.contains(-1)) {
				System.err.println("c");
				mrnHeaderList = getMrnHeaderRepository.getMrnHeaderListByVenIdAndStatus(venId, status);
			} else if (venId.contains(0) && status.contains(-1)) {
				System.err.println("d");
				mrnHeaderList = getMrnHeaderRepository.getAllMrnHeaderList();
			}
			if (mrnHeaderList.size() > 0) {
				for (int i = 0; i < mrnHeaderList.size(); i++) {
					List<GetMrnDetail> getMrnDetailList = getMrnDetailRepository
							.getMrnDetailList(mrnHeaderList.get(i).getMrnId(), 0);

					mrnHeaderList.get(i).setGetMrnDetailList(getMrnDetailList);
				}
			}
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	@RequestMapping(value = { "/getMrnHeader" }, method = RequestMethod.POST)
	public @ResponseBody GetMrnHeader getMrnHeader(@RequestParam("mrnId") int mrnId) {

		GetMrnHeader mrnHeader = new GetMrnHeader();

		try {
			mrnHeader = getMrnHeaderRepository.findByMrnId(mrnId);
			if (mrnHeader != null) {

				List<GetMrnDetail> getMrnDetailList = getMrnDetailRepository.getMrnDetailList(mrnId);

				mrnHeader.setGetMrnDetailList(getMrnDetailList);

			}
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeader;

	}

	// check unique bill_no Neha ---28/06/2019
	@RequestMapping(value = { "/getMrnHeaderByVendIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnHeader> getMrnHeaderByVendIdAndDate(@RequestParam("vendId") int vendId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("billNo") String billNo) {

		System.out.println(fromDate);
		System.out.println(toDate);
		System.out.println(billNo);
		System.out.println(vendId);

		List<MrnHeader> mrnHeaderList = new ArrayList<>();

		try {
			mrnHeaderList = mrnHeaderRepository.getMrnHeaderByVendIdAndDate(vendId, fromDate, toDate, billNo);

		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	@RequestMapping(value = { "/getMrnHeaderForApprove" }, method = RequestMethod.POST)
	public @ResponseBody GetMrnHeader getMrnHeaderForApprove(@RequestParam("mrnId") int mrnId) {

		GetMrnHeader mrnHeader = new GetMrnHeader();

		try {
			mrnHeader = getMrnHeaderRepository.findByMrnId(mrnId);
			if (mrnHeader != null) {

				List<GetMrnDetail> getMrnDetailList = getMrnDetailRepository.getMrnDetailListForApprove(mrnId);

				mrnHeader.setGetMrnDetailList(getMrnDetailList);

			}
		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeader;

	}

	// Sachin 28-07-2020

	@RequestMapping(value = { "/savePoMrnCommon" }, method = RequestMethod.POST)
	public @ResponseBody Info savePoMrnCommon(@RequestBody TransModel transModel) {

		Info info = new Info();

		List<PoDetail> poResList = new ArrayList<>();
		List<MrnDetail> mrnInputList = transModel.getMrnDetailList();

		try {
			String mrnNo = mrnRepo.getMrnNoByMrnId(mrnInputList.get(0).getMrnId());

			List<PoDetail> poDetList = transModel.getPoDetailList();
			poResList = poDetailRepo.saveAll(poDetList);
			poHeaderRepository.updatePoHeaderBasicAndTaxValue(transModel.getPoHeader().getPoBasicValue(),
					transModel.getPoHeader().getPoTaxValue(), transModel.getPoHeader().getPoId());

			for (int i = 0; i < poResList.size(); i++) {

				for (int j = 0; j < mrnInputList.size(); j++) {

					Integer isMatched = Integer.compare(poResList.get(i).getItemId(), mrnInputList.get(j).getItemId());

					if (isMatched.equals(0)) {
						// if (poResList.get(i).getItemId() == mrnInputList.get(j).getItemId()) {

						mrnInputList.get(j).setPoDetailId(poResList.get(i).getPoDetailId());
						GetItem item = getItemRepository.getItemByItemId(mrnInputList.get(j).getItemId());
						String batchNo = new String();
						batchNo = mrnNo + "-" + item.getItemCode();
						mrnInputList.get(j).setBatchNo(batchNo);
						MrnDetail mrnDetailSaveRes = mrnDetailRepo.save(mrnInputList.get(j));
						break;
					}

				} // end of mrnInputList

			} // end of poResList

			info.setError(false);
			info.setMessage("success");
		} catch (Exception e) {
			info.setError(true);
			info.setMessage("exception");
			System.err.println("Exception in saving Mrn Header and Detail  " + e.getMessage());
			e.printStackTrace();

		}

		return info;
	}

	@RequestMapping(value = { "/saveMrnData" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnDetail> saveMrnData(@RequestBody List<MrnDetail> getMrnDetailList) {
		List<MrnDetail> res = new ArrayList<>();

		try {

			int mrnId = getMrnDetailList.get(0).getMrnId();
			boolean flag = false;
			for (int i = 0; i < getMrnDetailList.size(); i++) {

				MrnDetail mrnDetail = new MrnDetail();
				mrnDetail.setMrnDetailId(getMrnDetailList.get(i).getMrnDetailId());
				mrnDetail.setApproveQty(getMrnDetailList.get(i).getApproveQty());
				mrnDetail.setBatchNo(getMrnDetailList.get(i).getBatchNo());
				mrnDetail.setDelStatus(getMrnDetailList.get(i).getDelStatus());
				mrnDetail.setIndentQty(getMrnDetailList.get(i).getIndentQty());
				mrnDetail.setIssueQty(getMrnDetailList.get(i).getIssueQty());
				mrnDetail.setItemId(getMrnDetailList.get(i).getItemId());
				mrnDetail.setMrnDetailStatus(getMrnDetailList.get(i).getMrnDetailStatus());
				mrnDetail.setMrnId(getMrnDetailList.get(i).getMrnId());
				mrnDetail.setMrnQty(getMrnDetailList.get(i).getMrnQty());
				mrnDetail.setPoId(getMrnDetailList.get(i).getPoId());
				mrnDetail.setPoNo(getMrnDetailList.get(i).getPoNo());
				mrnDetail.setPoQty(getMrnDetailList.get(i).getPoQty());
				mrnDetail.setRejectQty(getMrnDetailList.get(i).getRejectQty());
				mrnDetail.setRejectRemark(getMrnDetailList.get(i).getRejectRemark());
				mrnDetail.setRemainingQty(getMrnDetailList.get(i).getRemainingQty());
				mrnDetail.setMrnDetailStatus(1);
				mrnDetail.setPoDetailId(getMrnDetailList.get(i).getPoDetailId());
				mrnDetail.setChalanQty(getMrnDetailList.get(i).getChalanQty());
				mrnDetail.setMrnId(getMrnDetailList.get(i).getMrnId());
				MrnDetail transRes = mrnDetailRepo.save(mrnDetail);
				flag = true;
				res.add(transRes);
			}
			if (flag == true) {
				int isUpdated = mrnHeaderRepository.updateMrnStatusAsPartial(mrnId);
			}
			int count = mrnDetailRepo.getDetailCount(mrnId);
			System.err.println(count);
			if (count == 0) {
				int isUpdated = mrnHeaderRepository.updateMrnStatus(mrnId);
			}

		} catch (Exception e) {

			System.err.println("Exception in saving Mrn Header and Detail  " + e.getMessage());
			e.printStackTrace();

		}

		return res;
	}

	@RequestMapping(value = { "/updateMRNStatusById" }, method = RequestMethod.POST)
	public int updateMRNstatusbyid(@RequestBody int mrnId) {

		int isUpdated = mrnHeaderRepository.updateMrnStatusAccount(mrnId);
		return isUpdated;
	}

	@RequestMapping(value = { "/getMrnHeaderByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnHeader> getMrnHeaderByDate(@RequestParam("grnType") int grnType,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetMrnHeader> mrnHeaderList = new ArrayList<GetMrnHeader>();

		try {

			if (grnType == -1) {
				System.err.println("Grn type ==-1 on page load call");

				mrnHeaderList = getMrnHeaderRepository.getMrnHeaderByDate(fromDate, toDate);

			} else {
				mrnHeaderList = getMrnHeaderRepository.getMrnHeaderByDate(grnType, fromDate, toDate);
			}
			System.err.println("mrn Head List by Date =  " + mrnHeaderList.toString());

		} catch (Exception e) {

			System.err.println("Exception in getMrnHeaderByDate Mrn  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	@Autowired
	MrnReportRepo mrnReportrRepo;

	@RequestMapping(value = { "/getMrnHeadReport" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnReport> getMrnHeadReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("grnTypeList") List<String> grnTypeList,
			@RequestParam("vendorIdList") List<String> vendorIdList,
			@RequestParam("statusList") List<String> statusList) {

		List<MrnReport> mrnHeaderList = new ArrayList<MrnReport>();

		try {
			System.err.println("Input getMrnHeadReport  grnTypeList " + grnTypeList + "vendorIdList " + vendorIdList
					+ "statusList " + statusList);

			if (vendorIdList.contains("-1")) {
				System.err.println("Vendor Id List Contain -1");

			}

			if (grnTypeList.contains("-1")) {
				System.err.println("grnTypeList  List Contain -1");

			}

			if (statusList.contains("-1")) {
				System.err.println("status   List Contain -1");
			}

			if (vendorIdList.contains("-1")) {

				System.err.println("All Vendor Selected");
				mrnHeaderList = mrnReportrRepo.getMrnReportAllVendor(fromDate, toDate, grnTypeList, statusList);

			}

			else {
				System.err.println("few Vendor Selected ");
				mrnHeaderList = mrnReportrRepo.getMrnReport(vendorIdList, grnTypeList, statusList, fromDate, toDate);

			}

			System.err.println("mrn Head List Report  Size=  " + mrnHeaderList.size());

			System.err.println("mrn Head List Report =  " + mrnHeaderList.toString());

		} catch (Exception e) {

			System.err.println("Exception in getMrnHeaderReport Mrn  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	@RequestMapping(value = { "/getMrnDetailByMrnId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnDetail> getMrnDetailByMrnId(@RequestParam("mrnId") int mrnId) {

		List<GetMrnDetail> mrnDetailList = new ArrayList<GetMrnDetail>();

		try {
			mrnDetailList = getMrnDetailRepository.getMrnDetailByMrnId(mrnId);
			System.err.println("mrn mrnDetailList List by MrnId =  " + mrnDetailList.toString());

		} catch (Exception e) {

			System.err.println("Exception in getMrnDetailByMrnId Mrn  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnDetailList;

	}

	@RequestMapping(value = { "/getMrnList" }, method = RequestMethod.GET)
	public @ResponseBody List<MrnHeader> getMrnList() {

		List<MrnHeader> mrnHeaderList = new ArrayList<MrnHeader>();

		try {

			mrnHeaderList = mrnHeaderRepository.findAllByDelStatus(1);

		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	@RequestMapping(value = { "/getMrnListByVendorIdForRejectionMemo" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnHeader> getMrnListByVendorIdForRejectionMemo(@RequestParam("vendId") int vendId) {

		List<MrnHeader> mrnHeaderList = new ArrayList<MrnHeader>();

		try {

			mrnHeaderList = mrnHeaderRepository.getMrnListByVendorIdForRejectionMemo(vendId);

		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	// Neha
	@RequestMapping(value = { "/getMrnHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnHeaderRej> getMrnHeaderDetail(@RequestParam("status") List<Integer> status) {

		List<GetMrnHeaderRej> mrnHeaderList = new ArrayList<GetMrnHeaderRej>();

		try {

			mrnHeaderList = getMrnHeaderRejRepo.getMrnHeaderByList(status);
			// List<GetMrnDetailRej> getMrnDetailList =
			// getMrnDetailRejRepo.getMrnDetailByList(status);

			for (int i = 0; i < mrnHeaderList.size(); i++) {

				int mrnId = mrnHeaderList.get(i).getMrnId();

				List<GetMrnDetailRej> getMrnDetailList = getMrnDetailRejRepo.getMrnDetailByList(mrnId);

				mrnHeaderList.get(i).setGetMrnDetailRejList(getMrnDetailList);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mrnHeaderList;

	}

	@RequestMapping(value = { "/getMrnListByVendorIdForRejectionMemoForPune" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnHeader> getMrnListByVendorIdForRejectionMemo(@RequestParam("vendId") int vendId,
			@RequestParam("itemId") int itemId) {

		List<MrnHeader> mrnHeaderList = new ArrayList<MrnHeader>();

		try {

			mrnHeaderList = mrnHeaderRepository.getMrnListByVendorIdForRejectionMemo(vendId, itemId);

		} catch (Exception e) {

			System.err.println("Exception in getIndents Indent  " + e.getMessage());

			e.printStackTrace();

		}

		return mrnHeaderList;

	}

	// akshay
	@RequestMapping(value = { "/getMrnHeaderDetailForPune" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMrnHeaderRej> getMrnHeaderDetail(@RequestParam("status") List<Integer> mrnIds,
			@RequestParam("itemId") int itemId) {

		List<GetMrnHeaderRej> mrnHeaderList = new ArrayList<GetMrnHeaderRej>();

		try {

			mrnHeaderList = getMrnHeaderRejRepo.getMrnHeaderByList(mrnIds);
			// List<GetMrnDetailRej> getMrnDetailList =
			// getMrnDetailRejRepo.getMrnDetailByList(status);

			for (int i = 0; i < mrnHeaderList.size(); i++) {

				int mrnId = mrnHeaderList.get(i).getMrnId();

				List<GetMrnDetailRej> getMrnDetailList = getMrnDetailRejRepo.getMrnDetailByList(mrnId, itemId);

				mrnHeaderList.get(i).setGetMrnDetailRejList(getMrnDetailList);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mrnHeaderList;

	}

	@RequestMapping(value = { "/deleteMrnHeader" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteMrnHeader(@RequestParam("mrnId") int mrnId) {
		System.err.println("inside web api  deleteMrnHeader");
		ErrorMessage errMsg = new ErrorMessage();

		try {

			int delRes = mrnHeaderRepository.deleteMrnHeader(mrnId);
			List<MrnDetail> mrnDetailList = mrnDetailRepo.findByMrnIdAndDelStatus(mrnId, 1);

			System.err.println("Mrn detail in deleteMrnHeader " + mrnDetailList.toString());

			for (int i = 0; i < mrnDetailList.size(); i++) {

				PoDetail poDetail = poDetailRepo.findByPoDetailId(mrnDetailList.get(i).getPoDetailId());
				//

				float remainingQty = 0;

				remainingQty = poDetail.getPendingQty() + mrnDetailList.get(i).getMrnQty();

				poDetail.setPendingQty(remainingQty);

				int status = 1;

				if (remainingQty <= 0) {
					System.err.println("Pending qty =0 keeping status=2");
					status = 2;
				} else if (remainingQty == poDetail.getItemQty()) {

					status = 0;
				}

				poDetail.setStatus(status);
				PoDetail poDetailStatusUpdate = poDetailRepo.save(poDetail);
				List<Integer> stss = new ArrayList<Integer>();
				stss.add(2);
				stss.add(9);
				stss.add(7);
				List<PoDetail> poDetailsList = poDetailRepo.findAllByStatusNotInAndPoId(stss,
						mrnDetailList.get(i).getPoId());

				if (poDetailsList.isEmpty()) {

					System.err.println("Po Detail list is Empty so Update po Header Status for POId "
							+ mrnDetailList.get(i).getPoId());

					int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(2,
							mrnDetailList.get(i).getPoId());

				} else {
					List<Integer> sts = new ArrayList<Integer>();
					sts.add(0);
					sts.add(1);
					List<PoDetail> details = poDetailRepo.findAllByPoIdAndStatusNotIn(mrnDetailList.get(i).getPoId(),
							sts);
					poDetailsList = new ArrayList<PoDetail>();

					poDetailsList = poDetailRepo.findAllByStatusAndPoId(1, mrnDetailList.get(i).getPoId());

					if (poDetailsList.isEmpty()) {

						int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(0,
								mrnDetailList.get(i).getPoId());

					} else {
						int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(1,
								mrnDetailList.get(i).getPoId());
					}
				}

				//

			}

			if (delRes > 0) {
				errMsg.setError(false);
				errMsg.setMessage("Mrn Header deleted Successfull");
			} else {
				errMsg.setError(true);
				errMsg.setMessage("Mrn Header delete failed ");
			}

		} catch (Exception e) {

			System.err.println("Exception in deleteMrnHeader  " + e.getMessage());
			e.printStackTrace();

		}

		return errMsg;
	}

	@RequestMapping(value = { "/deleteMrnDetail" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteMrnDetail(@RequestParam("mrnDetailId") int mrnDetailId) {
		System.err.println("inside web api  deleteMrnDetail");
		ErrorMessage errMsg = new ErrorMessage();

		try {

			int delRes = mrnDetailRepo.deleteMrnDetail(mrnDetailId);

			MrnDetail mrnDetailRes = mrnDetailRepo.findByMrnDetailIdAndDelStatus(mrnDetailId, 0);

			//

			// MrnDetail mrnDetailRes = mrnDetailRepo.save(detail);

			PoDetail poDetail = poDetailRepo.findByPoDetailId(mrnDetailRes.getPoDetailId());

			if (mrnDetailRes != null) {
				float remainingQty = 0;
				System.err.println("Inside mrn qty before edit is greater than 0");
				remainingQty = poDetail.getPendingQty() + mrnDetailRes.getMrnQty();

				poDetail.setPendingQty(remainingQty);
				int status = 1;

				if (remainingQty <= 0) {
					System.err.println("Pending qty =0 keeping status=2");
					status = 2;
				} else if (remainingQty == poDetail.getItemQty()) {

					status = 0;
				}

				poDetail.setStatus(status);
				PoDetail poDetailStatusUpdate = poDetailRepo.save(poDetail);

				List<Integer> stss = new ArrayList<Integer>();
				stss.add(2);
				stss.add(9);
				stss.add(7);
				List<PoDetail> poDetailsList = poDetailRepo.findAllByStatusNotInAndPoId(stss, mrnDetailRes.getPoId());

				if (poDetailsList.isEmpty()) {

					System.err.println(
							"Po Detail list is Empty so Update po Header Status for POId " + mrnDetailRes.getPoId());

					int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(2, mrnDetailRes.getPoId());

				} else {
					List<Integer> sts = new ArrayList<Integer>();
					sts.add(0);
					sts.add(1);
					List<PoDetail> details = poDetailRepo.findAllByPoIdAndStatusNotIn(mrnDetailRes.getPoId(), sts);
					poDetailsList = new ArrayList<PoDetail>();

					poDetailsList = poDetailRepo.findAllByStatusAndPoId(1, mrnDetailRes.getPoId());

					if (poDetailsList.isEmpty()) {

						int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(0, mrnDetailRes.getPoId());

					} else {
						int updatePoHeaderStatus = poHeaderRepository.updateResponsePoHead(1, mrnDetailRes.getPoId());
					}
				}

			}

			//

			if (delRes > 0) {
				errMsg.setError(false);
				errMsg.setMessage("Mrn Detail deleted Successfull");
			} else {
				errMsg.setError(true);
				errMsg.setMessage("Mrn Detail delete failed ");
			}

		} catch (Exception e) {

			System.err.println("Exception in deleteMrnHeader  " + e.getMessage());
			e.printStackTrace();

		}

		return errMsg;
	}

	@RequestMapping(value = { "/updateStatusWhileMrnApprov" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateStatusWhileMrnApprov(@RequestParam("mrnId") int mrnId,
			@RequestParam("mrnDetalId") List<Integer> mrnDetalId, @RequestParam("status") int status) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int update = mrnHeaderRepository.updateStatusWhileApprov(mrnId, status);

			/*
			 * for(int i=0 ; i<poDetalId.size() : i++) {
			 * 
			 * }
			 */
			int updateDetail = mrnDetailRepo.updateStatusWhileApprov(mrnDetalId, status);

			errorMessage.setError(false);
			errorMessage.setMessage("approved");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getDeptAndSubDeptFromIndentByPoId" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage updateStatusWhileMrnApprov(@RequestParam("poId") int poId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			String deptId = mrnHeaderRepository.getDeptId(poId);

			String suDeptId = mrnHeaderRepository.getSubDept(poId);

			String accHead = mrnHeaderRepository.getAccHead(poId);

			errorMessage.setError(false);
			errorMessage.setMessage(deptId + "," + suDeptId + "," + accHead);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed");

		}
		return errorMessage;

	}

	/*******************************************************************************/
	// Mahendra
	// 02-01-2020
	@Autowired
	MrnInfoRepo mrnRepo;

	@RequestMapping(value = { "/getMrnDetails" }, method = RequestMethod.GET)
	public @ResponseBody List<MrnInfo> getMrnDetails() {

		List<MrnInfo> list = new ArrayList<MrnInfo>();

		try {

			list = mrnRepo.getMrnData();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@Autowired
	RateVerificationListRepo rateVarRepo;

	@RequestMapping(value = { "/getAllVendorItem" }, method = RequestMethod.POST)
	public @ResponseBody List<RateVerificationList> getAllVendorItem(@RequestParam int vendrId) {

		List<RateVerificationList> list = new ArrayList<RateVerificationList>();

		try {

			list = rateVarRepo.getVendorItemsList(vendrId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@Autowired
	VendorItemPurchaseReportRepo vipRepo;

	@RequestMapping(value = { "/getVendorItemPuchaseList" }, method = RequestMethod.POST)
	public @ResponseBody List<VendorItemPurchaseReport> getVendorItemPuchaseList(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam int vendrId,
			@RequestParam("itemsList") List<Integer> itemsList) {

		List<VendorItemPurchaseReport> list = new ArrayList<VendorItemPurchaseReport>();

		try {

			list = vipRepo.getVendorItemPurchaseReport(fromDate, toDate, vendrId, itemsList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/getMrnHeadCountForBillNoAndDateVendId" }, method = RequestMethod.POST)
	public @ResponseBody Integer getMrnCountForSameBillNoByVendAndDate(@RequestParam String billDate,
			@RequestParam String billNo, @RequestParam int vendrId) {

		Integer mrnCount = 0;

		try {

			mrnCount = mrnHeaderRepository.getMrnHeadCountForBillNoAndDateVendId(vendrId, billNo, billDate);

		} catch (Exception e) {
			mrnCount = 0;
			e.printStackTrace();

		}
		return mrnCount;

	}

	// Sachin 29-08-2020

	@RequestMapping(value = { "/getMrnDetailObj" }, method = RequestMethod.POST)
	public @ResponseBody MrnDetail getMrnDetailObj(@RequestParam int mrnDetailId) {

		Integer mrnCount = 0;
		MrnDetail mrnDetailRes = null;

		try {

			mrnDetailRes = mrnDetailRepo.findByMrnDetailIdAndDelStatus(mrnDetailId, 1);

		} catch (Exception e) {
			mrnDetailRes = new MrnDetail();
			e.printStackTrace();

		}
		return mrnDetailRes;

	}

	@RequestMapping(value = { "/updateStoreMrnInspec" }, method = RequestMethod.POST)
	public @ResponseBody List<MrnDetail> updateStoreMrnInspec(@RequestBody List<TempMrnItemDetail> getMrnDetailList) {
		List<MrnDetail> res = new ArrayList<>();
		System.err.println("input list  " + getMrnDetailList.toString());
		List<MrnDetail> outputList = new ArrayList<>();
		try {

			int mrnId = getMrnDetailList.get(0).getMrnId();
			boolean flag = false;

			List<Integer> mrdDetailIdList = new ArrayList<Integer>();

			for (int i = 0; i < getMrnDetailList.size(); i++) {
				mrdDetailIdList.add(getMrnDetailList.get(i).getMrnDetailId());
			}

			Set<Integer> set = new LinkedHashSet<>();
			set.addAll(mrdDetailIdList);

			mrdDetailIdList.clear();

			mrdDetailIdList.addAll(set);
			res = mrnDetailRepo.getMrnDetailListByMrnDetailIdAndHeaderItem1(mrdDetailIdList);
			System.err.println("res list  " + res.toString());
			for (MrnDetail mrn : res) {
				// outputList.add(res.get(a));
				//float totalAprQty = 0.0f;
				float	totalAprQty = mrn.getApproveQty();
				float tot=0.0f;
				for (int i = 0; i < getMrnDetailList.size(); i++) {
					Integer isFound = Integer.compare(mrn.getMrnDetailId(), getMrnDetailList.get(i).getMrnDetailId());
					if (isFound.equals(0)) {
						// if (mrn.getMrnDetailId() == getMrnDetailList.get(i).getMrnDetailId()) {
						// MrnDetail mrnDetail1 = new MrnDetail();
						// mrnDetail1 =
						// mrnDetailRepo.findByMrnDetailId(getMrnDetailList.get(i).getMrnDetailId());
						try {
							if (getMrnDetailList.get(i).getUuid() != null) {
								System.err.println("In IF Bacth/UUID not null");
								totalAprQty = totalAprQty + getMrnDetailList.get(i).getApproveQty();
								flag = true;
							} else {
								System.err.println("In else Bacth/UUID null");
								UUID uuid = UUID.randomUUID();
								// Generates random UUID
								MrnDetail mrnDetail = new MrnDetail();
								// mrnDetail = mrn;
								mrnDetail.setMrnDetailId(0);
								mrnDetail.setBatchNo(mrn.getBatchNo() + "-" + getMrnDetailList.get(i).getExpDate());
								mrnDetail.setChalanQty(mrn.getChalanQty());
								mrnDetail.setDelStatus(mrn.getDelStatus());
								mrnDetail.setIndentQty(mrn.getIndentQty());
								mrnDetail.setIssueQty(mrn.getIssueQty());
								mrnDetail.setItemId(mrn.getItemId());
								mrnDetail.setMrnDetailStatus(1);
								mrnDetail.setMrnId(mrnId);
								mrnDetail.setMrnQty(mrn.getMrnQty());
								// mrnDetail.setMrnQtyBeforeEdit(mrnQtyBeforeEdit);
								mrnDetail.setPoDetailId(mrn.getPoDetailId());
								mrnDetail.setPoId(mrn.getPoId());
								mrnDetail.setPoNo(mrn.getPoNo());
								mrnDetail.setPoQty(mrn.getPoQty());
								mrnDetail.setRejectQty(mrn.getRejectQty());
								mrnDetail.setRejectRemark(mrn.getRejectRemark());

								mrnDetail.setRemainingQty(getMrnDetailList.get(i).getApproveQty());

								mrnDetail.setApproveQty(getMrnDetailList.get(i).getApproveQty());
								mrnDetail.setExpDate(DateConvertor.convertToYMD(getMrnDetailList.get(i).getExpDate()));
								mrnDetail.setIsHeaderItem(0);// To be renamed as is_header_item
								mrnDetail.setUuid(uuid.toString());

								MrnDetail transRes = mrnDetailRepo.saveAndFlush(mrnDetail);
								System.err.println("transRes " +transRes.toString());
								totalAprQty =  totalAprQty + transRes.getApproveQty();
								flag = true;
								outputList.add(transRes);
							}
						} catch (Exception e) {
							System.err.println("In Bacth/UUID not null exce");
							totalAprQty = totalAprQty + getMrnDetailList.get(i).getApproveQty();
							flag = true;
						}

						// res.add(transRes);
					}
				} // end of inner for
				System.err.println("totalAprQty " + totalAprQty + " for Mrn Detail " + mrn.getMrnDetailId());
				mrn.setApproveQty(totalAprQty);
				mrn.setMrnDetailStatus(1);
				MrnDetail updateMrnItemHead = mrnDetailRepo.saveAndFlush(mrn);
				System.err.println("updateMrnItemHead " + updateMrnItemHead.toString());

			} // end of outer for

			System.err.println("Test Mrn Detail " + outputList.toString());
			// if (1 == 2) {
			if (flag == true) {
				int isUpdated = mrnHeaderRepository.updateMrnStatusAsPartial(mrnId);
			}

			int count = mrnDetailRepo.getDetailCount(mrnId);

			System.err.println(count);

			if (count == 0) {
				//int isUpdated = mrnHeaderRepository.updateMrnStatus(mrnId);
			}
			// }

		} catch (Exception e) {

			System.err.println("Exception in saving Mrn Header and Detail  " + e.getMessage());
			e.printStackTrace();

		}

		return res;
	}

	// Sachin 03-09-2020
	@Autowired
	TempMrnItemDetailRepo tempMrnItemDetRepo;

	@RequestMapping(value = { "/getTempMrnItemDetailByMrnId" }, method = RequestMethod.POST)
	public @ResponseBody List<TempMrnItemDetail> getTempMrnItemDetail(@RequestParam("mrnId") int mrnId) {

		List<TempMrnItemDetail> mrnDetList = new ArrayList<TempMrnItemDetail>();
		try {
			mrnDetList = tempMrnItemDetRepo.getTempMrnItemDetail(mrnId);
		} catch (Exception e) {
			mrnDetList = new ArrayList<TempMrnItemDetail>();
			System.err.println(" Exception in getTempMrnItemDetail  " + e.getMessage());
			e.printStackTrace();
		}
		return mrnDetList;
	}

	// Sachin 03-09-2020
	@RequestMapping(value = { "/deleteMrnItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMrnItemDetail(@RequestParam int mrnDetailId) {

		Info info = new Info();
		try {
			mrnDetailRepo.deleteById(mrnDetailId);
			info.setError(false);
		} catch (Exception e) {
			info.setError(true);
		}
		return info;
	}
	
	// Sachin 06-10-2020
	@RequestMapping(value = { "/updateMrnAprQtyForInspeDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info updateMrnAprQtyForInspeDetail(@RequestParam int mrnId,
			@RequestParam float aprQty,@RequestParam int itemId) {
System.err.println("In Update ");
		Info info = new Info();
		try {
			MrnDetail mrn=mrnDetailRepo.findByMrnIdAndDelStatusAndIsHeaderItemAndItemId(mrnId,1,1,itemId);
			System.err.println("MRN "+mrn.toString());
			mrn.setApproveQty(mrn.getApproveQty()-aprQty);
			mrn.setMrnDetailStatus(1);
			MrnDetail updateMrnItemHead = mrnDetailRepo.saveAndFlush(mrn);
			System.err.println("updateMrnItemHead"+updateMrnItemHead.toString());
			info.setError(false);
		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
		}
		return info;
	}
	
}
