package com.ats.triladmin.repository.indent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.indent.DashIndentDetails;

@Repository
public interface IndentTransRepository extends JpaRepository<DashIndentDetails, Integer>{

	@Query(value="select indtrans.ind_d_id,indtrans.ind_m_id,indtrans.ind_m_no,indtrans.ind_m_date,indtrans.item_id,i.item_code,indtrans.ind_qty,indtrans.ind_item_uom,indtrans.ind_item_desc,indtrans.ind_item_curstk,indtrans.ind_item_schd,indtrans.ind_item_schddt,indtrans.ind_remark, indtrans.ind_d_status,indtrans.ind_fyr from indtrans,m_item i where indtrans.ind_m_id=:indMId and  indtrans.item_id=i.item_id and indtrans.ind_d_status In(:status)",nativeQuery=true)
	List<DashIndentDetails> findByIndMIdAndIndDStatusIn(@Param("indMId")int indMId,@Param("status") List<Integer> status);

}
