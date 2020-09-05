package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.mrn.MrnDetail;

public interface MrnDetailRepo extends JpaRepository<MrnDetail, Integer> {

	
	MrnDetail save(MrnDetail mrnDetail);

	@Query(value="select count(*) as count from t_mrn_detail where mrn_id=:mrnId and mrn_detail_status=0",nativeQuery=true)
	int getDetailCount(@Param("mrnId")int mrnId);

	
	@Transactional
	@Modifying
	@Query("UPDATE MrnDetail SET del_status=0 WHERE mrn_detail_id=:mrnDetailId ")
	int deleteMrnDetail(@Param("mrnDetailId")int mrnDetailId);

	@Query(value="select\n" + 
			"       md.*\n" + 
			"    from\n" + 
			"        t_mrn_detail md,\n" + 
			"        t_mrn_header mh\n" + 
			"    where\n" + 
			"        md.item_id=:itemId\n" + 
			"        and md.del_status=1 and \n" + 
			//"        and md.mrn_detail_status>=4\n" + 
			" mh.mrn_status IN(3,4,5 " + 
			"        ) "+
			"        and mh.mrn_date<=:date \n" + 
			"        and mh.mrn_id=md.mrn_id and mh.del_status=1 and md.is_header_item=0 	ORDER BY md.exp_date ASC ",nativeQuery=true)
	List<MrnDetail> findByItemIdAndDelStatusAndMrnDetailStatus(@Param("itemId")int itemId ,
			@Param("date")String date); //and md.is_header_item=0 Added by Sachin 31-08-2020

	@Query(value="select * from t_mrn_detail where mrn_detail_id in (:mrnDetailList) and del_status=1",nativeQuery=true)
	List<MrnDetail> getMrnDetailListByMrnDetailId(@Param("mrnDetailList")List<Integer> mrnDetailList);

	//Sachin 03-09-2020
	@Query(value="select * from t_mrn_detail where mrn_detail_id in (:mrnDetailList) and del_status=1 and is_header_item=1 ",nativeQuery=true)
	List<MrnDetail> getMrnDetailListByMrnDetailIdAndHeaderItem1(@Param("mrnDetailList")List<Integer> mrnDetailList);

	List<MrnDetail> findByMrnId(int mrnId);
	
	MrnDetail findByMrnDetailIdAndDelStatus(int mrnDetailId,int delStatus);

	@Transactional
	@Modifying
	@Query("UPDATE MrnDetail SET mrnDetailStatus=:status WHERE mrn_detail_id IN (:mrnDetalId)")
	int updateStatusWhileApprov(@Param("mrnDetalId")List<Integer> mrnDetalId,@Param("status") int status);

	List<MrnDetail> findByMrnIdAndDelStatus(int mrnId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE MrnDetail SET remainingQty=:remQty WHERE mrn_detail_id=:mrnDetailedId")
	int updaetQty(@Param("mrnDetailedId")int mrnDetailedId,@Param("remQty") float remQty);

	MrnDetail findByMrnDetailId(int mrnDetailedId);

	@Query(value="select\n" + 
			"       md.*\n" + 
			"    from\n" + 
			"        t_mrn_detail md,\n" + 
			"        t_mrn_header mh\n" + 
			"    where\n" + 
			"        md.item_id in (:itemIds)\n" + 
			"        and md.del_status=1\n" + 
			"        and md.mrn_detail_status>=4\n" + 
			"        and mh.mrn_date<=:date\n" + 
			"        and mh.mrn_id=md.mrn_id and mh.del_status=1",nativeQuery=true)
	List<MrnDetail> getBatchByMultipleItemIds(@Param("itemIds")List<Integer> itemIds,@Param("date") String date);

	@Query(value="select md.mrn_detail_id,md.mrn_id,md.item_id,md.po_id,md.po_no,md.po_detail_id,md.indent_qty,md.po_qty,md.mrn_qty,"
			+ "md.approve_qty,m.grp_id as reject_qty,m.deleted_in as reject_remark,md.mrn_detail_status,md.batch_no,md.issue_qty,md.remaining_qty,"
			+ "md.del_status,md.chalan_qty from t_mrn_detail md, t_mrn_header mh, m_item m "
			+ "where\n" + 
			"        md.item_id=m.item_id        \n" + 
			"        and md.del_status=1         \n" + 
			"        and md.mrn_detail_status>=4         \n" + 
			"        and mh.mrn_date<=:date         \n" + 
			"        and mh.mrn_id=md.mrn_id \n" + 
			"        and mh.del_status=1\n" + 
			"        and remaining_qty>0\n" + 
			"        and m.deleted_in in (:itemIds)",nativeQuery=true)
	List<MrnDetail> findByItemIdsAndDelStatusAndMrnDetailStatus(@Param("itemIds")List<Integer> itemIds,@Param("date") String date);
	
	
	
}
