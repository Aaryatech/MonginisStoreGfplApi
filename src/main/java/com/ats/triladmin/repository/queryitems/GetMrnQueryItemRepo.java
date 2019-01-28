package com.ats.triladmin.repository.queryitems;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.getqueryitems.GetMrnQueryItem;

public interface GetMrnQueryItemRepo extends JpaRepository<GetMrnQueryItem, Integer>{
	
	@Query(value = " SELECT t_mrn_detail.mrn_detail_id,t_mrn_header.mrn_no,t_mrn_header.mrn_date,"
			+ "m_vendor.vendor_code,m_vendor.vendor_name,t_mrn_detail.mrn_qty,t_mrn_detail.mrn_detail_status,"
			+ " t_mrn_detail.chalan_qty,t_mrn_detail.approve_qty,t_mrn_detail.reject_qty,po_header.po_no,"
			+ "po_header.po_date, m_item.item_code,m_item.item_desc,m_item.item_uom,"
			+ "indent.ind_m_no AS ind_no,indent.ind_m_date AS ind_date "
			+ "FROM t_mrn_detail,t_mrn_header,m_vendor,po_header,m_item,indent "
			+ "WHERE t_mrn_header.mrn_date >=:fromDate AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id "
			+ "AND t_mrn_detail.po_id=po_header.po_id AND t_mrn_header.vendor_id=m_vendor.vendor_id "
			+ "AND t_mrn_detail.item_id=m_item.item_id and t_mrn_detail.item_id=:itemId AND po_header.ind_id=indent.ind_m_id AND t_mrn_detail.del_status=1 ", 
			nativeQuery = true)
	List<GetMrnQueryItem> getMnrQueryItem(@Param("fromDate") Date fromDate,@Param("itemId") int itemId);
	
}
