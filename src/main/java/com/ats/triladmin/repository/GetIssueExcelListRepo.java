package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetIssueExcelList;

public interface GetIssueExcelListRepo extends JpaRepository<GetIssueExcelList, Integer> {

@Query(value="SELECT \n" + 
		"        h.issue_id,\n" + 
		"        DATE_FORMAT(h.issue_date, '%d-%m-%Y') issue_date,\n" + 
		"        h.issue_no as issue_slip_no,\n" + 
		"        d.issue_detail_id,\n" + 
		"        i.item_id,\n" + 
		"        i.item_desc,\n" + 
		"        d.item_issue_qty,\n" + 
		"        i.item_uom,\n" + 
		"        d.batch_no,\n" + 
		"        0 as item_rate\n" + 
		"        \n" + 
		"FROM \n" + 
		"    m_item i,\n" + 
		"    item_issue_detail d,\n" + 
		"    item_issue_header h\n" + 
		"    \n" + 
		"WHERE\n" + 
		"    d.issue_id=h.issue_id AND \n" + 
		"    d.item_id=i.item_id AND\n" + 
		"    h.delete_status=1 AND\n" + 
		"    h.issue_date BETWEEN :fromDate AND :toDate ORDER BY h.issue_date DESC", nativeQuery=true)
	List<GetIssueExcelList> getIssueListBetwnDate(@Param("fromDate") String fromDate, 
			@Param("toDate") String toDate); 
}
