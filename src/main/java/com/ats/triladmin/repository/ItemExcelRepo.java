package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.triladmin.model.ItemExcel;

public interface ItemExcelRepo extends JpaRepository<ItemExcel, Integer> {

	@Query(value = "SELECT m_category.cat_id,m_category.cat_desc,m_item_group.grp_id,m_item_group.grp_desc,m_item.item_uom,m_item.item_uom2,m_item.item_id,m_item.item_desc,m_tax_form.tax_per FROM `m_item`,m_category,m_item_group,m_tax_form WHERE m_category.cat_id=m_item.cat_id and m_tax_form.tax_id=m_item.item_is_capital and m_item.grp_id=m_item_group.grp_id ORDER by item_id", nativeQuery = true)
	List<ItemExcel> getItemExcelList();

}
