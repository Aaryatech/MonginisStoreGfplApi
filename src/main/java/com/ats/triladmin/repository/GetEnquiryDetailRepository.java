package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetEnquiryDetail; 

public interface GetEnquiryDetailRepository extends JpaRepository<GetEnquiryDetail, Integer>{

	@Query(value=("select d.*,v.vendor_name,CONCAT(i.item_code, '-', i.item_desc) as item_code from enq_detail d,m_vendor v,m_item i "
			+ "where d.del_status=1 and v.vendor_id = d.vend_id and d.enq_id=:enqId and i.item_id=d.item_id"),nativeQuery=true)
	List<GetEnquiryDetail> getEnquiryDetail(@Param("enqId")int enqId);
	
	@Query(value=("select d.*,CONCAT(i.item_code, '-', i.item_desc) as item_code,i.item_uom as vendor_name from enq_detail d,m_item i "
			+ "where d.del_status=1 and d.enq_id=:enqId and i.item_id=d.item_id"),nativeQuery=true)
	List<GetEnquiryDetail> getEnquiryDetailforPdf(@Param("enqId")int enqId);

}
