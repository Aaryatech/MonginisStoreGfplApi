package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.POReportDetail;

public interface POReportDetailRepo extends JpaRepository<POReportDetail, Integer> {
	@Query(value = "SELECT po_detail.*,i.item_code,i.item_desc as item_name, ih.ind_m_date FROM po_detail ,m_item i ,indtrans id,indent ih WHERE po_detail.po_id IN(:poIdList)  AND i.item_id=po_detail.item_id AND "
			+ "po_detail.ind_id=id.ind_d_id and id.ind_m_id=ih.ind_m_id", nativeQuery = true)
	List<POReportDetail> getPOReportDetailList(@Param("poIdList") List<Integer> poIdList);

	@Query(value = "SELECT po_detail.*,i.item_code,i.item_desc as item_name, ih.ind_m_date FROM po_detail ,m_item i ,indtrans id,indent ih WHERE po_detail.po_id=:poId  AND i.item_id=po_detail.item_id AND "
			+ "po_detail.ind_id=id.ind_d_id and id.ind_m_id=ih.ind_m_id", nativeQuery = true)
	List<POReportDetail> getPOReportDetailList(@Param("poId") int poId);

}
