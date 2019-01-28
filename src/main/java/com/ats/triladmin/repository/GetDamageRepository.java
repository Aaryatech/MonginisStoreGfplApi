package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetDamage;

public interface GetDamageRepository extends JpaRepository<GetDamage, Integer>{

	@Query(value = "select\r\n" + 
			"        d.*,\r\n" + 
			"        i.item_code,\r\n" + 
			"        i.item_desc,\r\n" + 
			"        v.vendor_name,\r\n" + 
			"        v.vendor_code\r\n" + 
			"    from\r\n" + 
			"        t_damage d,\r\n" + 
			"        m_item i,\r\n" + 
			"        m_vendor v\r\n" + 
			"    where\r\n" + 
			"        d.item_id = i.item_id \r\n" + 
			"        and d.date between :fromDate and :toDate\r\n" + 
			"        and d.del_status=1\r\n" + 
			"        and d.extra1=v.vendor_id and extra2 in (:typeId)", nativeQuery = true)
	List<GetDamage> getDamageList(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("typeId") List<Integer> typeId);

	@Query(value = "select\r\n" + 
			"        d.*,\r\n" + 
			"        i.item_code,\r\n" + 
			"        i.item_desc,\r\n" + 
			"        v.vendor_code,\r\n" + 
			"        v.vendor_name\r\n" + 
			"    from\r\n" + 
			"        t_damage d,\r\n" + 
			"        m_item i,\r\n" + 
			"        m_vendor v\r\n" + 
			"    where\r\n" + 
			"        d.item_id = i.item_id \r\n" + 
			"        and d.damage_id =:damageId \r\n" + 
			"        and d.extra1=v.vendor_id", nativeQuery = true)
	GetDamage getDamageById(@Param("damageId") int damageId);
 
}
