package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.RmRateVerificationList;

public interface RmRateVerificationListRepo extends JpaRepository<RmRateVerificationList, Integer>{

	RmRateVerificationList findByRmIdAndSuppId(int itemId, int vendId);
	 
	List<RmRateVerificationList> findBySuppId(int vendId);

	@Query(value = "select\r\n" + 
			"        rv.rm_rate_ver_id,\r\n" + 
			"        rv.rm_id,\r\n" + 
			"        rv.supp_id,\r\n" + 
			"        rv.rate_date,\r\n" + 
			"        rv.rate_tax_extra,\r\n" + 
			"        rv.rate_tax_incl,\r\n" + 
			"        tf.tax_id,\r\n" + 
			"        s.state_code as date1,\r\n" + 
			"        tf.igst_per as rate_1_tax_extra ,\r\n" + 
			"        rv.rate_1_tax_incl,\r\n" + 
			"        rv.date2,\r\n" + 
			"        rv.rate_2_tax_extra,\r\n" + 
			"        rv.rate_2_tax_incl,\r\n" + 
			"        rv.grp_id \r\n" + 
			"    from\r\n" + 
			"        m_rm_rate_verif rv,\r\n" + 
			"        m_item i,\r\n" + 
			"        m_vendor v,\r\n" + 
			"        m_state s,\r\n" + 
			"        m_tax_form tf\r\n" + 
			"    where\r\n" + 
			"        rv.supp_id =:vendId \r\n" + 
			"        and i.item_id=rv.rm_id\r\n" + 
			"        and tf.tax_id=i.item_is_capital\r\n" + 
			"        and v.vendor_id=rv.supp_id \r\n" + 
			"        and v.vendor_state_id = s.state_id and i.is_used=1", nativeQuery = true)
	List<RmRateVerificationList> findStsteCodeTaxPerBySuppId(@Param("vendId")int vendId);

}
