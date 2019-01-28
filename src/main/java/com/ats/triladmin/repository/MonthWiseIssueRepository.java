package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.MonthWiseIssueReport;

public interface MonthWiseIssueRepository extends JpaRepository<MonthWiseIssueReport, Integer>{

	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,month(:fromDate) as month_no, \r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,\r\n" + 
			"        ' ', m_dept.dept_desc) as dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate\r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id \r\n" + 
			"            and item_issue_header.delete_status=1 \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value \r\n" + 
			"    FROM\r\n" + 
			"        m_dept,(SELECT @a\\:=:index) AS a \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1 \r\n" + 
			"    order by m_dept.dept_id"),nativeQuery=true)
	List<MonthWiseIssueReport> issueMonthWiseReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("index")int index);

	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,month(:fromDate) as month_no, \r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,\r\n" + 
			"        ' ', m_dept.dept_desc) as dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent          \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                          \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                              \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                               \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId\r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                    \r\n" + 
			"    FROM\r\n" + 
			"        m_dept,(SELECT @a\\:=:index) AS a \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1 \r\n" + 
			"    order by m_dept.dept_id"),nativeQuery=true)
	List<MonthWiseIssueReport> issueMonthWiseReportWithTypeIdAndIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId") int typeId,@Param("isDev") int isDev,@Param("index")int index);

	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,month(:fromDate) as month_no, \r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,\r\n" + 
			"        ' ', m_dept.dept_desc) as dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail                       \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                          \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                              \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                                \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                          \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                               \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                    \r\n" + 
			"    FROM\r\n" + 
			"        m_dept,(SELECT @a\\:=:index) AS a \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1 \r\n" + 
			"    order by m_dept.dept_id"),nativeQuery=true)
	List<MonthWiseIssueReport> issueMonthWiseReportWithTypeId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId") int typeId,@Param("index")int index);

	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,month(:fromDate) as month_no, \r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,\r\n" + 
			"        ' ', m_dept.dept_desc) as dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent          \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                          \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                              \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1 \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id               \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                               \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                               \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.dept_id=m_dept.dept_id              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                    \r\n" + 
			"    FROM\r\n" + 
			"        m_dept,(SELECT @a\\:=:index) AS a \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1 \r\n" + 
			"    order by m_dept.dept_id"),nativeQuery=true)
	List<MonthWiseIssueReport> issueMonthWiseWiseReportWithIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("isDev")int isDev,@Param("index")int index);

}
