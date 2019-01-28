package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetQuatationDetail; 

public interface GetQuatationDetailRepository extends JpaRepository<GetQuatationDetail, Integer>{

	@Query(value=("select d.*,CONCAT(i.item_code, '-', i.item_desc) as item_code from t_quotation_detail d,m_item i "
			+ "where d.del_status=1 and d.enq_id=:enqId and i.item_id=d.item_id"),nativeQuery=true)
	List<GetQuatationDetail> getQuatationDetail(@Param("enqId")int enqId);
}
