package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.ApproveStatusMrnReportDetail;

public interface ApproveMrnDetailRepository extends JpaRepository<ApproveStatusMrnReportDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_desc,i.item_code,i.item_uom,po.sch_remark,po.sch_days FROM t_mrn_detail d ,m_item i,po_detail"
			+ " po WHERE d.del_status=1 AND d.mrn_id IN(:mrnIdList)  AND i.item_id=d.item_id AND d.po_detail_id=po.po_detail_id", nativeQuery = true)
	List<ApproveStatusMrnReportDetail> getApproveStatusMrnDetailReport(@Param("mrnIdList") List<Integer> mrnIdList);

}
