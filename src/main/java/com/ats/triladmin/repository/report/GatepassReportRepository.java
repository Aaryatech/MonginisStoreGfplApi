package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.GatepassReport;

public interface GatepassReportRepository extends JpaRepository<GatepassReport, Integer> {

	@Query(value = "SELECT h.*,v.vendor_name,v.vendor_code ,v.vendor_add1 FROM t_gatepass_header h ,m_vendor v WHERE  h.gp_type=0  AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND h.gp_id IN(:gpIdList)"
			+ "", nativeQuery = true)
	List<GatepassReport> gatepassReportHeader(@Param("gpIdList") List<Integer> gpIdList);

	@Query(value = "SELECT h.*,v.vendor_name,v.vendor_code ,v.vendor_add1 FROM t_gatepass_header h ,m_vendor v WHERE  h.gp_type=1   AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND h.gp_id IN(:gpIdList)"
			+ "", nativeQuery = true)
	List<GatepassReport> gatepassReportHeaderReturnable(@Param("gpIdList") List<Integer> gpIdList);

}
