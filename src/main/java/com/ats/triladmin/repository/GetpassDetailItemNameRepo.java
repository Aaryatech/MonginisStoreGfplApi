package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetpassDetailItemName;

public interface GetpassDetailItemNameRepo extends JpaRepository<GetpassDetailItemName, Integer> {

	@Query(value = "SELECT h.*,CONCAT(i.item_code, '-', i.item_desc) as item_code, c.cat_id, g.grp_id,u.uom as uom_name FROM t_gatepass_detail h , m_item i, m_category c, m_item_group g,m_uom u "
			+ "WHERE i.item_id=h.gp_item_id AND gp_id=:gpId and h.is_used=1 and c.cat_id=i.cat_id and g.grp_id = i.grp_id and h.gp_rem_qty !=0 and u.uom_id=h.uom", nativeQuery = true)
	List<GetpassDetailItemName> getAllItemByGpId(@Param("gpId") int gpId);

	@Query(value = "SELECT h.*,CONCAT(i.item_code, '-', i.item_desc) as item_code, c.cat_id, g.grp_id,u.uom as uom_name FROM t_gatepass_detail h , m_item i, m_category c, m_item_group g,m_uom u "
			+ "WHERE i.item_id=h.gp_item_id AND gp_id=:gpId and h.is_used=1 and c.cat_id=i.cat_id and g.grp_id = i.grp_id and u.uom_id=h.uom", nativeQuery = true)
	List<GetpassDetailItemName> getAllDetailedItemByGpId(@Param("gpId") int gpId);

}
