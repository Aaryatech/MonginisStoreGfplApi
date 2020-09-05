package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.mrn.TempMrnItemDetail;

public interface TempMrnItemDetailRepo extends JpaRepository<TempMrnItemDetail, Integer> {
	
	
	@Query(value = " select  " + 
			"      d.uuid, " + 
			"        d.mrn_qty , " + 
			"        d.mrn_detail_id," + 
			"        d.mrn_id, " + 
			"        d.item_id, " + 
			"        i.item_desc as item_name, " + 
			"        i.item_code, " + 
			"        i.item_uom, " + 
			"        d.approve_qty, " + 
			"        d.batch_no, " + 
			" d.exp_date, " + 
			" d.is_header_item as detail_status " + 
			"    from " + 
			"        t_mrn_detail d, " + 
			"        m_item i " + 
			"    where " + 
			"        d.mrn_id=:mrnId  " + 
			"        and d.del_status=1  " + 
			"        and i.item_id=d.item_id  " + 
			"        and d.is_header_item=0 ", nativeQuery = true)
	
	List<TempMrnItemDetail> getTempMrnItemDetail(@Param("mrnId") int mrnId);
	

	
	
}
