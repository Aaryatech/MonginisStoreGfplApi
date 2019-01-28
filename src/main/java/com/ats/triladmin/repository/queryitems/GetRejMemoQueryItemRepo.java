package com.ats.triladmin.repository.queryitems;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.getqueryitems.GetRejMemoQueryItem;

public interface GetRejMemoQueryItemRepo extends JpaRepository<GetRejMemoQueryItem, Integer> {
	
		@Query(value = "SELECT t_rejection_memo_detail.rej_detail_id, t_rejection_memo_detail.rejection_qty,t_rejection_memo_detail.memo_qty,\n" + 
				"t_rejection_memo_detail.status,t_rejection_memo.rejection_date,t_rejection_memo.rejection_no as rej_no,\n" + 
				"m_vendor.vendor_code,m_vendor.vendor_name,\n" + 
				"m_item.item_code,m_item.item_desc,m_item.item_uom\n" + 
				" FROM t_rejection_memo_detail,t_rejection_memo,m_vendor,m_item\n" + 
				" WHERE t_rejection_memo_detail.rejection_id=t_rejection_memo.rejection_id AND t_rejection_memo_detail.item_id=m_item.item_id AND t_rejection_memo.vendor_id=m_vendor.vendor_id\n" + 
				" AND t_rejection_memo.rejection_date>=:fromDate AND t_rejection_memo_detail.item_id=:itemId", 
			nativeQuery = true)
		List<GetRejMemoQueryItem> getRejeMemoQueryItem(@Param("fromDate") Date fromDate,@Param("itemId") int itemId);

}
