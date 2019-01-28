package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetPoDetailList;

public interface GetPoDetailListRepository extends JpaRepository<GetPoDetailList, Integer>{

	@Query(value = "select p.*,CONCAT(i.item_code, '-', i.item_desc) as item_code from po_detail p,m_item i where po_id=:poId and p.item_id=i.item_id ", nativeQuery = true)
	List<GetPoDetailList> getDetail(@Param("poId") int poId);

}
