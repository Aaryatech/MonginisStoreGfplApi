package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
			"        and md.del_status=1\n" + 
			"        and md.mrn_detail_status>=4\n" + 
			"        and mh.mrn_date<=:date\n" + 
			"        and mh.mrn_id=md.mrn_id and mh.del_status=1",nativeQuery=true)
	List<MrnDetail> findByItemIdAndDelStatusAndMrnDetailStatus(@Param("itemId")int itemId ,
			@Param("date")String date);

	@Query(value="select * from t_mrn_detail where mrn_detail_id in (:mrnDetailList) and del_status=1",nativeQuery=true)
	List<MrnDetail> getMrnDetailListByMrnDetailId(@Param("mrnDetailList")List<Integer> mrnDetailList);

	
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
	
	
	
}
