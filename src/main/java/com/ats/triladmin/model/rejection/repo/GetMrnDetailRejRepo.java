package com.ats.triladmin.model.rejection.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.mrn.GetMrnDetailRej;

public interface GetMrnDetailRejRepo extends JpaRepository<GetMrnDetailRej, Integer> {

	@Query(value = "SELECT\r\n" + 
			"        m.mrn_detail_id,\r\n" + 
			"        m.mrn_id,\r\n" + 
			"        m.item_id,\r\n" + 
			"        m.po_id,\r\n" + 
			"        m.po_no,\r\n" + 
			"        m.po_detail_id, \r\n" + 
			"        m.po_qty,\r\n" + 
			"        m.mrn_qty,\r\n" + 
			"        m.approve_qty,\r\n" + 
			"        m.reject_qty,\r\n" + 
			"        m.reject_remark,\r\n" + 
			"        m.mrn_detail_status,\r\n" + 
			"        m.batch_no,\r\n" + 
			"        m.issue_qty,\r\n" + 
			"        m.remaining_qty,\r\n" + 
			"        m.del_status, \r\n" + 
			"        i.item_desc as item_name ,\r\n" + 
			"        i.item_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(po_detail.item_rate) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header,\r\n" + 
			"            po_detail \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_id = :mrnId\r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND t_mrn_detail.item_id =:itemId\r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            AND t_mrn_detail.mrn_detail_status = 4),\r\n" + 
			"        0) AS chalan_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header,\r\n" + 
			"            po_detail \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_id = :mrnId\r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND t_mrn_detail.item_id =:itemId \r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            AND t_mrn_detail.mrn_detail_status = 4),\r\n" + 
			"        0) AS indent_qty\r\n" + 
			"    FROM\r\n" + 
			"        t_mrn_detail m,\r\n" + 
			"        m_item i \r\n" + 
			"    WHERE\r\n" + 
			"        m.item_id=i.item_id \r\n" + 
			"        AND m.mrn_id =:mrnId \r\n" + 
			"        AND m.del_status=1 \r\n" + 
			"        and m.remaining_qty>0 \r\n" + 
			"        and m.item_id=:itemId", nativeQuery = true)
	List<GetMrnDetailRej> getMrnDetailByList(@Param("mrnId") int mrnId,@Param("itemId") int itemId);
	 
	@Query(value = "SELECT m.*,i.item_desc as item_name ,i.item_code FROM t_mrn_detail m,m_item i WHERE  m.item_id=i.item_id AND m.mrn_id =:status  AND m.del_status=1 and m.reject_qty>0", nativeQuery = true)
	List<GetMrnDetailRej> getMrnDetailByList(@Param("status") int status);
}
