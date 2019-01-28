package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.IssueDetail;

public interface IssueDetailRepository extends JpaRepository<IssueDetail, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE IssueDetail SET status=:status WHERE issue_detail_id in (:issueDetalId)")
	int updateStatusWhileApprov(@Param("issueDetalId")List<Integer> issueDetalId,@Param("status") int status);

}
