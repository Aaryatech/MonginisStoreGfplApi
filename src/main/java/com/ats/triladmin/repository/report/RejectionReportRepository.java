package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.RejectionReport;

public interface RejectionReportRepository extends JpaRepository<RejectionReport, Integer> {

	@Query(value = "SELECT d.rej_detail_id, t.*,d.item_id,d.rejection_qty,d.memo_qty,d.mrn_date,i.item_code,i.item_desc,"
			+ "v.vendor_add1,v.vendor_name,v.vendor_code FROM t_rejection_memo t,t_rejection_memo_detail d,m_vendor v,"
			+ "m_item i WHERE v.vendor_id=t.vendor_id AND t.rejection_id=d.rejection_id AND t.rejection_id IN(:rejectionIdList) AND "
			+ "i.item_id=d.item_id AND t.is_used=1", nativeQuery = true)
	List<RejectionReport> getRejReportList(@Param("rejectionIdList") List<Integer> rejectionIdList);

	@Query(value = "SELECT  t.*,v.vendor_add1,v.vendor_name,v.vendor_code FROM t_rejection_memo t,m_vendor v WHERE v.vendor_id=t.vendor_id AND t.rejection_id IN(:rejectionIdList) AND t.is_used=1", nativeQuery = true)
	List<RejectionReport> getRejHeaderReportList(@Param("rejectionIdList") List<Integer> rejectionIdList);

}
