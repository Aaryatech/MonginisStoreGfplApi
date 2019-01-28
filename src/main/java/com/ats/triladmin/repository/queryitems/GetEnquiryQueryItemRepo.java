package com.ats.triladmin.repository.queryitems;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.getqueryitems.GetEnquiryQueryItem;

public interface GetEnquiryQueryItemRepo extends JpaRepository<GetEnquiryQueryItem, Integer> {
	
	@Query(value = " SELECT enq_detail.enq_detail_id, enq_detail.enq_qty,enq_header.enq_date,enq_header.enq_no,"
			+ "enq_detail.enq_detail_date,m_vendor.vendor_code,m_vendor.vendor_name,\n" + 
			"m_item.item_code,m_item.item_desc,m_item.item_uom\n" + 
			"FROM enq_header,enq_detail,m_item,m_vendor \n" + 
			"WHERE enq_header.enq_id=enq_detail.enq_id AND enq_detail.item_id=m_item.item_id "
			+ "and m_vendor.vendor_id=enq_detail.vend_id AND enq_detail.enq_detail_date>=:fromDate "
			+ "AND enq_detail.item_id=:itemId AND enq_detail.del_status=1", 
			nativeQuery = true)
	List<GetEnquiryQueryItem> getEnquiryQueryItem(@Param("fromDate") Date fromDate,@Param("itemId") int itemId);

}
