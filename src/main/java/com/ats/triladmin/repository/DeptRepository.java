package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

	Dept findDeptByDeptId(int deptId);

	List<Dept> findAllByIsUsed(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Dept SET isUsed=0  , dept_deleted_in=:deptDeletedIn  WHERE dept_id=:deptId ")
	int deleteDept(@Param("deptId") int deptId, @Param("deptDeletedIn") int deptDeletedIn);

}
