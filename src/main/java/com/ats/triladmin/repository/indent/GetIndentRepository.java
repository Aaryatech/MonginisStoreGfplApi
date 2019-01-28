package com.ats.triladmin.repository.indent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.indent.GetIndent;
import com.ats.triladmin.model.indent.GetIndents;
@Repository
public interface GetIndentRepository extends JpaRepository<GetIndents, Integer> {

		@Query(value="SELECT indent.ind_m_id,indent.Ind_m_no,indent.ind_m_date,indent.ind_isdev,a.acc_head_desc as account_head,indent.ind_ismonthly,indent.ind_m_type,indent.achd_id ,indent.dept_id,indent.sub_dept_id, m_category.cat_desc,indent.ind_m_status FROM indent,m_category,m_account_head a WHERE  a.acc_head_id=indent.achd_id and indent.cat_id=m_category.cat_id AND indent.ind_m_status IN  (:status) " ,nativeQuery=true) 
		List<GetIndents> getIndentList(@Param("status") List<Integer> status);

}
