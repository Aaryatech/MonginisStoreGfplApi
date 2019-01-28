package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.GeneralGrnHeader;

public interface GeneralGrnHeaderRepository extends JpaRepository<GeneralGrnHeader, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE GeneralGrnHeader SET del_status=0 WHERE grn_id=:grnId") 
	int delete(@Param("grnId") int grnId);

}
