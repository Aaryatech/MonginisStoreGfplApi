package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.mrn.GetMrnItemDetail;

public interface GetItemMrnDetailRepo extends JpaRepository<GetMrnItemDetail, Integer> {
	
	@Query(value="SELECT  t_mrn_detail.mrn_detail_id , t_mrn_detail.batch_no,m_item.item_desc,m_item.item_uom,t_mrn_detail.remaining_qty,t_mrn_detail.exp_date FROM `t_mrn_detail`,m_item WHERE t_mrn_detail.item_id=m_item.item_id and t_mrn_detail.remaining_qty>0 AND t_mrn_detail.exp_date <:toDt AND t_mrn_detail.exp_date >:fromDt and t_mrn_detail.is_header_item=0 ORDER BY `t_mrn_detail`.`exp_date` DESC ",
			nativeQuery=true)
	List<GetMrnItemDetail> getMrnItemDetailByExpDt(@Param("fromDt") String fromDt,
													@Param("toDt") String toDt);

}
