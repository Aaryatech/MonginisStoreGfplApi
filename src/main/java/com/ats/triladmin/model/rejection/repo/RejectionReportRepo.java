package com.ats.triladmin.model.rejection.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.rejection.RejectionReport;

public interface RejectionReportRepo extends JpaRepository<RejectionReport, Integer> {

	@Query(value = "SELECT d.rej_detail_id,t.rejection_id,t.rejection_no,t.vendor_id,t.rejection_date,v.vendor_name,v.vendor_code,"
			+ "d.item_id,d.rejection_qty,d.memo_qty,d.mrn_no,d.mrn_date,i.item_code,i.item_desc FROM t_rejection_memo t,m_vendor v,"
			+ "t_rejection_memo_detail d,m_item i WHERE v.vendor_id=t.vendor_id AND t.rejection_date BETWEEN "
			+ " :fromDate AND :toDate AND t.is_used=1 AND d.is_used=1 AND t.rejection_id=d.rejection_id AND "
			+ "i.item_id=d.item_id GROUP BY d.rej_detail_id ORDER BY v.vendor_id" + " ", nativeQuery = true)
	List<RejectionReport> getRejectionMemoBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT d.rej_detail_id,t.rejection_id,t.rejection_no,t.vendor_id,t.rejection_date,v.vendor_name,v.vendor_code,"
			+ "d.item_id,d.rejection_qty,d.memo_qty,d.mrn_no,d.mrn_date,i.item_code,i.item_desc FROM t_rejection_memo t,m_vendor v,"
			+ "t_rejection_memo_detail d,m_item i WHERE v.vendor_id=t.vendor_id AND t.rejection_date BETWEEN "
			+ " :fromDate AND :toDate AND t.is_used=1 AND d.is_used=1 AND t.rejection_id=d.rejection_id AND "
			+ "i.item_id=d.item_id AND t.vendor_id IN(:vendorIdList) GROUP BY d.rej_detail_id ORDER BY v.vendor_id"
			+ " ", nativeQuery = true)
	List<RejectionReport> getRejectionMemoBetDateAndList(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("vendorIdList") List<Integer> vendorIdList);

	@Query(value = "SELECT d.rej_detail_id,t.rejection_id,t.rejection_no,t.vendor_id,t.rejection_date,v.vendor_name,"
			+ "v.vendor_code,d.item_id,d.rejection_qty,d.memo_qty,d.mrn_no,d.mrn_date,i.item_code,i.item_desc FROM"
			+ " t_rejection_memo t,m_vendor v,t_rejection_memo_detail d,m_item i WHERE v.vendor_id=t.vendor_id AND"
			+ " t.rejection_date BETWEEN :fromDate AND :toDate AND t.is_used=1 AND d.is_used=1 AND "
			+ "t.rejection_id=d.rejection_id AND i.item_id=d.item_id AND d.item_id IN(:itemIdList) GROUP BY d.rej_detail_id "
			+ "ORDER BY d.item_id" + " ", nativeQuery = true)
	List<RejectionReport> getRejectionMemoItemwise(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemIdList") List<Integer> itemIdList);

	@Query(value = "SELECT d.rej_detail_id,t.rejection_id,t.rejection_no,t.vendor_id,t.rejection_date,v.vendor_name,"
			+ "v.vendor_code,d.item_id,d.rejection_qty,d.memo_qty,d.mrn_no,d.mrn_date,i.item_code,i.item_desc FROM"
			+ " t_rejection_memo t,m_vendor v,t_rejection_memo_detail d,m_item i WHERE v.vendor_id=t.vendor_id AND"
			+ " t.rejection_date BETWEEN :fromDate AND :toDate AND t.is_used=1 AND d.is_used=1 AND "
			+ "t.rejection_id=d.rejection_id AND i.item_id=d.item_id GROUP BY d.rej_detail_id " + "ORDER BY d.item_id"
			+ " ", nativeQuery = true)
	List<RejectionReport> getAllRejectionMemoItemwise(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}
