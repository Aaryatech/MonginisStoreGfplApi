package com.ats.triladmin.repository.queryitems;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.getqueryitems.GetIndentQueryItem;

public interface GetIndentQueryItemRepo extends JpaRepository<GetIndentQueryItem, Integer>{
	
	@Query(value = " SELECT indtrans.ind_d_id,indtrans.ind_m_date,indtrans.ind_qty,indtrans.ind_d_status," + 
			" indent.ind_m_type,indent.ind_m_no,m_item.item_code,m_item.item_desc,m_item.item_uom,m_dept.dept_code,m_dept.dept_desc,m_sub_dept.sub_dept_code,"
			+ "m_sub_dept.sub_dept_desc,m_category.cat_desc " + 
			" FROM indtrans,indent,m_item,m_dept,m_sub_dept,m_category " + 
			" WHERE indent.ind_m_date >=:fromDate  " + 
			" AND indent.ind_m_id=indtrans.ind_m_id AND indtrans.item_id=m_item.item_id AND indtrans.item_id=:itemId AND  " + 
			" indent.dept_id=m_dept.dept_id AND indent.sub_dept_id=m_sub_dept.sub_dept_id AND  " + 
			" indent.cat_id=m_category.cat_id AND indtrans.del_status=1 AND indent.del_status=1 ", nativeQuery = true)
	List<GetIndentQueryItem> getIndentQueryItem(@Param("fromDate") Date fromDate,@Param("itemId") int itemId);
	
}
