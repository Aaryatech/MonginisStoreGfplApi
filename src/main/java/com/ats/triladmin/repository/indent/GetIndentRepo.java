package com.ats.triladmin.repository.indent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.indent.GetIndent;
import com.ats.triladmin.model.indent.IndentReport;

@Repository
public interface GetIndentRepo extends JpaRepository<GetIndent, Integer> {

	@Query(value = " SELECT indent.cat_id, indent.ind_m_id,indent.ind_m_no,indent.ind_m_date,indent.ind_isdev,indent.ind_ismonthly,indent.ind_m_type,indent.achd_id ,"
			+ "indent.dept_id,indent.sub_dept_id, m_account_head.acc_head_desc, "
			+ " m_category.cat_desc,indent.ind_m_status,indent.ind_remark FROM indent,m_category,m_account_head WHERE indent.ind_m_date BETWEEN :fromDate AND :toDate "
			+ " AND indent.cat_id=m_category.cat_id AND indent.ind_m_status IN (:status) AND m_account_head.acc_head_id=indent.achd_id "
			+ "and indent.del_status=1", nativeQuery = true) 
	List<GetIndent> getIndent(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("status") List<String> status);
	
	@Query(value = " SELECT indent.cat_id, indent.ind_m_id,indent.ind_m_no,indent.ind_m_date,indent.ind_isdev,indent.ind_ismonthly,indent.ind_m_type,indent.achd_id ,"
			+ "indent.dept_id,indent.sub_dept_id, m_account_head.acc_head_desc, "
			+ " m_category.cat_desc,indent.ind_m_status,indent.ind_remark FROM indent,m_category,m_account_head WHERE indent.ind_m_date <= :toDate "
			+ " AND indent.cat_id=m_category.cat_id AND indent.ind_m_status IN (:status) AND m_account_head.acc_head_id=indent.achd_id "
			+ "and indent.del_status=1", nativeQuery = true) 
	List<GetIndent> getIndentsForApproval(@Param("toDate") String toDate,
			@Param("status") List<String> status);//same query for apr 1 and apr 2 list change status list while sending status param

	@Query(value = " SELECT indent.cat_id, indent.ind_m_id,indent.ind_m_no,indent.ind_m_date,indent.ind_isdev,indent.ind_ismonthly,indent.ind_m_type,indent.achd_id ,"
			+ "indent.dept_id,indent.sub_dept_id, m_account_head.acc_head_desc, "
			+ " m_category.cat_desc,indent.ind_m_status,indent.ind_remark FROM indent,m_category,m_account_head WHERE indent.ind_m_date BETWEEN :fromDate AND :toDate "
			+ " AND indent.cat_id=m_category.cat_id AND indent.ind_m_status IN (:status) AND m_account_head.acc_head_id=indent.achd_id "
			+ "and indent.del_status=1 and indent.ind_m_type=:typeId", nativeQuery = true) 
	List<GetIndent> getIndent(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("status") List<String> status,@Param("typeId") int typeId);

}
