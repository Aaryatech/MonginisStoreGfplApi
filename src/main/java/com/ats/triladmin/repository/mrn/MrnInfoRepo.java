package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.triladmin.model.MrnInfo;

public interface MrnInfoRepo extends JpaRepository<MrnInfo, Integer> {

	@Query(value="SELECT\n" + 
			"		UUID() as id,\n" + 
			"        head.mrn_id,\n" + 
			"        head.mrn_date,\n" + 
			"        head.mrn_no,\n" + 
			"        vendor.vendor_name,\n" + 
			"        head.bill_no,\n" + 
			"        item.item_desc,\n" + 
			"        detail.approve_qty \n" + 
			"    FROM\n" + 
			"        t_mrn_header head,\n" + 
			"        t_mrn_detail detail,\n" + 
			"        m_item item,\n" + 
			"        m_vendor vendor \n" + 
			"    WHERE\n" + 
			"        head.mrn_id = detail.mrn_id \n" + 
			"        AND     detail.item_id = item.item_id \n" + 
			"        AND      head.vendor_id = vendor.vendor_id \n" + 
			"        AND     head.mrn_status=0 \n" + 
			"    ORDER BY\n" + 
			"        head.mrn_date DESC",nativeQuery=true)
	public List<MrnInfo> getMrnData();
	
}
