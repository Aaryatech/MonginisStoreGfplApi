package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetpassItemVen;

public interface GetpassItemVenRepo extends JpaRepository<GetpassItemVen, Integer> {

	@Query(value = "SELECT h.*,v.vendor_name FROM t_gatepass_header h,m_vendor v WHERE gp_type=0 AND h.gp_vendor=v.vendor_id AND h.gp_vendor=:vendId AND h.is_used=1", nativeQuery = true)
	List<GetpassItemVen> getpassNonListByVendId(@Param("vendId") int vendId);

	@Query(value = "SELECT h.*,v.vendor_name FROM t_gatepass_header h,m_vendor v WHERE gp_type=0 AND h.gp_vendor=v.vendor_id  AND h.is_used=1", nativeQuery = true)
	List<GetpassItemVen> getpassAllNonListByVendId();

	@Query(value = "SELECT h.*,v.vendor_name FROM t_gatepass_header h,m_vendor v WHERE gp_type=1 AND h.gp_vendor=v.vendor_id AND h.gp_vendor=:vendId  AND h.is_used=1 AND h.gp_status IN(:gpStatusList)", nativeQuery = true)
	List<GetpassItemVen> getpassListByVendIdAndStatus(@Param("vendId") int vendId,
			@Param("gpStatusList") List<Integer> gpStatusList);

	@Query(value = "SELECT h.*,v.vendor_name FROM t_gatepass_header h,m_vendor v WHERE gp_type=1 AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND h.gp_status IN (:gpStatusList)", nativeQuery = true)
	List<GetpassItemVen> getpassListByStatus(@Param("gpStatusList") List<Integer> gpStatusList);

	@Query(value = "SELECT h.*,v.vendor_name FROM t_gatepass_header h,m_vendor v WHERE gp_type=1 AND h.gp_vendor=v.vendor_id AND h.gp_vendor=:vendId  AND h.is_used=1", nativeQuery = true)
	List<GetpassItemVen> getpassListByVendId(@Param("vendId") int vendId);

	@Query(value = "SELECT h.*,v.vendor_name FROM t_gatepass_header h,m_vendor v WHERE gp_type=1 AND h.gp_vendor=v.vendor_id  AND h.is_used=1", nativeQuery = true)
	List<GetpassItemVen> getpassAllList();
	
	@Query(value = "SELECT h.*,v.vendor_name FROM t_gatepass_header h,m_vendor v WHERE h.gp_status IN (:status) AND h.gp_vendor=v.vendor_id  AND h.is_used=1", nativeQuery = true)
	 List<GetpassItemVen> getGetpassItemHeaderApprove(@Param("status")List<Integer> status);

}
