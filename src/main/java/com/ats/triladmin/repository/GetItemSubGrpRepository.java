package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetItemSubGrp;

public interface GetItemSubGrpRepository extends JpaRepository<GetItemSubGrp, Integer> {

	@Query(value = "SELECT sg.*,g.grp_desc FROM m_item_group g ,m_item_subgroup sg WHERE g.grp_id=sg.grp_id AND sg.is_used=1 ", nativeQuery = true)
	List<GetItemSubGrp> getAllItemSubGrpList();
	
	@Query(value = "SELECT sg.*,g.grp_desc FROM m_item_group g ,m_item_subgroup sg WHERE g.grp_id=sg.grp_id AND sg.is_used=1 AND sg.subgrp_id=:subgrpId", nativeQuery = true)
	GetItemSubGrp getSubItemBySubGroupId(@Param("subgrpId") int subgrpId);

	@Query(value = "SELECT sg.*,g.grp_desc FROM m_item_group g ,m_item_subgroup sg WHERE g.grp_id=sg.grp_id AND sg.is_used=1 and sg.grp_id=:grpId", nativeQuery = true)
	List<GetItemSubGrp> getSubGroupByGroupId(@Param("grpId")int grpId);


}
