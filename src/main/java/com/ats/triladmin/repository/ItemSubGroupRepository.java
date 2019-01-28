package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.ItemSubGroup;

public interface ItemSubGroupRepository extends JpaRepository<ItemSubGroup, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE ItemSubGroup SET isUsed=0 ,deleted_in=:deletedIn WHERE subgrp_id=:subgrpId")
	int deleteItemSubGroup(@Param("subgrpId") int subgrpId, @Param("deletedIn") int deletedIn);

}
