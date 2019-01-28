package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.MrnReportDetail;

public interface MrnReportDetailRepo extends JpaRepository<MrnReportDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_desc,i.item_code ,i.item_uom FROM  t_mrn_detail d ,m_item i WHERE d.del_status=1 AND d.mrn_id IN(:mrnIdList)  AND i.item_id=d.item_id   ", nativeQuery = true)
	List<MrnReportDetail> getMrnDetailReportList(@Param("mrnIdList") List<Integer> mrnIdList);

}
