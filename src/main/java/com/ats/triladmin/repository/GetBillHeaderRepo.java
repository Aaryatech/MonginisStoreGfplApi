package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetBillHeader;

public interface GetBillHeaderRepo extends JpaRepository<GetBillHeader, Integer> {

	@Query(value = " SELECT\r\n" + 
			"    h.bill_id,\r\n" + 
			"    h.bill_no,\r\n" + 
			"    h.bill_date,\r\n" + 
			"    h.vend_id,\r\n" + 
			"    h.bill_basic_value,\r\n" + 
			"    h.disc_value,\r\n" + 
			"    h.bill_tax_value,\r\n" + 
			"    h.total_value,\r\n" + 
			"    h.mrn_id,\r\n" + 
			"    h.mrn_no,\r\n" + 
			"    v.vendor_name, h.bill_status \r\n" + 
			"FROM\r\n" + 
			"    t_bill_book_header h,\r\n" + 
			"    m_vendor v\r\n" + 
			"WHERE\r\n" + 
			"    h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 1 AND v.vendor_id = h.vend_id", nativeQuery = true)
	List<GetBillHeader> getBillHeaderListByDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
}
