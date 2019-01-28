package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetIntendDetail;

public interface GetIntendDetailRepo extends JpaRepository<GetIntendDetail, Integer>{

	@Query(value=("Select i.*,CONCAT(m.item_code, '-', m.item_desc) as item_code from indtrans i,m_item m where i.ind_m_id=:indId and i.ind_d_status In(0,1,2) and m.item_id=i.item_id and i.del_status=1"),nativeQuery=true)
	List<GetIntendDetail> findByIndMId(@Param("indId")int indId);

	@Query(value=("select max(po_detail.item_rate) as rate from po_detail, po_header  WHERE po_header.po_id =po_detail.po_id "
			+ "AND po_header.del_status=1 and po_detail.item_id=:itemId "),nativeQuery=true)
	 float getLatestRateofItem(@Param("itemId")int itemId);

}
