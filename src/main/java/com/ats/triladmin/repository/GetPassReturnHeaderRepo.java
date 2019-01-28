package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetPassReturnHeader;

public interface GetPassReturnHeaderRepo extends JpaRepository<GetPassReturnHeader, Integer>{

	@Query(value = "select gr.*,v.vendor_name from t_getpass_return gr, m_vendor v where gr.return_id=:returnId and v.vendor_id = gr.vendor_id ", nativeQuery = true)
	GetPassReturnHeader findByReturnId(@Param("returnId") int returnId);

}
