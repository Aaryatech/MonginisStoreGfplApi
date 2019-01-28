package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetpassReturnVendor;

public interface GetpassReturnVendorRepo extends JpaRepository<GetpassReturnVendor, Integer> {

	@Query(value = "SELECT g.*,i.vendor_name FROM t_getpass_return g,m_vendor i WHERE  g.gp_return_date BETWEEN :fromDate AND :toDate AND g.is_used=1 AND i.vendor_id=g.vendor_id ", nativeQuery = true)
	List<GetpassReturnVendor> getAllHeaderWithVendor(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT g.*,i.vendor_name FROM t_getpass_return g,m_vendor i WHERE  g.gp_return_date BETWEEN :fromDate AND :toDate AND g.is_used=1 AND i.vendor_id=g.vendor_id AND g.vendor_id=:vendId ", nativeQuery = true)
	List<GetpassReturnVendor> getAllHeaderByVendId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("vendId") int vendId);

}
