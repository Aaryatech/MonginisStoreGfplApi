package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetGeneralGrnDetail;

public interface GetGeneralGrnDetailRepository extends JpaRepository<GetGeneralGrnDetail, Integer>{

	@Query(value = "select gh.*,i.item_code,i.item_desc,c.cat_desc from t_general_grn_detail gh,m_item i,m_category c where gh.grn_id=:grnId and "
			+ "i.item_id=gh.item_id and c.cat_id=gh.cat_id and gh.del_status=1", nativeQuery = true)
	List<GetGeneralGrnDetail> getGeneralDetail(@Param("grnId") int grnId);

}
