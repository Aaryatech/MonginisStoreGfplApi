package com.ats.triladmin.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.PoHeader;

public interface PoHeaderRepository extends JpaRepository<PoHeader, Integer>{

	
	List<PoHeader> findByVendIdAndDelStatusAndPoTypeAndPoStatusIn(int vendId,int delStatus,int poType,List<Integer> statusList);

	List<PoHeader> findByPoTypeAndPoStatusAndDelStatus(int poType, int status, int i);
	
	@Transactional
	@Modifying
	@Query(" UPDATE PoHeader  SET poStatus=:poStatus "
			+ " WHERE poId=:poId ")
	int updateResponsePoHead(@Param("poStatus") int poStatus,@Param("poId") int poId); 
	
	@Transactional
	@Modifying
	@Query("UPDATE PoHeader SET del_status=0  WHERE po_id=:poId") 
	int delete(@Param("poId") int poId);

	@Transactional
	@Modifying
	@Query(" UPDATE PoHeader  SET poStatus=:status   WHERE poId=:poId ")
	int updateStatusWhileApprov(@Param("poId")int poId,@Param("status") int status);

	@Query(value = "select sch_date from po_detail where po_id =:poId", nativeQuery = true)
	List<Date> getschDate(@Param("poId") int poId);
	
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         