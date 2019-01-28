package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.triladmin.model.DepartmentMaster;

public interface DepartmentMasterRepository extends JpaRepository<DepartmentMaster, Integer>{

	List<DepartmentMaster> findByDelStatus(int i);

}
