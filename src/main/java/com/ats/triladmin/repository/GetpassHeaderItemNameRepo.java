package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetpassHeaderItemNameRepo extends JpaRepository<GetpassHeaderItemName, Integer> {

	@Query(value = "SELECT  * FROM t_gatepass_header  WHERE gp_id=:gpId ", nativeQuery = true)
	GetpassHeaderItemName getAllHeaderItemByGpId(@Param("gpId") int gpId);

	@Query(value = "SELECT  * FROM t_gatepass_header  WHERE gp_status IN (:status) ", nativeQuery = true)
	List<GetpassHeaderItemName> getGetpassItemHeaderApprove(@Param("status") List<Integer> status);

}
