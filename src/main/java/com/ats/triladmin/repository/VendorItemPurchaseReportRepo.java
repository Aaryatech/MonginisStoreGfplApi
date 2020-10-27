package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.mrn.VendorItemPurchaseReport;

public interface VendorItemPurchaseReportRepo extends JpaRepository<VendorItemPurchaseReport, Integer> {

	@Query(value="SELECT UUID() as id,\n" + 
			"    m_item.item_id,\n" + 
			"    m_item.item_desc,\n" + 
			"    t_mrn_header.mrn_no,\n" + 
			"    t_mrn_header.mrn_date, t_mrn_header.bill_no,\n" + 
			"    t_mrn_detail.approve_qty, m_vendor.vendor_name,\n" + 
			"    po_detail.basic_value,\n" + 
			"    po_detail.tax_value,\n" + 
			"    po_detail.landing_cost\n" + 
			"FROM\n" + 
			"    po_detail,\n" + 
			"    po_header,\n" + 
			"    t_mrn_header,\n" + 
			"    t_mrn_detail,\n" + 
			"    m_item,  m_vendor\n" + 
			"WHERE\n" + 
			"	m_item.item_id IN (:itemsList) AND\n" + 
			"    m_vendor.vendor_id=:vendrId AND  m_vendor.vendor_id=t_mrn_header.vendor_id AND\n" + 
			"    t_mrn_header.mrn_date BETWEEN :fromDate AND :toDate AND \n" + 
			"    m_item.item_id=po_detail.item_id AND\n" + 
			"    t_mrn_detail.item_id=m_item.item_id and\n" + 
			"    po_detail.po_id=po_header.po_id AND\n" + 
			"    t_mrn_detail.po_id=po_header.po_id AND\n" + 
			"    t_mrn_detail.mrn_id=t_mrn_header.mrn_id  AND"
			+ " 	t_mrn_detail.del_status=1\n" + 
			"        AND t_mrn_detail.is_header_item=1	and	t_mrn_header.del_status=1 ORDER BY t_mrn_header.mrn_no DESC",nativeQuery=true)
	public List<VendorItemPurchaseReport> getVendorItemPurchaseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate, 
			@Param("vendrId") int vendrId, @Param("itemsList") List<Integer> itemsList);
	
}
