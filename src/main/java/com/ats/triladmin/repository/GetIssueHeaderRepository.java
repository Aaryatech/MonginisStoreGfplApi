package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetIssueHeader;

public interface GetIssueHeaderRepository extends JpaRepository<GetIssueHeader, Integer>{

	@Query(value=("select\r\n" + 
			"        ih.* ,\r\n" + 
			"        CONCAT(d.dept_code,'-',d.dept_desc) as dept_code,\r\n" + 
			"        CONCAT(sd.sub_dept_code,'-',sd.sub_dept_desc) as sub_dept_code,\r\n" + 
			"        a.acc_head_desc \r\n" + 
			"    from\r\n" + 
			"        item_issue_header ih,\r\n" + 
			"        m_dept d,\r\n" + 
			"        m_sub_dept sd,\r\n" + 
			"        m_account_head a\r\n" + 
			"    where\r\n" + 
			"        ih.delete_status = 1  \r\n" + 
			"        and ih.issue_date between :fromDate and :toDate\r\n" + 
			"        and d.dept_id = ih.dept_id \r\n" + 
			"        and sd.sub_dept_id = ih.sub_dept_id \r\n" + 
			"        and a.acc_head_id=ih.acc_head "),nativeQuery=true)
	List<GetIssueHeader> findByDeleteStatus(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value=("select\r\n" + 
			"        ih.* ,\r\n" + 
			"        CONCAT(d.dept_code,'-',d.dept_desc) as dept_code,\r\n" + 
			"        CONCAT(sd.sub_dept_code,'-',sd.sub_dept_desc) as sub_dept_code,\r\n" + 
			"        a.acc_head_desc \r\n" + 
			"    from\r\n" + 
			"        item_issue_header ih,\r\n" + 
			"        m_dept d,\r\n" + 
			"        m_sub_dept sd,\r\n" + 
			"        m_account_head a\r\n" + 
			"    where\r\n" + 
			"        ih.delete_status = 1  \r\n" + 
			"        and ih.issue_id =:issueId\r\n" + 
			"        and d.dept_id = ih.dept_id \r\n" + 
			"        and sd.sub_dept_id = ih.sub_dept_id \r\n" + 
			"        and a.acc_head_id=ih.acc_head "),nativeQuery=true)
	GetIssueHeader findByIssueId(@Param("issueId") int issueId);

	@Query(value=("select\r\n" + 
			"        ih.* ,\r\n" + 
			"        CONCAT(d.dept_code,'-',d.dept_desc) as dept_code,\r\n" + 
			"        CONCAT(sd.sub_dept_code,'-',sd.sub_dept_desc) as sub_dept_code,\r\n" + 
			"        a.acc_head_desc \r\n" + 
			"    from\r\n" + 
			"        item_issue_header ih,\r\n" + 
			"        m_dept d,\r\n" + 
			"        m_sub_dept sd,\r\n" + 
			"        m_account_head a\r\n" + 
			"    where\r\n" + 
			"        ih.delete_status = 1 and d.dept_id = ih.dept_id \r\n" + 
			"        and sd.sub_dept_id = ih.sub_dept_id \r\n" + 
			"        and a.acc_head_id=ih.acc_head "
			+ "  and ih.status in (:status)"),nativeQuery=true)
	List<GetIssueHeader> getIssueHeaderByStatus(@Param("status") List<String> status);

}
