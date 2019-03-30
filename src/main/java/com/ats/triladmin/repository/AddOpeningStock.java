package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.OpeningStockModel;



public interface AddOpeningStock extends JpaRepository<OpeningStockModel, Integer>
{
	@Query(value = "SELECT m_item.item_id, m_item.item_code, m_item.item_desc,m_item.item_uom,m_item.item_uom2,m_item.item_op_rate,m_item.item_op_qty,m_tax_form.tax_desc,m_tax_form.cgst_per,m_tax_form.sgst_per,m_tax_form.igst_per FROM `m_item`,m_tax_form WHERE m_item.cat_id=:cat_id AND m_item.item_is_capital=m_tax_form.tax_id", nativeQuery = true)
	List<OpeningStockModel> getIteminfoOPeningStock(@Param("cat_id") int cat_id);
}
