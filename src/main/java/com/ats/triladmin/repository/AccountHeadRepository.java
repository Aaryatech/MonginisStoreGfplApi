package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.AccountHead;

public interface AccountHeadRepository extends JpaRepository<AccountHead, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE AccountHead SET isUsed=0 ,deleted_in=:deletedIn WHERE acc_head_id=:accHeadId")
	int deleteAccountHead(@Param("accHeadId") int accHeadId, @Param("deletedIn") int deletedIn);

	List<AccountHead> findAllByIsUsed(int i);

	AccountHead findCatByAccHeadId(int accHeadId);

}
