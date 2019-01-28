package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetIssueDetail;

public interface GetIssueDetailRepository extends JpaRepository<GetIssueDetail, Integer>{

	
	@Query(value=("select id.*,CONCAT(i.item_code, '-', i.item_desc) as item_code, CONCAT(g.grp_code,' ', g.grp_desc) as grp_code,d.dept_code,sd.sub_dept_code,a.acc_head_desc from "
			+ "item_issue_detail id,m_item_group g,m_dept d,m_sub_dept sd,m_account_head a,m_item i  "
			+ "where id.issue_id=:issueId and id.del_status = 1 and g.grp_id = id.item_group_id and d.dept_id = id.dept_id "
			+ "and sd.sub_dept_id = id.sub_dept_id and a.acc_head_id=id.acc_head and id.item_id = i.item_id"),nativeQuery=true)
	List<GetIssueDetail> findByIssueId(@Param("issueId") int issueId);

}
