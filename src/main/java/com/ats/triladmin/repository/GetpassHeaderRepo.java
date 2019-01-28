package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.GetpassHeader;

public interface GetpassHeaderRepo extends JpaRepository<GetpassHeader, Integer> {

	List<GetpassHeader> findAllByIsUsed(int i);

	GetpassHeader findByGpId(int gpId);

	@Transactional
	@Modifying
	@Query("UPDATE GetpassHeader SET isUsed=0  WHERE gp_id=:gpId")
	int deleteGetpassHeader(@Param("gpId") int gpId);

	@Transactional
	@Modifying
	@Query("UPDATE GetpassHeader SET gp_status=3  WHERE gp_id=:gpId")
	int updateGetpassHeaderStatus(@Param("gpId") int gpId);

	@Transactional
	@Modifying
	@Query("UPDATE GetpassHeader SET gpStatus=:status  WHERE gp_id=:gpId")
	int updateStatusWhileApprov(@Param("gpId")int gpId,@Param("status") int status);
}
