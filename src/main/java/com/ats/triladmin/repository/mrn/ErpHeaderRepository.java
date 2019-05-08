package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.ErpHeader;
import com.ats.triladmin.model.mrn.MrnHeader;

public interface ErpHeaderRepository extends JpaRepository<ErpHeader, Integer> {
	@Query(value=("SELECT t_mrn_header.mrn_id,t_mrn_header.mrn_no,t_mrn_header.mrn_date,t_mrn_header.bill_no,t_mrn_header.bill_date,m_vendor.vendor_id,t_mrn_header.mrn_status,m_vendor.vendor_name FROM t_mrn_header,m_vendor WHERE m_vendor.vendor_id=t_mrn_header.vendor_id And t_mrn_header.mrn_date BETWEEN :fromDate AND :toDate And t_mrn_header.mrn_status IN(:Status) ORDER BY t_mrn_header.bill_date,t_mrn_header.mrn_id"),nativeQuery=true)
	List<ErpHeader> getErpHeader(@Param("fromDate")String fromDate, @Param("toDate") String toDate,@Param("Status") List<Integer> Status);


}
