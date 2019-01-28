package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.mrn.MrnReport;

public interface MrnReportRepo  extends JpaRepository<MrnReport, Integer>{
	
	@Query(value = " SELECT h.mrn_no,h.mrn_type,h.mrn_date,v.vendor_name,h.user_id,h.mrn_status, " + 
			" detail.*, item.item_code,item.item_desc, (pod.landing_cost / pod.item_qty) as landing_rate, pod.item_rate AS item_rate " + 
			" FROM t_mrn_header h,m_vendor v, t_mrn_detail detail,m_item item,po_detail pod " + 
			" WHERE h.vendor_id IN(:vendorIdList) AND v.vendor_id=h.vendor_id AND h.mrn_type IN(:grnTypeList) AND h.mrn_status IN(:statusList) "+
			 " AND h.del_status=1 AND h.mrn_date BETWEEN :fromDate AND :toDate " +
			" AND h.mrn_id=detail.mrn_id AND detail.po_detail_id=pod.po_detail_id AND detail.item_id=item.item_id "
			+ " ", nativeQuery = true)
	List<MrnReport> getMrnReport( @Param("vendorIdList") List<String> vendorIdList,@Param("grnTypeList") List<String> grnTypeList,
			@Param("statusList") List<String> statusList,@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT h.mrn_no,h.mrn_type,h.mrn_date,v.vendor_name,h.user_id,h.mrn_status, " + 
			"			detail.*, item.item_code,item.item_desc, (pod.landing_cost / pod.item_qty) as landing_rate, pod.item_rate AS item_rate " + 
			"			FROM t_mrn_header h,m_vendor v, t_mrn_detail detail,m_item item,po_detail pod " + 
			"			WHERE  v.vendor_id=h.vendor_id AND h.mrn_type IN(:grnTypeList) AND h.mrn_status IN(:statusList) " + 
			"			 AND h.del_status=1 AND h.mrn_date BETWEEN :fromDate AND :toDate " + 
			"			 AND h.mrn_id=detail.mrn_id AND detail.po_detail_id=pod.po_detail_id AND detail.item_id=item.item_id "
			+ " ", nativeQuery = true)
	List<MrnReport> getMrnReportAllVendor(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("grnTypeList") List<String> grnTypeList, @Param("statusList") List<String> statusList);

}
