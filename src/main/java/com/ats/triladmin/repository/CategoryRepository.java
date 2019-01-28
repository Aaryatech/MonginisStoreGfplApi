package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findCatByCatId(int catId);

	List<Category> findAllByIsUsed(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Category SET isUsed=0 ,deleted_in=:deletedIn WHERE cat_id=:catId")
	int deleteCategory(@Param("catId") int catId, @Param("deletedIn") int deletedIn);

	List<Category> findAllByIsUsedOrderByCatId(int i);

}
