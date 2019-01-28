package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.ItemListByRateVerification;

public interface ItemListByRateVerificationRepo extends JpaRepository<ItemListByRateVerification, Integer>{

	@Query(value = ("select\r\n" + 
			"        v.*,\r\n" + 
			"        rv.rate_tax_incl,\r\n" + 
			"        rv.rate_tax_extra \r\n" + 
			"    from\r\n" + 
			"        m_item v,\r\n" + 
			"        m_rm_rate_verif rv \r\n" + 
			"    where\r\n" + 
			"        rv.rm_id=v.item_id \r\n" + 
			"        and rv.supp_id=:vendId \r\n" + 
			"        and v.is_used=1"), nativeQuery = true)
	List<ItemListByRateVerification> getRateVerificationItemListByVendId(@Param("vendId") int vendId);

}
