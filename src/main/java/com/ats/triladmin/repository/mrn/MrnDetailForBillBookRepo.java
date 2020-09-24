package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.mrn.MrnDetailForBillBook;


public interface MrnDetailForBillBookRepo extends JpaRepository<MrnDetailForBillBook, Integer> {
	
	@Query(value = ("SELECT\r\n" + 
			"        d.mrn_id,\r\n" + 
			"        d.mrn_qty,\r\n" + 
			"        d.approve_qty,\r\n" + 
			"        d.mrn_detail_id,\r\n" + 
			"        pd.po_id,\r\n" + 
			"        pd.mrn_qty as po_mrn_qty,\r\n" + 
			"        pd.item_id,\r\n" + 
			"        pd.item_uom,\r\n" + 
			"        pd.item_rate,        \r\n" + 
			"        pd.disc_per,\r\n" + 
			"        pd.disc_value,\r\n" + 
			"        pd.sch_days,\r\n" + 
			"        pd.sch_date,\r\n" + 
			"        pd.sch_remark,\r\n" + 
			"        pd.basic_value,\r\n" + 
			"        pd.pack_value,\r\n" + 
			"        pd.insu,\r\n" + 
			"        pd.other_charges_befor,\r\n" + 
			"        pd.other_charges_after,\r\n" + 
			"        pd.tax_value,\r\n" + 
			"        pd.freight_value,\r\n" + 
			"        pd.landing_cost,\r\n" + 
			"        pd.cgst,\r\n" + 
			"        pd.sgst,\r\n" + 
			"        pd.igst,\r\n" + 
			"        i.item_code AS item_code,\r\n" + 
			"        i.item_desc AS item_name  \r\n" + 
			"    FROM\r\n" + 
			"        t_mrn_detail d,\r\n" + 
			"        po_detail pd,\r\n" + 
			"        m_item i  \r\n" + 
			"    WHERE\r\n" + 
			"        d.del_status = 1 \r\n" + 
			"        AND d.po_detail_id = pd.po_detail_id \r\n" + 
			"        AND d.item_id = i.item_id \r\n" + 
			"        AND d.mrn_id =:mrnId\r\n" + 
			"    ORDER BY\r\n" + 
			"        d.mrn_detail_id"), nativeQuery = true)
	List<MrnDetailForBillBook> getMrnDetailForBillBook(@Param("mrnId") int mrnId);
	
	
// Update On=24-09-2020
// Desc= Add approved_mrn_qty from t_mrn_detail and mrn_qty  from po_detail
//	SELECT\r\n" + 
//	"    d.mrn_id,\r\n" + 
//	"    d.mrn_qty,\r\n" + 
//	"    d.mrn_detail_id,\r\n" + 
//	"    pd.po_id,\r\n" + 
//	"    pd.item_id,\r\n" + 
//	"    pd.item_uom,\r\n" + 
//	"    pd.item_rate,\r\n" + 
//	"    pd.mrn_qty,\r\n" + 
//	"    pd.disc_per,\r\n" + 
//	"    pd.disc_value,\r\n" + 
//	"    pd.sch_days,\r\n" + 
//	"    pd.sch_date,\r\n" + 
//	"    pd.sch_remark,\r\n" + 
//	"    pd.basic_value,\r\n" + 
//	"    pd.pack_value,\r\n" + 
//	"    pd.insu,\r\n" + 
//	"    pd.other_charges_befor,\r\n" + 
//	"    pd.other_charges_after,\r\n" + 
//	"    pd.tax_value,\r\n" + 
//	"    pd.freight_value,\r\n" + 
//	"    pd.landing_cost,\r\n" + 
//	"    pd.cgst,\r\n" + 
//	"    pd.sgst,\r\n" + 
//	"    pd.igst,\r\n" + 
//	"    i.item_code AS item_code,\r\n" + 
//	"    i.item_desc AS item_name\r\n" + 
//	"FROM\r\n" + 
//	"    t_mrn_detail d,\r\n" + 
//	"    po_detail pd,\r\n" + 
//	"    m_item i\r\n" + 
//	"WHERE\r\n" + 
//	"    d.del_status = 1 AND d.po_detail_id = pd.po_detail_id AND d.item_id = i.item_id AND d.mrn_id =:mrnId\r\n" + 
//	"ORDER BY\r\n" + 
//	"    d.mrn_detail_id 
	
	/*----------------------------------------------------------------------*/
	
	
	@Query(value = ("SELECT\r\n" + 
			"    0 AS mrn_id,\r\n" + 
			"    i.item_id AS mrn_detail_id,\r\n" + 
			"    0 AS po_id,\r\n" + 
			"    i.item_id,\r\n" + 
			"    i.item_uom,\r\n" + 
			"    0 AS item_rate,\r\n" + 
			"    1 AS mrn_qty,\r\n" + 
			"    0 AS disc_per,\r\n" + 
			"    0 AS disc_value,\r\n" + 
			"    0 AS sch_days,\r\n" + 
			"    '' AS sch_date,\r\n" + 
			"    '' AS sch_remark,\r\n" + 
			"    0 AS basic_value,\r\n" + 
			"    0 AS pack_value,\r\n" + 
			"    0 AS insu,\r\n" + 
			"    0 AS other_charges_befor,\r\n" + 
			"    0 AS other_charges_after,\r\n" + 
			"    0 AS tax_value,\r\n" + 
			"    0 AS freight_value,\r\n" + 
			"    0 AS landing_cost,\r\n" + 
			"    t.cgst_per AS cgst,\r\n" + 
			"    t.sgst_per AS sgst,\r\n" + 
			"    t.igst_per AS igst,\r\n" + 
			"    i.item_code AS item_code,\r\n" + 
			"    i.item_desc AS item_name,\r\n" + 
			"    0 AS approve_qty,\r\n" + 
			"    0 AS po_mrn_qty\r\n" + 
			"FROM\r\n" + 
			"    m_item i,\r\n" + 
			"    m_tax_form t\r\n" + 
			"WHERE\r\n" + 
			"    i.deleted_in = 0 AND i.created_in = 0 AND i.item_is_capital = t.tax_id\r\n" + 
			"ORDER BY\r\n" + 
			"    i.item_id "), nativeQuery = true)
	List<MrnDetailForBillBook> getAccountLevelItemListForBill();

	
	

}
