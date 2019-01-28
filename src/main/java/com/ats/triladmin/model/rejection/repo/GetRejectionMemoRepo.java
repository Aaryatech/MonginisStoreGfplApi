package com.ats.triladmin.model.rejection.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.rejection.GetRejectionMemo;

public interface GetRejectionMemoRepo extends JpaRepository<GetRejectionMemo, Integer> {

	@Query(value = "SELECT t.*,v.vendor_name,v.vendor_code FROM t_rejection_memo t,m_vendor v WHERE v.vendor_id=t.vendor_id AND t.rejection_date BETWEEN  :fromDate AND :toDate  AND t.is_used=1"
			+ " ", nativeQuery = true)
	List<GetRejectionMemo> getRejectionMemoByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT t.*,v.vendor_name,v.vendor_code FROM t_rejection_memo t,m_vendor v WHERE v.vendor_id=t.vendor_id AND t.rejection_id=:rejectionId  AND t.is_used=1"
			+ " ", nativeQuery = true)
	GetRejectionMemo getRejectionMemoById(@Param("rejectionId") int rejectionId);
	
//	SELECT d.rej_detail_id,t.rejection_id,t.rejection_no,t.vendor_id,t.rejection_date,v.vendor_name,v.vendor_code,d.item_id,d.rejection_qty,d.memo_qty,d.mrn_no,d.mrn_date,i.item_code,i.item_desc FROM t_rejection_memo t,m_vendor v,t_rejection_memo_detail d,m_item i WHERE v.vendor_id=t.vendor_id AND t.rejection_date BETWEEN  '2018-01-01' AND '2018-10-10' AND t.is_used=1 AND d.is_used=1 AND t.rejection_id=d.rejection_id AND i.item_id=d.item_id GROUP BY d.rej_detail_id ORDER BY v.vendor_id

}
