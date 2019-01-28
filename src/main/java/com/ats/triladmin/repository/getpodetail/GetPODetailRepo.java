package com.ats.triladmin.repository.getpodetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetPODetail;

public interface GetPODetailRepo  extends JpaRepository<GetPODetail, Integer>{
	
	@Query(value=" SELECT po_detail.*,m_item.item_code,m_item.item_desc as item_name,m_item.item_uom as uom,"
			+ " po_header.po_no FROM m_item,po_detail,po_header WHERE po_detail.item_id=m_item.item_id "
			+ " AND po_detail.po_id IN (:poIdList) AND po_detail.status IN (0,1) "
			+ " AND po_header.po_id=po_detail.po_id  " ,nativeQuery=true) 
		
	List<GetPODetail> getPoDetailsByPoIds(@Param("poIdList") List<Integer> poIdList);
	

}
