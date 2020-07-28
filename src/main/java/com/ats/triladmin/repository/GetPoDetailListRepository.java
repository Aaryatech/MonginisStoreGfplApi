package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetPoDetailList;

public interface GetPoDetailListRepository extends JpaRepository<GetPoDetailList, Integer>{

	/*@Query(value = "select p.*,CONCAT(i.item_code, '-', i.item_desc) as item_code,i.created_in as item_desc from po_detail p,m_item i where po_id=:poId and p.item_id=i.item_id ", nativeQuery = true)
	List<GetPoDetailList> getDetail(@Param("poId") int poId);
*/
	
	@Query(value = "select  p.po_id,p.po_detail_id,p.ind_id,p.vend_id,p.item_id,p.item_uom,p.item_qty,p.item_rate,p.mrn_qty,p.pending_qty, " + 
			"      p.inded_qty,p.disc_per,p.disc_value,p.sch_days,p.sch_date,p.sch_remark,p.status,p.basic_value,p.pack_value, " + 
			"      p.pack_value,p.insu,p.other_charges_befor,p.tax_value,p.freight_value,p.other_charges_after,p.landing_cost,p.cgst,p.sgst,p.igst,CONCAT(i.item_code, '-', i.item_desc) as item_code,i.created_in as item_desc from po_detail p,m_item i where po_id=:poId and p.item_id=i.item_id ", nativeQuery = true)
	List<GetPoDetailList> getDetail(@Param("poId") int poId);
	 
      
	
	
}
