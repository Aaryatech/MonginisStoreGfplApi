package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.GetItemGroup;
import com.ats.triladmin.model.GetpassDetail;

public interface GetpassDetailRepo extends JpaRepository<GetpassDetail, Integer> {

	List<GetpassDetail> findByGpId(int gpId);

	@Query(value = "select count(*) as count from t_gatepass_detail where gp_rem_qty!=0 and gp_id=:gpId\r\n"
			+ "", nativeQuery = true)
	int getpassDetailCount(@Param("gpId") int gpId);

	@Transactional
	@Modifying
	@Query("UPDATE GetpassDetail SET gpStatus=:status  WHERE gpDetailId IN (:gpDetailId)")
	int updateStatusWhileApprov(@Param("gpDetailId")List<Integer> gpDetailId,@Param("status") int status);

}
