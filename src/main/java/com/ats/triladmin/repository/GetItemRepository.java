package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetItem;

public interface GetItemRepository extends JpaRepository<GetItem, Integer> {

	@Query(value = "select m.*, c.cat_desc, g.grp_code, sg.subgrp_desc from m_item m, m_category c, m_item_group g, m_item_subgroup sg "
			+ " where  c.cat_id = m.cat_id and g.grp_id = m.grp_id and sg.subgrp_id = m.sub_grp_id and m.is_used = 1", nativeQuery = true)
	List<GetItem> getAllItems();

	@Query(value = "select m.*, c.cat_desc, g.grp_code, sg.subgrp_desc from m_item m, m_category c, m_item_group g, m_item_subgroup sg "
			+ "where m.item_id=:itemId and c.cat_id = m.cat_id and g.grp_id = m.grp_id and sg.subgrp_id = m.sub_grp_id ", nativeQuery = true)
	GetItem getItemByItemId(@Param("itemId") int itemId);

	@Query(value = "select m.*, c.cat_desc, g.grp_code, sg.subgrp_desc from m_item m, m_category c, m_item_group g, m_item_subgroup sg "
			+ " where  c.cat_id = m.cat_id and g.grp_id = m.grp_id and sg.subgrp_id = m.sub_grp_id and g.grp_id=:groupId and m.is_used = 1", nativeQuery = true)
	List<GetItem> itemListByGroupId(@Param("groupId") int groupId);

	@Query(value = "select m.*, c.cat_desc, g.grp_code, sg.subgrp_desc from m_item m, m_category c, m_item_group g, m_item_subgroup sg "
			+ " where  c.cat_id = m.cat_id and g.grp_id = m.grp_id and sg.subgrp_id = m.sub_grp_id and m.cat_id=:catId and m.is_used = 1", nativeQuery = true)
	List<GetItem> itemListByCatId(@Param("catId") int catId);

	@Query(value = "select m.*, c.cat_desc, g.grp_code, sg.subgrp_desc from m_item m, m_category c, m_item_group g, m_item_subgroup sg "
			+ "where m.item_id in (:itemIds) and c.cat_id = m.cat_id and g.grp_id = m.grp_id and sg.subgrp_id = m.sub_grp_id ", nativeQuery = true) 
	List<GetItem> getItemListByItemIds(@Param("itemIds")List<Integer> itemIds);

}
