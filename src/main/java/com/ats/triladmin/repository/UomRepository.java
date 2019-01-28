package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.Uom;

public interface UomRepository extends JpaRepository<Uom, Integer> {

	Uom findByUomId(int uomId);

	List<Uom> findAllByIsUsed(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Uom SET isUsed=0  WHERE uom_id=:uomId")
	int deleteUom(@Param("uomId") int uomId);

}
