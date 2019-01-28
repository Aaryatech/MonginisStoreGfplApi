package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.ShortItemReport;

public interface ShortItemReportRepository extends JpaRepository<ShortItemReport, Integer>{

	@Query(value=" SELECT po_detail.po_detail_id,po_header.po_no,po_date,po_header.vend_id,m_vendor.vendor_name,m_vendor.vendor_code,po_detail.item_id,m_item.item_code,"
			+ "m_item.item_desc,po_detail.item_qty,sum(t_mrn_detail.mrn_qty) as mrn_qty,po_detail.pending_qty,po_detail.sch_date FROM `po_header`,po_detail,"
			+ "m_item,m_vendor,t_mrn_detail WHERE po_header.po_id=po_detail.po_id AND po_header.vend_id=m_vendor.vendor_id AND po_detail.item_id=m_item.item_id AND  "
			+ "po_detail.po_detail_id=t_mrn_detail.po_detail_id AND po_detail.pending_qty >0 and po_detail.sch_date between :fromDate and :toDate "
			+ "GROUP BY t_mrn_detail.po_detail_id",nativeQuery=true) 
	List<ShortItemReport> getShortItemReportBetweenDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	@Query(value=" SELECT po_detail.po_detail_id,po_header.po_no,po_date,po_header.vend_id,m_vendor.vendor_name,m_vendor.vendor_code,po_detail.item_id,m_item.item_code,"
			+ "m_item.item_desc,po_detail.item_qty,sum(t_mrn_detail.mrn_qty) as mrn_qty,po_detail.pending_qty,po_detail.sch_date FROM `po_header`,po_detail,"
			+ "m_item,m_vendor,t_mrn_detail WHERE po_header.po_id=po_detail.po_id AND po_header.vend_id=m_vendor.vendor_id AND po_detail.item_id=m_item.item_id AND  "
			+ "po_detail.po_detail_id=t_mrn_detail.po_detail_id AND po_detail.pending_qty >0 and m_item.cat_id=:catId and po_detail.sch_date between :fromDate and :toDate "
			+ "GROUP BY t_mrn_detail.po_detail_id",nativeQuery=true)
	List<ShortItemReport> getShortItemReportBetweenDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("catId") int catId);

}
