package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetPassReturnDetailWithItemName;

public interface GetPassReturnDetailWithItemNameRepo extends JpaRepository<GetPassReturnDetailWithItemName, Integer>{

	@Query(value = "select gd.*,CONCAT(i.item_code, '-', i.item_desc) as item_code from t_getpass_return_detail gd,m_item i where gd.return_id=:returnId and gd.is_used=1 and gd.gp_item_id = i.item_id ", nativeQuery = true)
 	List<GetPassReturnDetailWithItemName> findByReturnId(@Param("returnId") int returnId);
	
	
}
