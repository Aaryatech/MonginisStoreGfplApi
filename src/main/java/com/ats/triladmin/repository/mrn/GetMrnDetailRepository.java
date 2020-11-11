package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.mrn.GetMrnDetail;
import com.ats.triladmin.model.mrn.GetMrnHeader;

@Repository
public interface GetMrnDetailRepository extends JpaRepository<GetMrnDetail, Integer> {

	/*
	 * @Query(value =
	 * "select podetail.po_detail_id, podetail.pending_qty as po_pending_qty,d.mrn_qty as mrn_qty_before_edit,"
	 * +
	 * " d.mrn_detail_id,d.mrn_id,d.item_id,i.item_desc as item_name,i.item_is_critical, i.item_schd, i.item_code,i.item_uom,d.po_id,d.po_no,d.indent_qty,d.po_qty,"
	 * +
	 * "d.mrn_qty,d.approve_qty,d.reject_qty,d.reject_remark,d.mrn_detail_status,d.batch_no,d.issue_qty,"
	 * +
	 * "d.remaining_qty,d.del_status,d.chalan_qty  from t_mrn_detail d,m_item i,po_detail podetail where d.mrn_id=:mrnId and d.del_status=1 and i.item_id=d.item_id and d.mrn_detail_status=:mrnDetailStatus and podetail.po_detail_id=d.po_detail_id "
	 * , nativeQuery = true)
	 */
	@Query(value = "select podetail.po_detail_id, podetail.pending_qty as po_pending_qty,d.mrn_qty as mrn_qty_before_edit,"
			+ " d.mrn_detail_id,d.mrn_id,d.item_id,i.item_desc as item_name,i.item_is_critical, i.item_schd,i.item_code,i.item_uom,d.po_id,d.po_no,d.indent_qty,d.po_qty,"
			+ "d.mrn_qty,d.approve_qty,d.reject_qty,d.reject_remark,d.mrn_detail_status,d.batch_no,d.issue_qty,"
			+ "d.remaining_qty,d.del_status,d.chalan_qty  from t_mrn_detail d,m_item i,po_detail podetail where d.mrn_id=:mrnId and d.del_status=1 and i.item_id=d.item_id and d.mrn_detail_status IN (:mrnDetailStatus) and podetail.po_detail_id=d.po_detail_id ", nativeQuery = true)
	
	List<GetMrnDetail> getMrnDetailList(@Param("mrnId") int mrnId, @Param("mrnDetailStatus") List<String> mrnDetailStatus);

	//Sachin 03-09-2020
	//to get items for Store MRN Inspection add/edit
	@Query(value = " select podetail.po_detail_id, podetail.pending_qty as po_pending_qty,d.mrn_qty as mrn_qty_before_edit,"
			+ " d.mrn_detail_id,d.mrn_id,d.item_id,i.item_desc as item_name,i.item_is_critical, i.item_schd, i.item_code,i.item_uom,d.po_id,d.po_no,d.indent_qty,d.po_qty,"
			+ " d.mrn_qty,d.approve_qty,d.reject_qty,d.reject_remark,d.mrn_detail_status,d.batch_no,d.issue_qty,"
			+ " d.remaining_qty,d.del_status,d.chalan_qty  from t_mrn_detail d,m_item i,po_detail podetail where d.mrn_id=:mrnId and d.del_status=1 and i.item_id=d.item_id and podetail.po_detail_id=d.po_detail_id "
			+ " and d.is_header_item=1 ", nativeQuery = true)
	List<GetMrnDetail> getMrnDetailList(@Param("mrnId") int mrnId);

	
	
	
	@Query(value = "select podetail.po_detail_id,podetail.pending_qty as po_pending_qty,d.mrn_qty as mrn_qty_before_edit, d.mrn_detail_id,"
			+ "d.mrn_id,d.item_id,i.item_desc as item_name, i.item_is_critical, i.item_schd, i.item_code,i.item_uom,d.po_id,d.po_no,d.indent_qty,d.po_qty,d.mrn_qty,d.approve_qty,"
			+ "d.reject_qty,d.reject_remark,d.mrn_detail_status,d.batch_no,d.issue_qty,d.remaining_qty,d.del_status,d.chalan_qty  "
			+ "from t_mrn_detail d,m_item i,po_detail podetail where d.mrn_id=:mrnId and d.del_status=1 and i.item_id=d.item_id and podetail.po_detail_id=d.po_detail_id "
			+ "and d.is_header_item=1", nativeQuery = true)
	List<GetMrnDetail> getMrnDetailByMrnId(@Param("mrnId") int mrnId); //Sachin 02-09-2020 get only header items for edit pur order ie mrn punch report-Sumit Sir.

	@Query(value = "SELECT podetail.po_detail_id,podetail.pending_qty as po_pending_qty,m.mrn_qty as mrn_qty_before_edit, "
			+ "m.*,i.item_desc as item_name,i.item_is_critical, i.item_schd, i.item_code,i.item_uom,m.chalan_qty FROM t_mrn_detail m,m_item i ,po_detail podetail WHERE  m.item_id=i.item_id AND m.mrn_id IN(:status) "
			+ "AND m.del_status=1 and podetail.po_detail_id=m.po_detail_id ", nativeQuery = true)
	List<GetMrnDetail> getMrnDetailByList(@Param("status") List<Integer> status);

	@Query(value = "select podetail.po_detail_id, podetail.pending_qty as po_pending_qty,d.mrn_qty as mrn_qty_before_edit,"
			+ " d.mrn_detail_id,d.mrn_id,d.item_id,i.item_desc as item_name,i.item_is_critical, i.item_schd,i.item_code,i.item_uom,d.po_id,d.po_no,d.indent_qty,d.po_qty,"
			+ "d.mrn_qty,d.approve_qty,d.reject_qty,d.reject_remark,d.mrn_detail_status,d.batch_no,d.issue_qty,"
			+ "d.remaining_qty,d.del_status,d.chalan_qty  from t_mrn_detail d,m_item i,po_detail podetail where d.mrn_id=:mrnId and "
			+ "d.del_status=1 and i.item_id=d.item_id   and podetail.po_detail_id=d.po_detail_id "
			+ "and d.is_header_item=1 ", nativeQuery = true)
	List<GetMrnDetail> getMrnDetailListForApprove(@Param("mrnId") int mrnId);//Sachin 02-09-2020 get only header items ie and d.is_header_item=1
}
