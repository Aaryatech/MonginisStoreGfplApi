package com.ats.triladmin.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.triladmin.model.StockHeader;

public interface StockHeaderRepository extends JpaRepository<StockHeader, Integer>{

	StockHeader findByStatusAndDelStatus(int status, int delStatus);

}
