package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.ConsumptionReportData;

@Repository
public interface ConsumptionReportRepository extends JpaRepository<ConsumptionReportData, Integer>{

	@Query(value="SELECT\n" + 
			"        @a\\:=@a+1 sr ,\n" + 
			"        m_category.cat_id,\n" + 
			"        m_category.cat_desc, \n" + 
			"        coalesce((Select\n" + 
			"            SUM(po_detail.item_rate*t_mrn_detail.approve_qty)                     \n" + 
			"        FROM\n" + 
			"            t_mrn_detail,\n" + 
			"            t_mrn_header,\n" + 
			"            po_detail,\n" + 
			"            m_item                      \n" + 
			"        where\n" + 
			"            t_mrn_header.mrn_date between :fromDate and :toDate                            \n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id                             \n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id                             \n" + 
			"            and t_mrn_header.del_status=1                             \n" + 
			"            and t_mrn_detail.del_status=1                             \n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \n" + 
			"            and m_item.cat_id=m_category.cat_id and t_mrn_header.mrn_type=:poType AND t_mrn_detail.mrn_detail_status = 4),\n" + 
			"        0) AS monthly_value,\n" + 
			"        coalesce((Select\n" + 
			"            SUM(po_detail.item_rate*t_mrn_detail.approve_qty)                     \n" + 
			"        FROM\n" + 
			"            t_mrn_detail,\n" + 
			"            t_mrn_header,\n" + 
			"            po_detail,\n" + 
			"            m_item                      \n" + 
			"        where\n" + 
			"            t_mrn_header.mrn_date between :firstDate and :toDate                            \n" + 
			"            AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id                             \n" + 
			"            AND m_item.item_id=t_mrn_detail.item_id                             \n" + 
			"            and t_mrn_header.del_status=1                             \n" + 
			"            and t_mrn_detail.del_status=1                             \n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \n" + 
			"            and m_item.cat_id=m_category.cat_id and t_mrn_header.mrn_type=:poType AND t_mrn_detail.mrn_detail_status = 4),\n" + 
			"        0) AS ytd \n" + 
			"    FROM\n" + 
			"        m_category,(SELECT @a\\:=:index) AS a             \n" + 
			"    where\n" + 
			"        m_category.is_used=1",nativeQuery=true)
	List<ConsumptionReportData> findByPoTypeAndDate(@Param("poType")int poType,@Param("firstDate") String firstDate,@Param("fromDate") String fromDate
			,@Param("toDate") String toDate,@Param("index") int index);

	@Query(value="SELECT\n" + 
			"        @a\\:=@a+1 sr ,m_category.cat_id,\n" + 
			"        m_category.cat_desc, \n" + 
			"        coalesce((Select\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) \n" + 
			"        FROM\n" + 
			"            item_issue_header,\n" + 
			"            item_issue_detail,\n" + 
			"            t_mrn_detail,\n" + 
			"            po_detail,\n" + 
			"            m_item \n" + 
			"        WHERE\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate \n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \n" + 
			"            and item_issue_header.delete_status=1 \n" + 
			"            and item_issue_detail.del_status=1 \n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \n" + 
			"            and m_item.cat_id=m_category.cat_id \n" + 
			"            and item_issue_header.item_category=:poType AND item_issue_detail.status = 2),\n" + 
			"        0) AS monthly_value,\n" + 
			"        coalesce((Select\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) \n" + 
			"        FROM\n" + 
			"            item_issue_header,\n" + 
			"            item_issue_detail,\n" + 
			"            t_mrn_detail,\n" + 
			"            po_detail,\n" + 
			"            m_item \n" + 
			"        WHERE\n" + 
			"            item_issue_header.issue_date between :firstDate and :toDate \n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \n" + 
			"            AND m_item.item_id=item_issue_detail.item_id \n" + 
			"            and item_issue_header.delete_status=1 \n" + 
			"            and item_issue_detail.del_status=1 \n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \n" + 
			"            and m_item.cat_id=m_category.cat_id \n" + 
			"            and item_issue_header.item_category=:poType AND item_issue_detail.status = 2),\n" + 
			"        0) AS ytd \n" + 
			"    FROM\n" + 
			"        m_category,(SELECT @a\\:=:index) AS a \n" + 
			"    where\n" + 
			"        m_category.is_used=1 ",nativeQuery=true)
	List<ConsumptionReportData> findByPoTypeAndDateIssueDate(@Param("poType")int poType,@Param("firstDate") String firstDate,@Param("fromDate") String fromDate
			,@Param("toDate") String toDate,@Param("index") int index);

}
