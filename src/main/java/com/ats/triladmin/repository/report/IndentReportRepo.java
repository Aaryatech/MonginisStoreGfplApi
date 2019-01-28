package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.IndentReport;

public interface IndentReportRepo extends JpaRepository<IndentReport, Integer> {

	@Query(value = "SELECT\r\n" + 
			"        h.*,\r\n" + 
			"        c.cat_desc,\r\n" + 
			"        a.acc_head_desc,\r\n" + 
			"        0 as dept_desc,\r\n" + 
			"        0 as sub_dept_desc,\r\n" + 
			"        t.type_name  \r\n" + 
			"    FROM\r\n" + 
			"        indent h,\r\n" + 
			"        m_category c,\r\n" + 
			"        m_account_head a, \r\n" + 
			"        type t \r\n" + 
			"    WHERE\r\n" + 
			"        h.ind_m_id IN(:indentIdList) \r\n" + 
			"        AND h.del_status=1  \r\n" + 
			"        AND h.cat_id=c.cat_id \r\n" + 
			"        AND a.acc_head_id=h.achd_id    \r\n" + 
			"        and t.type_id=h.ind_m_type", nativeQuery = true)
	List<IndentReport> getIndentHeaderReportList(@Param("indentIdList") List<Integer> indentIdList);

	//
}
