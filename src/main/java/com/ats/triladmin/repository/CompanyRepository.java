package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.triladmin.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

	Company findByComId(int i);

}
