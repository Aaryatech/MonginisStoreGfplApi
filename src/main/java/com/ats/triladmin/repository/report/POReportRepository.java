package com.ats.triladmin.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.report.IndentReport;
import com.ats.triladmin.model.report.POReport;

public interface POReportRepository extends JpaRepository<POReport, Integer> {

	@Query(value = "SELECT\r\n" + 
			"        h.*,\r\n" + 
			"        v.vendor_name,\r\n" + 
			"        v.vendor_code,\r\n" + 
			"        v.vendor_add1,\r\n" + 
			"        v.vendor_gst_no, \r\n" + 
			"        t.delivery_desc ,\r\n" + 
			"        dp.disp_mode_desc ,\r\n" + 
			"        pt.pymt_desc,\r\n" + 
			"        id.ind_m_date,0 as tax_desc \r\n" + 
			"    FROM\r\n" + 
			"        po_header h ,\r\n" + 
			"        m_vendor v, \r\n" + 
			"        m_delivery_terms t,\r\n" + 
			"        m_dispatch_mode dp ,\r\n" + 
			"        m_payment_terms pt,\r\n" + 
			"        indent id \r\n" + 
			"    WHERE\r\n" + 
			"        h.po_id IN(:poIdList) \r\n" + 
			"        AND h.del_status=1 \r\n" + 
			"        AND v.vendor_id=h.vend_id  \r\n" + 
			"        AND t.delivery_term_id=h.delivery_id \r\n" + 
			"        AND h.dispatch_id=dp.disp_mode_id \r\n" + 
			"        AND h.payment_term_id=pt.pymt_term_id \r\n" + 
			"        and id.ind_m_id = h.ind_id ", nativeQuery = true)
	List<POReport> getPOReportHeaderList(@Param("poIdList") List<Integer> poIdList);

	@Query(value = "SELECT\r\n" + 
			"        h.*,\r\n" + 
			"        v.vendor_name,\r\n" + 
			"        v.vendor_code,\r\n" + 
			"        v.vendor_add1,\r\n" + 
			"        v.vendor_gst_no, \r\n" + 
			"        t.delivery_desc ,\r\n" + 
			"        dp.disp_mode_desc ,\r\n" + 
			"        pt.pymt_desc,\r\n" + 
			"        id.ind_m_date,0 as tax_desc \r\n" + 
			"    FROM\r\n" + 
			"        po_header h ,\r\n" + 
			"        m_vendor v, \r\n" + 
			"        m_delivery_terms t,\r\n" + 
			"        m_dispatch_mode dp ,\r\n" + 
			"        m_payment_terms pt,\r\n" + 
			"        indent id \r\n" + 
			"    WHERE\r\n" + 
			"        h.del_status=1 \r\n" + 
			"        AND v.vendor_id=h.vend_id  \r\n" + 
			"        AND t.delivery_term_id=h.delivery_id \r\n" + 
			"        AND h.dispatch_id=dp.disp_mode_id \r\n" + 
			"        AND h.payment_term_id=pt.pymt_term_id \r\n" + 
			"        and id.ind_m_id = h.ind_id and id.cat_id=:catId and h.po_date between :fromDate and :toDate ", nativeQuery = true)
	List<POReport> getAllPoListHeaderByDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("catId") int catId);

	@Query(value = "SELECT\r\n" + 
			"        h.*,\r\n" + 
			"        v.vendor_name,\r\n" + 
			"        v.vendor_code,\r\n" + 
			"        v.vendor_add1,\r\n" + 
			"        v.vendor_gst_no, \r\n" + 
			"        t.delivery_desc ,\r\n" + 
			"        dp.disp_mode_desc ,\r\n" + 
			"        pt.pymt_desc,\r\n" + 
			"        id.ind_m_date,0 as tax_desc \r\n" + 
			"    FROM\r\n" + 
			"        po_header h ,\r\n" + 
			"        m_vendor v, \r\n" + 
			"        m_delivery_terms t,\r\n" + 
			"        m_dispatch_mode dp ,\r\n" + 
			"        m_payment_terms pt,\r\n" + 
			"        indent id \r\n" + 
			"    WHERE\r\n" + 
			"        h.del_status=1 \r\n" + 
			"        AND v.vendor_id=h.vend_id  \r\n" + 
			"        AND t.delivery_term_id=h.delivery_id \r\n" + 
			"        AND h.dispatch_id=dp.disp_mode_id \r\n" + 
			"        AND h.payment_term_id=pt.pymt_term_id \r\n" + 
			"        and id.ind_m_id = h.ind_id and h.po_date between :fromDate and :toDate ", nativeQuery = true)
	List<POReport> getAllPoListHeaderByDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

}
