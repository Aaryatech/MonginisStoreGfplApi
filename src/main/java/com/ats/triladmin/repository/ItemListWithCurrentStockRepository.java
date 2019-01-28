package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.ItemListWithCurrentStock;

public interface ItemListWithCurrentStockRepository extends JpaRepository<ItemListWithCurrentStock, Integer>{

	
	@Query(value = ("SELECT\r\n" + 
			"        m_item.item_id,\r\n" + 
			"        m_item.item_code,\r\n" + 
			"        m_item.item_desc ,\r\n" + 
			"        m_item.cat_id,\r\n" + 
			"        m_item.grp_id,\r\n" + 
			"        m_item.item_uom,\r\n" + 
			"        m_item.item_min_level as min_level,\r\n" + 
			"        m_item.item_max_level as max_level,\r\n" + 
			"        m_item.item_rod_level as rol_level,\r\n" + 
			"        m_item.item_op_qty as item_op_qty,m_item.item_is_cons as active,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_stock_detail.op_stock_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header           \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:fromDate               \r\n" + 
			"            AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id               \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) AS opening_stock,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_mrn_detail.approve_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header           \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate             \r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id               \r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id               \r\n" + 
			"            and t_mrn_header.del_status=1               \r\n" + 
			"            and t_mrn_detail.del_status=1               \r\n" + 
			"            AND t_mrn_detail.mrn_detail_status = 4),\r\n" + 
			"        0) AS approve_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate          \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_damage.qty)           \r\n" + 
			"        FROM\r\n" + 
			"            t_damage           \r\n" + 
			"        WHERE\r\n" + 
			"            t_damage.date between :fromDate and :toDate             \r\n" + 
			"            and t_damage.del_status=1               \r\n" + 
			"            AND m_item.item_id=t_damage.item_id),\r\n" + 
			"        0) AS damage_qty,\r\n" + 
			"        coalesce((select\r\n" + 
			"            sum(po_detail.pending_qty) \r\n" + 
			"        from\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header \r\n" + 
			"        where\r\n" + 
			"            po_detail.status in (0,1) \r\n" + 
			"            and                po_detail.item_id =m_item.item_id \r\n" + 
			"            and po_header.del_status=1 \r\n" + 
			"            and po_header.po_id=po_detail.po_id),\r\n" + 
			"        0) AS po_pending,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :firstDate and :toDate             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_avg ,coalesce(0) as  issue_return_qty     \r\n" + 
			"    FROM\r\n" + 
			"        m_item      \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1          \r\n" + 
			"        and m_item.cat_id=:catId"), nativeQuery = true)
	List<ItemListWithCurrentStock> getItemListByCatIdWithStock(@Param("firstDate")String firstDate,@Param("fromDate")String fromDate,
			@Param("toDate")String toDate, @Param("catId") int catId);

	
	@Query(value = ("SELECT\r\n" + 
			"        m_item.item_id,\r\n" + 
			"        m_item.item_code,\r\n" + 
			"        m_item.item_desc ,\r\n" + 
			"        m_item.cat_id,\r\n" + 
			"        m_item.grp_id,\r\n" + 
			"        m_item.item_uom,\r\n" + 
			"        m_item.item_min_level as min_level,\r\n" + 
			"        m_item.item_max_level as max_level,\r\n" + 
			"        m_item.item_rod_level as rol_level,m_item.item_op_qty as item_op_qty,m_item.item_is_cons as active,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_stock_detail.op_stock_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_stock_detail,\r\n" + 
			"            t_stock_header \r\n" + 
			"        where\r\n" + 
			"            t_stock_header.date=:fromDate \r\n" + 
			"            AND t_stock_header.stock_header_id=t_stock_detail.stock_header_id \r\n" + 
			"            AND m_item.item_id=t_stock_detail.item_id),\r\n" + 
			"        0) AS opening_stock, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_mrn_detail.approve_qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            t_mrn_header \r\n" + 
			"        where\r\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate \r\n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id \r\n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id \r\n" + 
			"            and t_mrn_header.del_status=1 \r\n" + 
			"            and t_mrn_detail.del_status=1 \r\n" + 
			"            AND t_mrn_detail.mrn_detail_status = 4),\r\n" + 
			"        0) AS approve_qty, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(t_damage.qty) \r\n" + 
			"        FROM\r\n" + 
			"            t_damage \r\n" + 
			"        WHERE\r\n" + 
			"            t_damage.date between :fromDate and :toDate \r\n" + 
			"            and t_damage.del_status=1 \r\n" + 
			"            AND m_item.item_id=t_damage.item_id),\r\n" + 
			"        0) AS damage_qty,\r\n" + 
			"        coalesce((select sum(po_detail.pending_qty) from po_detail,po_header where po_detail.status in (0,1) and \r\n" + 
			"             po_detail.item_id =m_item.item_id and po_header.del_status=1 and po_header.po_id=po_detail.po_id),0) AS po_pending,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :firstDate and :toDate              \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            AND m_item.item_id=item_issue_detail.item_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_avg,coalesce(0) AS issue_return_qty \r\n" + 
			"    FROM\r\n" + 
			"        m_item\r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1\r\n" + 
			"        and m_item.item_id=:itemId"), nativeQuery = true)
	ItemListWithCurrentStock getItemListByItemIdWithStock(@Param("firstDate")String firstDate,@Param("fromDate")String fromDate,
			@Param("toDate")String toDate,@Param("itemId") int itemId);

}
