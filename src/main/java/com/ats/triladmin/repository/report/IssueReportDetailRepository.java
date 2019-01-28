package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.IssueReportDetail;

public interface IssueReportDetailRepository extends JpaRepository<IssueReportDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_code,i.item_desc ,i.item_uom,dp.dept_desc,sd.sub_dept_desc,a.acc_head_desc FROM item_issue_detail d ,"
			+ "m_item i ,m_dept dp,m_sub_dept sd,m_account_head a WHERE  d.issue_id IN(:issueIdList) AND i.item_id=d.item_id AND "
			+ "dp.dept_id=d.dept_id AND sd.sub_dept_id=d.sub_dept_id AND a.acc_head_id=d. acc_head  and d.del_status=1", nativeQuery = true)
	List<IssueReportDetail> getIssueDetailReportList(@Param("issueIdList") List<Integer> issueIdList);

}
