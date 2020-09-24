package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.triladmin.model.BillBookDetail;


public interface BillBookDetailRepo extends JpaRepository<BillBookDetail, Integer>{

	
	List<BillBookDetail> findAllByBillId(int id);
	
}
