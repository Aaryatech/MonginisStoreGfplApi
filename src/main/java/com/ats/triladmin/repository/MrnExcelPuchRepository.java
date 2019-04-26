package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.MrnExcelPuch;
@Repository
public interface MrnExcelPuchRepository extends JpaRepository<MrnExcelPuch, Integer>{

	@Query(value="SELECT t_mrn_detail.mrn_detail_id,\n" + 
			"t_mrn_detail.mrn_id,\n" + 
			"m_category.cat_id as mrn_type_id,m_category.cat_id,\n" + 
			"m_category.cat_desc as mrn_type,\n" + 
			"t_mrn_header.mrn_no,\n" + 
			"t_mrn_header.mrn_date,\n" + 
			"t_mrn_header.bill_no,\n" + 
			"t_mrn_header.bill_date,\n" + 
			"po_header.po_no,\n" + 
			"po_header.po_date,\n" + 
			"'Purchase' as type,\n" + 
			"m_vendor.vendor_id,\n" + 
			"m_vendor.vendor_id as supplier_id,\n" + 
			"m_vendor.vendor_code as supplier_code,\n" + 
			"m_vendor.vendor_name as supplier_name,\n" + 
			"m_vendor.vendor_add4 as supp_erp_code,\n" + 
			"m_vendor.vendor_gst_no as gst_no,\n" + 
			"m_vendor.vendor_state as state,\n" + 
			"m_item.item_id,\n" + 
			"m_item.item_wt as vendor_erp_code,\n" + 
			"m_item.item_desc as item_name,\n" + 
			"m_tax_form.tax_desc as hsn_code,\n" + 
			"t_mrn_detail.mrn_qty as qty,\n" + 
			"po_detail.item_uom as uom,\n" + 
			"po_detail.item_rate as rate,\n" + 
			"(t_mrn_detail.mrn_qty * po_detail.item_rate)AS amount,\n" + 
			"po_detail.sgst as sgst_per,\n" + 
			"po_detail.cgst as cgst_per,\n" + 
			"po_detail.igst as igst_per,\n" + 
			"0 as cess_per,\n" + 
			"0 as cess_rs,\n" + 
			"\n" + 
			"(((po_detail.tax_value/2)/po_detail.item_qty)*t_mrn_detail.mrn_qty) as sgst_rs,\n" + 
			"(((po_detail.tax_value/2)/po_detail.item_qty)*t_mrn_detail.mrn_qty) as cgst_rs ,\n" + 
			"(((po_detail.tax_value)/po_detail.item_qty)*t_mrn_detail.mrn_qty) as igst_rs,\n" + 
			"po_detail.disc_per as item_discount,po_detail.disc_value as total_discount,\n" + 
			"po_detail.pack_value,\n" + 
			"po_detail.freight_value,\n" + 
			"po_detail.insu,\n" + 
			"po_detail.other_charges_befor,\n" + 
			"po_detail.other_charges_after\n" + 
			"\n" + 
			"FROM t_mrn_detail,t_mrn_header,po_header,po_detail,m_vendor,m_tax_form,indtrans,indent,m_category,m_item \n" + 
			"WHERE t_mrn_detail.mrn_id=t_mrn_header.mrn_id AND po_header.po_id=t_mrn_detail.po_id AND po_detail.po_detail_id=t_mrn_detail.po_detail_id AND\n" + 
			" po_header.po_id=po_detail.po_id AND m_vendor.vendor_id=po_header.vend_id AND t_mrn_detail.item_id=m_item.item_id AND m_tax_form.tax_id=m_item.item_is_capital AND t_mrn_header.mrn_id IN(:mrnIdList) AND indtrans.ind_d_id=po_detail.ind_id AND indtrans.ind_m_id=indent.ind_m_id AND indent.cat_id=m_category.cat_id ORDER BY t_mrn_header.mrn_date",nativeQuery=true)
	List<MrnExcelPuch> getMrnExcelReport(@Param("mrnIdList")List<String> mrnIdList);

}
