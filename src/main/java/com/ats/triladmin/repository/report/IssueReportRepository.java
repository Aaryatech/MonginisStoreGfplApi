package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.IssueReport;

public interface IssueReportRepository extends JpaRepository<IssueReport, Integer> {

	@Query(value = "SELECT\r\n" + 
			"        i.*,\r\n" + 
			"        concat(d.dept_code,' ',d.dept_desc) as dept_code,\r\n" + 
			"        concat(sd.sub_dept_code,' ',sd.sub_dept_desc) as sub_dept_code\r\n" + 
			"    FROM\r\n" + 
			"        item_issue_header i,m_dept d,m_sub_dept sd \r\n" + 
			"    WHERE\r\n" + 
			"        i.issue_id IN(:issueIdList) \r\n" + 
			"        AND i.delete_status=1 \r\n" + 
			"        and d.dept_id=i.dept_id\r\n" + 
			"        and sd.sub_dept_id=i.sub_dept_id", nativeQuery = true)
	List<IssueReport> getIssueReportList(@Param("issueIdList") List<Integer> issueIdList);

}
