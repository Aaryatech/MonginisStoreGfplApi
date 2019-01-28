package com.ats.triladmin.model.rejection.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.rejection.RejectionMemo;

public interface RejectionMemoRepo extends JpaRepository<RejectionMemo, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE RejectionMemo SET isUsed=0  WHERE rejection_id=:rejectionId")
	int deleteRejectionMemo(@Param("rejectionId") int rejectionId);

	RejectionMemo findByRejectionId(int rejectionId);

}
