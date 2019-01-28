package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.RejectionReportDetail;

public interface RejectionReportDetailRepo extends JpaRepository<RejectionReportDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_code,i.item_desc,i.item_uom FROM t_rejection_memo_detail d,m_item i WHERE  d.rejection_id IN(:rejectionIdList) AND i.item_id=d.item_id AND d.is_used=1", nativeQuery = true)
	List<RejectionReportDetail> getRejDetailReportList(@Param("rejectionIdList") List<Integer> rejectionIdList);

}
