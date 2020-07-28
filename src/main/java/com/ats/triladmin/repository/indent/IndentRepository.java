package com.ats.triladmin.repository.indent;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.indent.Indent;
import com.ats.triladmin.model.report.IndentReportDetail;

public interface IndentRepository extends JpaRepository<Indent, Integer> {

	Indent save(Indent indent);

	@Transactional
	@Modifying
	@Query(" UPDATE Indent  SET achdId=:achdId,deptId=:deptId,subDeptId=:subDeptId,indIsdev=:indIsdev,indRemark=:indRemark,indIsmonthly=:indIsmonthly "
			+ " WHERE indMId=:indMId ")
	int updateIndentHeader(@Param("achdId") int achdId, @Param("deptId") int deptId, @Param("subDeptId") int subDeptId,
			@Param("indIsdev") int indIsdev, @Param("indIsmonthly") int indIsmonthly, @Param("indMId") int indMId,
			@Param("indRemark") String indRemark);

	@Transactional
	@Modifying
	@Query(" UPDATE Indent  SET ind_m_status=:status WHERE ind_m_id=:indMId ")
	int updateStatus(@Param("indMId") int indMId, @Param("status") int status);

	@Transactional
	@Modifying
	@Query(" UPDATE Indent  SET del_status=0 WHERE ind_m_id=:indId ")
	int delete(@Param("indId") int indId);

	Indent findByIndMId(int indMId);
	
	//for approval 1
	@Transactional
	@Modifying
	@Query(" UPDATE Indent  SET ind_m_status=:status, ind_apr1_date=:apr1Date WHERE ind_m_id=:indMId ")
	int updateIndApr1(@Param("indMId") int indMId, @Param("status") int status,@Param("apr1Date") Date apr1Date);


	//for approval 2
	@Transactional
	@Modifying
	@Query(" UPDATE Indent  SET ind_m_status=:status, ind_apr2_date=:apr2Date WHERE ind_m_id=:indMId ")
	int updateIndApr2(@Param("indMId") int indMId, @Param("status") int status,@Param("apr2Date") Date apr2Date);

	
	@Query(value = "SELECT Indent.ind_m_no from Indent i WHERE i.ind_m_id=:indentId", nativeQuery = true)
	String getIndentNoByIndentId(@Param("indentId") int  indentId);

	
}
