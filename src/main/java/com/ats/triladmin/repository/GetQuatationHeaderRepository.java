package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetEnquiryHeader;
import com.ats.triladmin.model.GetQuatationHeader;
 

public interface GetQuatationHeaderRepository extends JpaRepository<GetQuatationHeader, Integer>{
	
	
	@Query(value = ("select h.* from t_quotation_header h where h.del_status=1 and h.enq_id=:enqId"), nativeQuery = true)
	GetQuatationHeader getQuatationHeader(@Param("enqId") int enqId);

	
	@Query(value = ("select * from t_quotation_header where enq_date between :fromDate and :toDate "
			+ "and del_status=1"), nativeQuery = true)
	List<GetQuatationHeader> getQuatationHeaderListBetweenDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = ("select * from t_quotation_header where del_status=1"), nativeQuery = true)
	List<GetQuatationHeader> getQuotationListForEnquiry(); 

}
