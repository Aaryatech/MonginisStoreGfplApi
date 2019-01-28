package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.VendorListForRateVarification;

public interface VendorListForRateVarificationRepository extends JpaRepository<VendorListForRateVarification, Integer>{
	
	@Query(value=("select v.*,rv.rate_tax_incl,rv.rate_tax_extra from m_vendor v,m_rm_rate_verif rv where rv.supp_id=v.vendor_id and rv.rm_id=:itemId and v.is_used=1"),nativeQuery=true)
	 List<VendorListForRateVarification> getVendorListByItemIdForRateVerification(@Param("itemId") int itemId);

}
