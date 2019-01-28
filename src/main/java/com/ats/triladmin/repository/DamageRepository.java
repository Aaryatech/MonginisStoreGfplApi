package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.Damage; 

public interface DamageRepository extends JpaRepository<Damage, Integer>{

	
	@Transactional
	@Modifying
	@Query("UPDATE Damage SET del_status=0  WHERE damage_id=:damageId")
	int deleteDamage(@Param("damageId") int damageId);

}
