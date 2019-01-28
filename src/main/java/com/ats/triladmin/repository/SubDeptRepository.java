package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.SubDept;

public interface SubDeptRepository extends JpaRepository<SubDept, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE SubDept SET isUsed=0 ,deleted_in=:deletedIn WHERE sub_dept_id=:subDeptId")
	int deleteSubDept(@Param("subDeptId") int subDeptId, @Param("deletedIn") int deletedIn);

	List<SubDept> findAllByIsUsed(int i);

	SubDept findSubDeptBySubDeptId(int subDeptId);

}
