package com.ats.triladmin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.BillBookHeader;


public interface BillBookHeaderRepo extends JpaRepository<BillBookHeader, Integer>{
	
	
	@Query(value="select count(*) from t_bill_book_header where del_status=1 ",nativeQuery=true)
	int getBillListCount();
	
	@Query(value = " SELECT\r\n" + 
			"    h.bill_id,\r\n" + 
			"    h.bill_type,\r\n" + 
			"    h.bill_no,\r\n" + 
			"    h.bill_date,\r\n" + 
			"    h.vend_id,\r\n" + 
			"    v.vendor_name AS vend_quation,\r\n" + 
			"    h.vend_quation_date,\r\n" + 
			"    h.bill_basic_value,\r\n" + 
			"    h.disc_value,\r\n" + 
			"    h.bill_tax_id,\r\n" + 
			"    h.bill_tax_per,\r\n" + 
			"    h.bill_tax_value,\r\n" + 
			"    h.bill_pack_per,\r\n" + 
			"    h.bill_pack_val,\r\n" + 
			"    h.bill_pack_remark,\r\n" + 
			"    h.bill_insu_per,\r\n" + 
			"    h.bill_insu_val,\r\n" + 
			"    h.bill_insu_remark,\r\n" + 
			"    h.bill_frt_per,\r\n" + 
			"    h.bill_frt_val,\r\n" + 
			"    h.bill_frt_remark,\r\n" + 
			"    h.other_charge_before,\r\n" + 
			"    h.other_charge_before_remark,\r\n" + 
			"    h.other_charge_after,\r\n" + 
			"    h.other_charge_after_remark,\r\n" + 
			"    h.total_value,\r\n" + 
			"    h.delivery_id,\r\n" + 
			"    h.dispatch_id,\r\n" + 
			"    h.payment_term_id,\r\n" + 
			"    h.bill_remark,\r\n" + 
			"    h.bill_status,\r\n" + 
			"    h.prn_status,\r\n" + 
			"    h.prn_copies,\r\n" + 
			"    h.mrn_id,\r\n" + 
			"    h.mrn_no,\r\n" + 
			"    h.user_id,\r\n" + 
			"    h.del_status,\r\n" + 
			"    h.approv_status\r\n" + 
			"FROM\r\n" + 
			"    t_bill_book_header h,\r\n" + 
			"    m_vendor v\r\n" + 
			"WHERE\r\n" + 
			"    h.bill_id =:billId AND h.vend_id=v.vendor_id", nativeQuery = true)
	BillBookHeader getBillHeaderById(@Param("billId") int billId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE BillBookHeader SET billStatus=:status WHERE bill_id=:billId")
	int updateStatus(@Param("billId") int billId, @Param("status") int status);

	


}
