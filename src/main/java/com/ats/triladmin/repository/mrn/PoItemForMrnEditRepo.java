package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.mrn.PoItemForMrnEdit;
@Repository
public interface PoItemForMrnEditRepo extends JpaRepository<PoItemForMrnEdit, Integer> {
	
	@Query(value = " SELECT po_detail.item_id,po_detail.po_detail_id,po_detail.po_id, m_item.item_desc,m_item.item_code FROM po_detail,m_item,t_mrn_detail WHERE t_mrn_detail.mrn_id=:mrnId AND "
			+ "t_mrn_detail.po_detail_id=po_detail.po_detail_id " + 
			" AND po_detail.item_id=m_item.item_id AND t_mrn_detail.item_id!=po_detail.item_id AND t_mrn_detail.del_status=1 ", nativeQuery = true)
	
	List<PoItemForMrnEdit> getPoItemForMrnEdit(@Param("mrnId") int mrnId);

}
