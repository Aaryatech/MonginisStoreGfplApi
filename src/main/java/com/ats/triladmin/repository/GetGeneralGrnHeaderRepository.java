package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetGeneralGrnHeader;

public interface GetGeneralGrnHeaderRepository extends JpaRepository<GetGeneralGrnHeader, Integer>{

	@Query(value = "select gh.*,v.vendor_name,c.cat_desc from t_general_grn_header gh,m_vendor v,m_category c where gh.grn_date between :fromDate and :toDate"
			+ "v.vendor_id = gh.vendor_id and gh.cat_id=c.cat_id and del_status=1", nativeQuery = true)
	List<GetGeneralGrnHeader> getGeneralGrnHeaderListBetweenDate(@Param("fromDate")String fromDate, @Param("toDate")String toDate);

	@Query(value = " select gh.*,v.vendor_name,c.cat_desc from t_general_grn_header gh,m_vendor v,m_category "
			+ "c where gh.grn_id=:grnId and v.vendor_id = gh.vendor_id and gh.cat_id=c.cat_id and del_status=1", nativeQuery = true)
	GetGeneralGrnHeader getGeneralGrnHeader(@Param("grnId") int grnId);

}

 