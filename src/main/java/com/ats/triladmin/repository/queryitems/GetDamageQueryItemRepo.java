package com.ats.triladmin.repository.queryitems;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.getqueryitems.GetDamageQueryItem;

public interface GetDamageQueryItemRepo extends JpaRepository<GetDamageQueryItem, Integer>{
	
	@Query(value = " SELECT t_damage.*, " + 
			" m_item.item_code,m_item.item_desc,m_item.item_uom " + 
			" FROM t_damage,m_item " + 
			" WHERE  t_damage.item_id=m_item.item_id "
			+ " AND t_damage.date>=:fromDate "
			+ " AND t_damage.item_id=:itemId AND t_damage.del_status=1 ", 
			nativeQuery = true)
	List<GetDamageQueryItem> getDamageQueryItem(@Param("fromDate") Date fromDate,@Param("itemId") int itemId);
	
}
