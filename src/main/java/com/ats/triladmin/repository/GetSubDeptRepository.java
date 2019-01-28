package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetSubDept;

public interface GetSubDeptRepository extends JpaRepository<GetSubDept, Integer> {

	@Query(value = "SELECT s.*,d.dept_desc,d.dept_code FROM m_dept d ,m_sub_dept s WHERE s.sub_dept_id=:subDeptId AND s.is_used=1 AND s.dept_id=d.dept_id", nativeQuery = true)
	GetSubDept getSubDeptbySubDeptId(@Param("subDeptId") int subDeptId);

	@Query(value = "SELECT s.*,d.dept_desc,d.dept_code FROM m_dept d ,m_sub_dept s WHERE s.is_used=1 AND s.dept_id=d.dept_id", nativeQuery = true)
	List<GetSubDept> getAllSubDeptList();
	
	@Query(value = "SELECT s.*,d.dept_desc,d.dept_code FROM m_dept d ,m_sub_dept s WHERE s.is_used=1 AND s.dept_id=d.dept_id and s.dept_id=:deptId", nativeQuery = true)
	List<GetSubDept> getSubDeptListByDeptId(@Param("deptId") int deptId);

}
