package com.ats.triladmin.repository.queryitems;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.getqueryitems.GetPoQueryItem;

public interface GetPoQueryItemRepo extends JpaRepository<GetPoQueryItem, Integer>{

	@Query(value = " SELECT po_detail.po_detail_id,po_header.po_no,po_header.po_date,po_header.po_type,po_detail.item_qty,po_detail.inded_qty,po_detail.item_rate,indent.ind_m_no as ind_no,indent.ind_m_date as ind_date, "
			+ " m_item.item_code,m_item.item_desc,m_item.item_uom,m_vendor.vendor_code,m_vendor.vendor_name FROM m_item,po_detail,po_header,m_vendor,indent WHERE po_header.po_date >= :fromDate "
			+" AND po_header.po_id=po_detail.po_id AND po_detail.item_id=m_item.item_id and po_detail.item_id=:itemId AND po_header.vend_id=m_vendor.vendor_id\n" + 
			" AND po_detail.ind_id=indent.ind_m_id and po_header.del_status=1", nativeQuery = true)
	List<GetPoQueryItem> getPoQueryItem(@Param("fromDate") Date fromDate,@Param("itemId") int itemId);

	@Query(value = "SELECT po_detail.po_detail_id, po_header.po_no, po_header.po_date, po_header.po_type, po_detail.item_qty, "
			+ "po_detail.inded_qty, po_detail.item_rate, indent.ind_m_no as ind_no, indent.ind_m_date as ind_date, m_item.item_code, "
			+ "m_item.item_desc, m_item.item_uom, m_vendor.vendor_code, m_vendor.vendor_name FROM m_item, po_detail, po_header, "
			+ "m_vendor, indent WHERE po_header.po_id=po_detail.po_id  AND po_detail.item_id=m_item.item_id and po_detail.item_id=:itemId "
			+ "AND po_header.vend_id=m_vendor.vendor_id AND po_detail.ind_id=indent.ind_m_id and po_header.del_status=1 ORDER BY po_detail.po_detail_id desc limit 80", nativeQuery = true)
	List<GetPoQueryItem> getPreviousRecordOfPoItem(@Param("itemId") int itemId);
	
}
