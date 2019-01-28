package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.ItemExpectedReport; 
public interface ItemExpectedReportRepository extends JpaRepository<ItemExpectedReport, Integer>{

	
	@Query(value=" select pd.po_detail_id,pd.po_id,pd.item_id,pd.item_qty,pd.item_uom,pd.sch_date,ph.po_no,ph.po_date,ph.vend_id,i.item_code,i.item_desc,v.vendor_code,"
			+ "v.vendor_name from po_detail pd,po_header ph,m_item i,m_vendor v where pd.status in (:status) and ph.po_id=pd.po_id and i.item_id=pd.item_id and "
			+ "v.vendor_id=ph.vend_id and ph.del_status=1 and  pd.sch_date between :fromDate and :toDate ",nativeQuery=true) 
	List<ItemExpectedReport> getItemExpectedReportBetweenDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate, @Param("status")List<Integer> status);
	
	@Query(value=" select pd.po_detail_id,pd.po_id,pd.item_id,pd.item_qty,pd.item_uom,pd.sch_date,ph.po_no,ph.po_date,ph.vend_id,i.item_code,i.item_desc,v.vendor_code,"
			+ "v.vendor_name from po_detail pd,po_header ph,m_item i,m_vendor v where pd.status in (:status) and ph.po_id=pd.po_id and i.item_id=pd.item_id and "
			+ "v.vendor_id=ph.vend_id and ph.del_status=1 and  i.cat_id=:catId and pd.sch_date between :fromDate and :toDate ",nativeQuery=true) 
	List<ItemExpectedReport> getItemExpectedReportBetweenDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate, @Param("status")List<Integer> status,
			@Param("catId")int catId);

}
