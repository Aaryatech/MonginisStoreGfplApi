package com.ats.triladmin.model.rejection.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.rejection.GetRejectionMemoDetail;



public interface GetRejectionMemoDetailRepo extends JpaRepository<GetRejectionMemoDetail, Integer> {
	
	@Query(value = "SELECT t.*,concat(v.item_code,'  ',v.item_desc) as item_code FROM t_rejection_memo_detail t,m_item v WHERE v.item_id=t.item_id AND t.rejection_id=:rejectionId  AND t.is_used=1"
			+ " ", nativeQuery = true)
	List<GetRejectionMemoDetail> getRejectionMemoDetailById(@Param("rejectionId") int rejectionId);


}
