package com.ats.triladmin.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.mrn.GetMrnHeaderWithAmt;
 

public interface GetMrnHeaderWithAmtRepository extends JpaRepository<GetMrnHeaderWithAmt, Integer>{

	@Query(value = "SELECT\n" + 
			"        h.mrn_id,\n" + 
			"        h.mrn_no,\n" + 
			"        h.mrn_type,\n" + 
			"        h.mrn_date,\n" + 
			"        h.vendor_id,\n" + 
			"        v.vendor_name,\n" + 
			"        h.gate_entry_no,\n" + 
			"        h.gate_entry_date,\n" + 
			"        h.doc_no,\n" + 
			"        h.doc_date,\n" + 
			"        h.bill_no,\n" + 
			"        h.bill_date,\n" + 
			"        h.transport,\n" + 
			"        h.lr_no,\n" + 
			"        h.lr_date,\n" + 
			"        h.remark1,\n" + 
			"        h.remark2,\n" + 
			"        h.user_id,\n" + 
			"        h.mrn_status,\n" + 
			"        h.del_status,\n" + 
			"        sum(pd.landing_cost) as total\n" + 
			"    FROM\n" + 
			"        t_mrn_header h,\n" + 
			"        m_vendor v,\n" + 
			"        po_detail pd,\n" + 
			"        t_mrn_detail md,\n" + 
			"        po_header ph\n" + 
			"    WHERE\n" + 
			"        v.vendor_id=h.vendor_id  \n" + 
			"        AND h.del_status=1  \n" + 
			"        AND h.mrn_date BETWEEN :fromDate AND :toDate and pd.po_detail_id=md.po_detail_id and md.mrn_id=h.mrn_id and ph.po_id=pd.po_id\n" + 
			"        group by mrn_id,pd.po_id", nativeQuery = true)
	List<GetMrnHeaderWithAmt> getMrnHeaderByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	@Query(value = "SELECT\n" + 
			"        h.mrn_id,\n" + 
			"        h.mrn_no,\n" + 
			"        h.mrn_type,\n" + 
			"        h.mrn_date,\n" + 
			"        h.vendor_id,\n" + 
			"        v.vendor_name,\n" + 
			"        h.gate_entry_no,\n" + 
			"        h.gate_entry_date,\n" + 
			"        h.doc_no,\n" + 
			"        h.doc_date,\n" + 
			"        h.bill_no,\n" + 
			"        h.bill_date,\n" + 
			"        h.transport,\n" + 
			"        h.lr_no,\n" + 
			"        h.lr_date,\n" + 
			"        h.remark1,\n" + 
			"        h.remark2,\n" + 
			"        h.user_id,\n" + 
			"        h.mrn_status,\n" + 
			"        h.del_status,\n" + 
			"        sum(pd.landing_cost) as total\n" + 
			"    FROM\n" + 
			"        t_mrn_header h,\n" + 
			"        m_vendor v,\n" + 
			"        po_detail pd,\n" + 
			"        t_mrn_detail md,\n" + 
			"        po_header ph\n" + 
			"    WHERE\n" + 
			"        v.vendor_id=h.vendor_id  \n" + 
			"        AND h.del_status=1 and  h.mrn_type=:grnType\n" + 
			"        AND h.mrn_date BETWEEN :fromDate AND :toDate and pd.po_detail_id=md.po_detail_id and md.mrn_id=h.mrn_id and ph.po_id=pd.po_id\n" + 
			"        group by mrn_id,pd.po_id", nativeQuery = true)
	List<GetMrnHeaderWithAmt> getMrnHeaderByDate(@Param("grnType")int grnType,@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	
	@Query(value = "SELECT\n" + 
			"    h.mrn_id,\n" + 
			"    h.mrn_no,\n" + 
			"    h.mrn_type,\n" + 
			"    h.mrn_date,\n" + 
			"    h.vendor_id,\n" + 
			"    v.vendor_name,\n" + 
			"    h.gate_entry_no,\n" + 
			"    h.gate_entry_date,\n" + 
			"    h.doc_no,\n" + 
			"    h.doc_date,\n" + 
			"    h.bill_no,\n" + 
			"    h.bill_date,\n" + 
			"    h.transport,\n" + 
			"    h.lr_no,\n" + 
			"    h.lr_date,\n" + 
			"    h.remark1,\n" + 
			"    h.remark2,\n" + 
			"    h.user_id,\n" + 
			"    h.mrn_status,\n" + 
			"    h.del_status,\n" + 
			"    SUM(pd.landing_cost) AS total\n" + 
			"FROM\n" + 
			"    t_mrn_header h,\n" + 
			"    m_vendor v,\n" + 
			"    po_detail pd,\n" + 
			"    t_mrn_detail md,\n" + 
			"    po_header ph\n" + 
			"WHERE\n" + 
			"    v.vendor_id = h.vendor_id AND h.del_status = 1 AND h.mrn_status = 4 AND pd.po_detail_id = md.po_detail_id AND md.mrn_id = h.mrn_id AND ph.po_id = pd.po_id AND h.vendor_id = :vendorId AND h.mrn_id NOT IN(\n" + 
			"    SELECT\n" + 
			"        mrn_id\n" + 
			"    FROM\n" + 
			"        t_bill_book_header\n" + 
			"    WHERE\n" + 
			"        vend_id = :vendorId AND del_status = 1\n" + 
			")\n" + 
			"GROUP BY\n" + 
			"    mrn_id,\n" + 
			"    pd.po_id", nativeQuery = true)
	List<GetMrnHeaderWithAmt> getMrnHeaderByVendor(@Param("vendorId") int vendorId);
	
}
