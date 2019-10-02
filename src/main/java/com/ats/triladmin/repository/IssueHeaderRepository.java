package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.IssueHeader;

public interface IssueHeaderRepository extends JpaRepository<IssueHeader, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE IssueHeader SET delete_status=0 WHERE issue_id=:issueId")
	int delete(@Param("issueId") int issueId);

	List<IssueHeader> findByDeleteStatus(int i);

	@Transactional
	@Modifying
	@Query("UPDATE IssueHeader SET status=:status WHERE issue_id=:issueId")
	int updateStatusWhileApprov(@Param("issueId") int issueId, @Param("status") int status);

	@Query(value=("select mrn_no from t_mrn_header where mrn_id=(select max(mrn_id) from t_mrn_header where mrn_date=:date)"),nativeQuery=true)
	String generateMrnNo(@Param("date") String date);

	@Query(value=("select issue_no from item_issue_header where issue_id=(select max(issue_id) from item_issue_header where issue_date=:date)"),nativeQuery=true)
	String generateIssueNo(String date);

	@Query(value=("select\r\n" + 
			"        po_no \r\n" + 
			"    from\r\n" + 
			"        po_header \r\n" + 
			"    where\r\n" + 
			"        po_id=(\r\n" + 
			"            select\r\n" + 
			"                max(po_id) \r\n" + 
			"            from\r\n" + 
			"                po_header \r\n" + 
			"            where\r\n" + 
			"                po_date=:date\r\n" + 
			"        )"),nativeQuery=true)
	String generatePoNo(@Param("date")String date);

}
