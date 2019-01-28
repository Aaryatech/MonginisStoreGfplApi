package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.EnquiryHeader;

public interface EnquiryHeaderRepository extends JpaRepository<EnquiryHeader, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE EnquiryHeader SET del_status=0 WHERE enq_id=:enqId") 
	int delete( @Param("enqId") int enqId);

}
