package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.GetpassReturn;

public interface GetpassReturnRepo extends JpaRepository<GetpassReturn, Integer> {

	GetpassReturn findByReturnId(int returnId);

	@Transactional
	@Modifying
	@Query("UPDATE GetpassReturn SET isUsed=0  WHERE return_id=:returnId")
	int deleteGetpassReturn(@Param("returnId") int returnId);

}
