package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.PoDetail;

public interface PoDetailRepository extends JpaRepository<PoDetail, Integer>{
	
	
	/*@Transactional
	@Modifying
	@Query(" UPDATE PoDetail  SET pendingQty=:pendingQty,status=:status "
			+ " WHERE poDetailId=:poDetailId ")
	int updateResponse(@Param("pendingQty") int pendingQty,@Param("status") int status,@Param("poDetailId") int poDetailId);
	
	Not used. used bean save method PoDetail(poDetail);
	*/

	List<PoDetail> findAllByStatusNotAndPoId(int status,int poId);

	PoDetail findByPoDetailId(int poDId);
	
	PoDetail save(PoDetail poDetail);
	
	/*@Transactional
	@Query("SELECT COALESCE((1),0) as cnt FROM dual WHERE (SELECT COUNT(*) from po_detail WHERE po_detail.status=:status AND po_detail.po_id=:poId)="
			+ "(SELECT COUNT(*) from po_detail WHERE po_detail.po_id=:poId)") 
	int  getPodetailFromStatusAndPoId(@Param("poId") int poId,@Param("status") int status);
	*/
	
	
	List<PoDetail> findAllByStatusAndPoId(int status,int poId);
	
	List<PoDetail> findAllByPoId(int poId);
	
	
	@Modifying
	@Transactional
	@Query("delete from PoDetail where po_detail_id =:poDetailId") 
	void delete(@Param("poDetailId") int poDetailId);

	@Modifying
	@Transactional
	@Query(" UPDATE PoDetail  SET status=:status   WHERE po_detail_id in (:poDetalId)")
	int updateStatusWhileApprov(@Param("poDetalId") List<Integer> poDetalId,@Param("status") int status);

	List<PoDetail> findAllByPoIdAndStatusNotIn(int poId, List<Integer> status);

	List<PoDetail> findAllByStatusNotInAndPoId(List<Integer> stss, int poId);
}


