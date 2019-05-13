package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.mrn.PoNos;
@Repository
public interface PoNosRepository extends JpaRepository<PoNos, Integer> {

	@Query(value="select mrn_detail_id,po_id,po_no from t_mrn_detail where mrn_id=:mrnId group by po_id",nativeQuery=true)
	List<PoNos> getPoDetails(@Param("mrnId")int mrnId);

}
