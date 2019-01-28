package com.ats.triladmin.repository.queryitems;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.getqueryitems.GetIssueQueryItem;

public interface GetIssueQueryItemRepo extends JpaRepository<GetIssueQueryItem, Integer> {
	
	
	
	@Query(value = " SELECT item_issue_detail.issue_detail_id ,item_issue_header.issue_no,item_issue_header.issue_date,\n" + 
			"item_issue_detail.item_issue_qty,m_item.item_code,m_item.item_desc,m_item.item_uom,\n" + 
			"m_dept.dept_code,m_dept.dept_desc,m_sub_dept.sub_dept_code,m_sub_dept.sub_dept_desc \n" + 
			"FROM item_issue_detail,item_issue_header,m_item,m_dept,m_sub_dept\n" + 
			"WHERE item_issue_detail.issue_id=item_issue_header.issue_id AND item_issue_header.dept_id=m_dept.dept_id AND item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id\n" + 
			"AND item_issue_detail.item_id=m_item.item_id AND item_issue_header.issue_date>=:fromDate AND \n" + 
			"item_issue_detail.item_id=:itemId ", 
			nativeQuery = true)
	List<GetIssueQueryItem> getIssueQueryItem(@Param("fromDate") Date fromDate,@Param("itemId") int itemId);
	

}
