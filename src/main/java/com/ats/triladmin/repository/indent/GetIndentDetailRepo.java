package com.ats.triladmin.repository.indent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.indent.GetIndentDetail;

public interface GetIndentDetailRepo extends JpaRepository<GetIndentDetail, Integer>{
	
	@Query(value = " SELECT indtrans.*,m_item.item_desc,m_item.item_code,m_item.item_uom FROM indtrans,m_item "
			+ " WHERE indtrans.ind_m_id=:indentId AND indtrans.del_status=1 AND indtrans.item_id=m_item.item_id ",
			nativeQuery = true)
	
	List<GetIndentDetail> getIndentDetail(@Param("indentId") int indentId);
	
}
