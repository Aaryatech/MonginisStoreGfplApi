package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.IndentStatusReport;

public interface IndentStatusReportRepository extends JpaRepository<IndentStatusReport, Integer>{

	@Query(value = "select @a\\:=@a+1 sr,id.ind_d_id,i.ind_m_no,i.ind_m_date,id.item_id,concat(m.item_code,' ',m.item_desc) as item_code,"
			+ "id.ind_item_schddt, coalesce(concat('Pending Indent Qty - ',id.ind_fyr)) as remark ,DATEDIFF(:fromDate,id.ind_item_schddt) AS excess_days,id.ind_qty from indent i,"
			+ "indtrans id,m_item m , (SELECT  @a\\:=:index) AS a where id.ind_m_id=i.ind_m_id and m.item_id=id.item_id and "
			+ "i.del_status=1 and id.del_status=1 and id.ind_d_status in (0,1) and i.ind_m_date "
			+ "between :fromDate and :toDate", nativeQuery = true)
	List<IndentStatusReport> indentPendig(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("index") int index);

	@Query(value = "select  @a\\:=@a+1 sr,id.ind_d_id,i.ind_m_no,i.ind_m_date,id.item_id,concat(m.item_code,' ',m.item_desc) as item_code,"
			+ "id.ind_item_schddt, coalesce(concat(ph.po_no,' / PO Qty - ',pd.item_qty,' , Pending PO Qty - ', pd.pending_qty)) as remark,DATEDIFF(:fromDate,id.ind_item_schddt) AS excess_days,id.ind_qty from indent i,"
			+ "indtrans id,m_item m,po_detail pd,po_header ph , (SELECT  @a\\:=:index) AS a where id.ind_m_id=i.ind_m_id and "
			+ "m.item_id=id.item_id and i.del_status=1 and id.del_status=1 and id.ind_d_status in (1,2) and pd.ind_id=id.ind_d_id and"
			+ " pd.status in (0,1) and ph.po_id=pd.po_id and ph.del_status=1 and pd.item_id=id.item_id "
			+ "and i.ind_m_date between :fromDate and :toDate", nativeQuery = true)
	List<IndentStatusReport> pendingPo(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("index") int index);

	@Query(value = "select @a\\:=@a+1 sr,id.ind_d_id,i.ind_m_no,i.ind_m_date,id.item_id,concat(m.item_code,' ',m.item_desc) as item_code,"
			+ "id.ind_item_schddt, coalesce(concat(mh.mrn_no,'/App.Qty: ',md.approve_qty)) as remark,DATEDIFF(:fromDate,id.ind_item_schddt) AS excess_days,id.ind_qty from indent i,indtrans id,"
			+ "m_item m,po_detail pd,po_header ph, t_mrn_detail md, t_mrn_header mh, (SELECT  @a\\:=:index) AS a where id.ind_m_id=i.ind_m_id and m.item_id=id.item_id "
			+ "and i.del_status=1 and id.del_status=1  and pd.ind_id=id.ind_d_id and ph.po_id=pd.po_id and ph.del_status=1 and md.po_detail_id=pd.po_detail_id and md.del_status=1 "
			+ "and md.reject_qty>0 and mh.mrn_id=md.mrn_id and mh.del_status=1 and pd.status in (1,2) and id.ind_d_status in (1,2) and  pd.item_id=id.item_id and pd.item_id=md.item_id "
			+ "and i.ind_m_date between :fromDate and :toDate", nativeQuery = true)
	List<IndentStatusReport> rejectedMrn(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("index") int index);

	@Query(value = "select @a\\:=@a+1 sr,id.ind_d_id,i.ind_m_no,i.ind_m_date,id.item_id,concat(m.item_code,' ',m.item_desc) as item_code,"
			+ "id.ind_item_schddt, coalesce(concat('Pending Indent Qty - ',id.ind_fyr)) as remark ,DATEDIFF(:fromDate,id.ind_item_schddt) AS excess_days,id.ind_qty from indent i,"
			+ "indtrans id,m_item m , (SELECT  @a\\:=:index) AS a where id.ind_m_id=i.ind_m_id and m.item_id=id.item_id and "
			+ "i.del_status=1 and id.del_status=1 and id.ind_d_status in (0,1) and id.ind_item_schddt "
			+ "between :fromDate and :toDate", nativeQuery = true)
	List<IndentStatusReport> indentPendigBySchDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("index") int index);

	@Query(value = "select  @a\\:=@a+1 sr,id.ind_d_id,i.ind_m_no,i.ind_m_date,id.item_id,concat(m.item_code,' ',m.item_desc) as item_code,"
			+ "id.ind_item_schddt, coalesce(concat(ph.po_no,' / PO Qty - ',pd.item_qty,' , Pending PO Qty - ', pd.pending_qty)) as remark,DATEDIFF(:fromDate,id.ind_item_schddt) AS excess_days,id.ind_qty from indent i,"
			+ "indtrans id,m_item m,po_detail pd,po_header ph , (SELECT  @a\\:=:index) AS a where id.ind_m_id=i.ind_m_id and "
			+ "m.item_id=id.item_id and i.del_status=1 and id.del_status=1 and id.ind_d_status in (1,2) and pd.ind_id=id.ind_d_id and"
			+ " pd.status in (0,1) and ph.po_id=pd.po_id and ph.del_status=1 and pd.item_id=id.item_id "
			+ "and id.ind_item_schddt between :fromDate and :toDate", nativeQuery = true)
	List<IndentStatusReport> pendingPoBySchDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("index") int index);

}
