package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.indent.GetIndentByStatus;

public interface GetIndentByStatusRepo extends JpaRepository<GetIndentByStatus, Integer>{

	@Query(value=("SELECT ind_m_id,ind_m_no,ind_m_date,ind_remark,ind_m_status FROM indent WHERE ind_m_status IN (:status) and del_status=1"
			+ " and ind_m_type =:poType"),nativeQuery=true)
	List<GetIndentByStatus> getIntendsByStatus(@Param("status") List<Integer> status,@Param("poType") int poType);

	@Query(value=("SELECT ind_m_id,ind_m_no,ind_m_date,ind_remark,ind_m_status FROM indent WHERE ind_m_status IN (:status) and del_status=1 "),nativeQuery=true)
	List<GetIndentByStatus> getIntendsByStatusWithoutPoType(@Param("status") List<Integer> status);

}
