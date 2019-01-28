package com.ats.triladmin.repository.queryitems;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.getqueryitems.GetRetNonRetQueryItem;

public interface GetRetNonRetQueryItemRepo extends JpaRepository<GetRetNonRetQueryItem, Integer>{
	
	@Query(value = "SELECT t_gatepass_detail.gp_detail_id,t_gatepass_header.gp_type,t_gatepass_header.gp_no,"
			+ "t_gatepass_header.gp_date,t_gatepass_header.gp_return_date,t_gatepass_detail.gp_qty,"
			+ "t_gatepass_detail.gp_status,\n" + 
			" t_gatepass_detail.remark as reason,\n" + 
			" m_vendor.vendor_code,m_vendor.vendor_name,m_item.item_code,m_item.item_desc,m_item.item_uom "+
			" FROM t_gatepass_detail,t_gatepass_header,m_item,m_vendor " + 
			" WHERE t_gatepass_detail.gp_id=t_gatepass_header.gp_id AND "
			+ "t_gatepass_header.gp_vendor=m_vendor.vendor_id AND"
			+ " t_gatepass_detail.gp_item_id=m_item.item_id AND t_gatepass_detail.gp_item_id=:itemId "
			+ "AND t_gatepass_header.gp_date>=:fromDate", 
			nativeQuery = true)
	List<GetRetNonRetQueryItem> getRetNonRetQueryItem(@Param("fromDate") Date fromDate,@Param("itemId") int itemId);

}
