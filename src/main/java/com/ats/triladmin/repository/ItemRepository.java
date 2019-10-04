package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Item SET isUsed=0  WHERE item_id=:itemId")
	int deleteItem(@Param("itemId") int itemId);

	Item findItemByItemId(int itemId);

	List<Item> findAllByIsUsed(int i);

	@Query(value=("select *  from m_item where item_code = ( select max(item_code) from m_item where item_code LIKE :str% )"),nativeQuery=true)
	Item getNextItemCode(@Param("str") String str);

}
