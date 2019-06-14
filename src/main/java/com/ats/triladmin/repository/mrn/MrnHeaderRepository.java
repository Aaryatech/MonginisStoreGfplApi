package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.mrn.GetMrnHeader;
import com.ats.triladmin.model.mrn.MrnHeader;

public interface MrnHeaderRepository extends JpaRepository<MrnHeader, Integer>{
	
	MrnHeader save(MrnHeader mrnHeader);

	@Transactional
	@Modifying
	@Query("UPDATE MrnHeader SET mrn_status=2  WHERE mrn_id=:mrnId ")
	int updateMrnStatus(@Param("mrnId") int mrnId);
	
	@Transactional
	@Modifying
	@Query("UPDATE MrnHeader SET mrn_status=1  WHERE mrn_id=:mrnId ")
	int updateMrnStatusAsPartial(@Param("mrnId")int mrnId);

	@Transactional
	@Modifying
	@Query("UPDATE MrnHeader SET mrn_status=6  WHERE mrn_id=:mrnId ")
	int updateMrnStatusAccount(@Param("mrnId")int mrnId);
	
	@Transactional
	@Modifying
	@Query("UPDATE MrnHeader SET del_status=0 WHERE mrn_id=:mrnId ")
	int deleteMrnHeader(@Param("mrnId")int mrnId);

	

	List<MrnHeader> findAllByDelStatus(int i);
	
	//9 aug sachin
	MrnHeader findByMrnId(int mrnId);

	@Query(value=("select mh.* from t_mrn_detail md,t_mrn_header mh where md.mrn_id = mh.mrn_id and remaining_qty>0 and mh.vendor_id=:vendId and item_id=:itemId and "
			+ "mh.del_status=1 and md.del_status=1  group by mh.mrn_id"),nativeQuery=true)
	List<MrnHeader> getMrnListByVendorIdForRejectionMemo(@Param("vendId")int vendId, @Param("itemId") int itemId);

	@Query(value=("select mh.* from t_mrn_detail md,t_mrn_header mh where md.mrn_id = mh.mrn_id and reject_qty>0 and mh.vendor_id=:vendId and "
			+ "mh.del_status=1 and md.del_status=1 and mh.mrn_id Not In(select mrn_id from t_rejection_memo where is_used=1) group by mh.mrn_id"),nativeQuery=true)
	List<MrnHeader> getMrnListByVendorIdForRejectionMemo(@Param("vendId")int vendId);
	
	@Transactional
	@Modifying
	@Query("UPDATE MrnHeader SET mrn_status=:status  WHERE mrn_id=:mrnId ")
	int updateStatusWhileApprov(@Param("mrnId") int mrnId,@Param("status") int status);

	@Query(value=("select i.dept_id from indent i,po_header po where po.po_id=:poId and po.ind_id=i.ind_m_id"),nativeQuery=true) 
	String getDeptId(@Param("poId") int poId);

	@Query(value=("select i.sub_dept_id from indent i,po_header po where po.po_id=:poId and po.ind_id=i.ind_m_id"),nativeQuery=true) 
	String getSubDept(@Param("poId") int poId);

	@Query(value=("select i.achd_id from indent i,po_header po where po.po_id=:poId and po.ind_id=i.ind_m_id"),nativeQuery=true) 
	String getAccHead(@Param("poId") int poId);
 
	@Transactional
	@Modifying
	@Query("UPDATE MrnHeader SET mrn_status=:status  WHERE mrn_id=:mrnId ")
	int updateheaderStatus(@Param("mrnId")int mrnId,@Param("status")int status);


}
