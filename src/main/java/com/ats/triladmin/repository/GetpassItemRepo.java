package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.GetpassItem;
@Repository
public interface GetpassItemRepo extends JpaRepository<GetpassItem, Integer> {

	List<GetpassItem> findAllByIsUsed(int i);

	GetpassItem save(GetpassItem item);

	@Transactional
	@Modifying
	@Query("UPDATE GetpassItem SET isUsed=0  WHERE gp_item_id=:gpItemId")
	int deleteGetpassItem(@Param("gpItemId") int gpItemId);

	GetpassItem findByGpItemIdAndIsUsed(int gpItemId, int i);

}
