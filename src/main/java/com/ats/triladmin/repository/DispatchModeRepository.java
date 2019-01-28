package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.DispatchMode;

public interface DispatchModeRepository extends JpaRepository<DispatchMode, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE DispatchMode SET isUsed=0 ,deleted_in=:deletedIn WHERE disp_mode_id=:dispModeId")
	int deleteDispatchMode(@Param("dispModeId") int dispModeId, @Param("deletedIn") int deletedIn);

	DispatchMode findByDispModeId(int dispModeId);

	List<DispatchMode> findAllByIsUsed(int i);

}
