package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetItemGroup;


public interface GetItemGroupRepository extends JpaRepository<GetItemGroup, Integer> {
	
	@Query(value = "SELECT g.*,c.cat_desc FROM m_item_group g ,m_category c WHERE g.cat_id=c.cat_id AND g.is_used=1 ", nativeQuery = true)
	List<GetItemGroup> getAllItemGrpList();
	
	@Query(value = "SELECT g.*,c.cat_desc FROM m_item_group g ,m_category c WHERE g.cat_id=c.cat_id AND g.is_used=1 AND  g.grp_id=:grpId", nativeQuery = true)
	GetItemGroup getItemGrpByGrpId(@Param("grpId") int grpId);
	
	@Query(value = "SELECT g.*,c.cat_desc FROM m_item_group g ,m_category c WHERE g.cat_id=c.cat_id AND g.is_used=1 AND  g.cat_id=:catId", nativeQuery = true)
	List<GetItemGroup> getgroupListByCatId(@Param("catId")int catId);

}
