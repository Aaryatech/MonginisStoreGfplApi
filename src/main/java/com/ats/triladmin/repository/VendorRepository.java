package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer>{

	Vendor findByVendorId(int vendorId);

	List<Vendor> findAllByIsUsed(int i);

	
	@Transactional
	@Modifying
	@Query("UPDATE Vendor SET isUsed=0 ,deleted_in=:deletedIn WHERE vendor_id=:vendorId")
	int deleteVendor(@Param("vendorId") int vendorId, @Param("deletedIn") int deletedIn);

	@Query(value=("select * from m_vendor where vendor_code = (select max(vendor_code) from m_vendor where vendor_code LIKE :str%)"),nativeQuery=true)
	Vendor getNextVendorNo(@Param("str") String str);

	@Query(value=("select\r\n" + 
			"        * \r\n" + 
			"    from\r\n" + 
			"        m_vendor \r\n" + 
			"    where\r\n" + 
			"        vendor_id in (\r\n" + 
			"            select\r\n" + 
			"                supp_id \r\n" + 
			"            from\r\n" + 
			"                m_rm_rate_verif \r\n" + 
			"            where\r\n" + 
			"                rm_id in (\r\n" + 
			"                    select\r\n" + 
			"                        item_id \r\n" + 
			"                    from\r\n" + 
			"                        indtrans \r\n" + 
			"                    where\r\n" + 
			"                        ind_m_id =:indId\r\n" + 
			"                        and del_status=1\r\n" + 
			"                        and ind_fyr>0\r\n" + 
			"                )\r\n" + 
			"            ) and is_used=1 and created_in=1"),nativeQuery=true)
	List<Vendor> getVendorByIndendId(@Param("indId")int indId);
 
	
}
