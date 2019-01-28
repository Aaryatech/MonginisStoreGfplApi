package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.ItemGroup;

public interface ItemGroupRepository extends JpaRepository<ItemGroup, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE ItemGroup SET isUsed=0 ,deleted_in=:deletedIn WHERE grp_id=:grpId")
	int deleteItemGroup(@Param("grpId") int grpId, @Param("deletedIn") int deletedIn);

	List<ItemGroup> findAllByIsUsed(int i);

	ItemGroup findByGrpId(int grpId);

}
