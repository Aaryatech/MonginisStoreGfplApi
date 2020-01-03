package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.mrn.RateVerificationList;

public interface RateVerificationListRepo extends JpaRepository<RateVerificationList, Integer> {

	@Query(value="SELECT\n" + 
			"    rv.rm_rate_ver_id,\n" + 
			"    rv.rm_id,\n" + 
			"    rv.supp_id,\n" + 
			"    i.item_desc\n" + 
			"FROM\n" + 
			"    m_rm_rate_verif rv,\n" + 
			"    m_item i,\n" + 
			"    m_vendor v\n" + 
			"WHERE\n" + 
			"    rv.supp_id = :vendrId AND i.item_id = rv.rm_id AND "
			+ "v.vendor_id = rv.supp_id AND "
			+ "i.is_used = 1",nativeQuery=true)
	public List<RateVerificationList> getVendorItemsList(@Param("vendrId") int vendrId);
}
