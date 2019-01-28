package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GatepassReport;

public interface GatepassReportRepo extends JpaRepository<GatepassReport, Integer> {

	@Query(value = "SELECT d.gp_detail_id,h.gp_id,h.gp_no,h.gp_vendor,h.gp_date,d.gp_return_date,v.vendor_name,v.vendor_code,"
			+ "d.gp_item_id,d.gp_qty,d.gp_no_days,d.gp_status,d.gp_rem_qty,d.gp_ret_qty ,i.item_desc,i.item_code  FROM t_gatepass_header h ,"
			+ "m_vendor v,t_gatepass_detail d,m_item  i WHERE  h.gp_type=0 AND h.gp_date BETWEEN :fromDate AND :toDate "
			+ "AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND d.is_used=1 AND i.item_id=d.gp_item_id   AND d.gp_id=h.gp_id group by d.gp_detail_id \r\n"
			+ "", nativeQuery = true)
	List<GatepassReport> gatepassReportList(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT d.gp_detail_id,h.gp_id,h.gp_no,h.gp_vendor,h.gp_date,d.gp_return_date,v.vendor_name,v.vendor_code,"
			+ "d.gp_item_id,d.gp_qty,d.gp_no_days,d.gp_status,d.gp_rem_qty,d.gp_ret_qty ,i.item_desc,i.item_code  FROM t_gatepass_header h ,"
			+ "m_vendor v,t_gatepass_detail d,m_item  i WHERE  h.gp_type=0 AND h.gp_date BETWEEN :fromDate AND :toDate "
			+ "AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND d.is_used=1 AND i.item_id=d.gp_item_id AND h.gp_vendor IN(:vendorIdList)  AND d.gp_id=h.gp_id group by d.gp_detail_id  \r\n"
			+ "", nativeQuery = true)
	List<GatepassReport> gatepassReportListWWithVendor(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("vendorIdList") List<Integer> vendorIdList);

	@Query(value = "SELECT d.gp_detail_id,h.gp_id,h.gp_no,h.gp_vendor,h.gp_date,d.gp_return_date,v.vendor_name,v.vendor_code,"
			+ "d.gp_item_id,d.gp_qty,d.gp_no_days,d.gp_status,d.gp_rem_qty,d.gp_ret_qty ,i.item_desc,i.item_code  FROM t_gatepass_header h ,"
			+ "m_vendor v,t_gatepass_detail d,m_item  i WHERE  h.gp_type=0 AND h.gp_date BETWEEN :fromDate AND :toDate "
			+ "AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND d.is_used=1 AND i.item_id=d.gp_item_id AND d.gp_item_id IN(:itemIdList)   AND d.gp_id=h.gp_id group by d.gp_detail_id \r\n"
			+ "", nativeQuery = true)
	List<GatepassReport> gatepassReportListWWithItem(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemIdList") List<Integer> itemIdList);

	@Query(value = "SELECT d.gp_detail_id,h.gp_id,h.gp_no,h.gp_vendor,h.gp_date,d.gp_return_date,v.vendor_name,v.vendor_code,"
			+ "d.gp_item_id,d.gp_qty,d.gp_no_days,d.gp_status,d.gp_rem_qty,d.gp_ret_qty ,i.item_desc,i.item_code  FROM t_gatepass_header h ,"
			+ "m_vendor v,t_gatepass_detail d,m_item  i WHERE  h.gp_type=1 AND h.gp_date BETWEEN :fromDate AND :toDate "
			+ "AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND d.is_used=1 AND i.item_id=d.gp_item_id   AND d.gp_id=h.gp_id  AND h.gp_status !=3 AND d.gp_status !=3 group by d.gp_detail_id \r\n"
			+ "", nativeQuery = true)
	List<GatepassReport> gatepassReturnableReportList(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT d.gp_detail_id,h.gp_id,h.gp_no,h.gp_vendor,h.gp_date,d.gp_return_date,v.vendor_name,v.vendor_code,"
			+ "d.gp_item_id,d.gp_qty,d.gp_no_days,d.gp_status,d.gp_rem_qty,d.gp_ret_qty ,i.item_desc,i.item_code  FROM t_gatepass_header h ,"
			+ "m_vendor v,t_gatepass_detail d,m_item  i WHERE  h.gp_type=1 AND h.gp_date BETWEEN :fromDate AND :toDate "
			+ "AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND d.is_used=1 AND i.item_id=d.gp_item_id AND h.gp_vendor IN(:vendorIdList)  AND d.gp_id=h.gp_id AND h.gp_status !=3 AND d.gp_status !=3 group by d.gp_detail_id  \r\n"
			+ "", nativeQuery = true)
	List<GatepassReport> gatepassReportReturnListWWithVendor(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("vendorIdList") List<Integer> vendorIdList);

	@Query(value = "SELECT d.gp_detail_id,h.gp_id,h.gp_no,h.gp_vendor,h.gp_date,d.gp_return_date,v.vendor_name,v.vendor_code,"
			+ "d.gp_item_id,d.gp_qty,d.gp_no_days,d.gp_status,d.gp_rem_qty,d.gp_ret_qty ,i.item_desc,i.item_code  FROM t_gatepass_header h ,"
			+ "m_vendor v,t_gatepass_detail d,m_item  i WHERE  h.gp_type=1 AND h.gp_date BETWEEN :fromDate AND :toDate "
			+ "AND h.gp_vendor=v.vendor_id AND h.is_used=1 AND d.is_used=1 AND i.item_id=d.gp_item_id AND d.gp_item_id IN(:itemIdList)   AND d.gp_id=h.gp_id AND h.gp_status !=3 AND d.gp_status !=3 group by d.gp_detail_id \r\n"
			+ "", nativeQuery = true)
	List<GatepassReport> gatepassReportReturnableListWWithItem(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("itemIdList") List<Integer> itemIdList);

}
