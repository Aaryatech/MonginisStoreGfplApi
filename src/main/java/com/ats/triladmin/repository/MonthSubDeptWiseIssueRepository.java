package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.MonthSubDeptWiseIssueReport;

public interface MonthSubDeptWiseIssueRepository extends JpaRepository<MonthSubDeptWiseIssueReport, Integer>{

	
	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,\r\n" + 
			"        month(:fromDate) as month_no,\r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_sub_dept.sub_dept_id,\r\n" + 
			"        concat(m_sub_dept.sub_dept_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_sub_dept.sub_dept_desc) as sub_dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate               \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate              \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id               \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate               \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id               \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value       \r\n" + 
			"    FROM\r\n" + 
			"        m_sub_dept,\r\n" + 
			"        (SELECT\r\n" + 
			"            @a\\:=:index) AS a       \r\n" + 
			"    where\r\n" + 
			"        m_sub_dept.is_used=1\r\n" + 
			"        and m_sub_dept.dept_id=:deptId\r\n" + 
			"    order by\r\n" + 
			"        m_sub_dept.sub_dept_id"),nativeQuery=true)
	List<MonthSubDeptWiseIssueReport> issueMonthWiseReportByDeptId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("index")int index,@Param("deptId") int deptId);

	
	@Query(value=("SELECT\r\n" + 
			"         @a\\:=@a+1 sr ,\r\n" + 
			"        month(:fromDate) as month_no,\r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_sub_dept.sub_dept_id,\r\n" + 
			"        concat(m_sub_dept.sub_dept_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_sub_dept.sub_dept_desc) as sub_dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                        \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                            \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId               \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                          \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                         \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                         \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                         \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                          \r\n" + 
			"    FROM\r\n" + 
			"       m_sub_dept,\r\n" + 
			"        (SELECT\r\n" + 
			"            @a\\:=:index) AS a       \r\n" + 
			"    where\r\n" + 
			"        m_sub_dept.is_used=1\r\n" + 
			"        and m_sub_dept.dept_id=:deptId\r\n" + 
			"    order by\r\n" + 
			"        m_sub_dept.sub_dept_id"),nativeQuery=true)
	List<MonthSubDeptWiseIssueReport> issueMonthWiseReportWithTypeIdAndIsDevByDeptId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId")int typeId,@Param("isDev") int isDev,@Param("index") int index,@Param("deptId") int deptId);


	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,\r\n" + 
			"        month(:fromDate) as month_no,\r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_sub_dept.sub_dept_id,\r\n" + 
			"        concat(m_sub_dept.sub_dept_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_sub_dept.sub_dept_desc) as sub_dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail                                 \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                        \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                            \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                                          \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                        \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                                         \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                         \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                          \r\n" + 
			"    FROM\r\n" + 
			"        m_sub_dept,\r\n" + 
			"        (SELECT\r\n" + 
			"            @a\\:=:index) AS a       \r\n" + 
			"    where\r\n" + 
			"        m_sub_dept.is_used=1\r\n" + 
			"        and m_sub_dept.dept_id=:deptId\r\n" + 
			"    order by\r\n" + 
			"        m_sub_dept.sub_dept_id"),nativeQuery=true)
	List<MonthSubDeptWiseIssueReport> issueMonthWiseReportWithTypeIdByDeptId(@Param("fromDate")String fromDate,@Param("toDate") String lastDate,
			@Param("typeId")int typeId,@Param("index") int index,@Param("deptId") int deptId);


	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,\r\n" + 
			"        month(:fromDate) as month_no,\r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_sub_dept.sub_dept_id,\r\n" + 
			"        concat(m_sub_dept.sub_dept_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_sub_dept.sub_dept_desc) as sub_dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                    \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                            \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                    \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                          \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                              \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                       \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                         \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                         \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id                            \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                          \r\n" + 
			"    FROM\r\n" + 
			"        m_sub_dept,\r\n" + 
			"        (SELECT\r\n" + 
			"            @a\\:=:index) AS a       \r\n" + 
			"    where\r\n" + 
			"        m_sub_dept.is_used=1\r\n" + 
			"        and m_sub_dept.dept_id=:deptId\r\n" + 
			"    order by\r\n" + 
			"        m_sub_dept.sub_dept_id"),nativeQuery=true)
	List<MonthSubDeptWiseIssueReport> issueMonthWiseWiseReportWithIsDevByDeptId(@Param("fromDate")String fromDate,@Param("toDate") String lastDate,
			@Param("isDev")int isDev,@Param("index") int index,@Param("deptId") int deptId);


	
	
	
	
	
	//itemwise record----------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,\r\n" + 
			"        month(:fromDate) as month_no,\r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_item.item_id as sub_dept_id,\r\n" + 
			"        concat(m_item.item_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_item.item_desc) as sub_dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate               \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate              \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id               \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)           \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail           \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate               \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id               \r\n" + 
			"            and item_issue_header.delete_status=1               \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id               \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value       \r\n" + 
			"    FROM\r\n" + 
			"        m_item,\r\n" + 
			"        (SELECT\r\n" + 
			"            @a\\:=:index) AS a       \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1 \r\n" + 
			"    order by\r\n" + 
			"        m_item.item_id"),nativeQuery=true)
	List<MonthSubDeptWiseIssueReport> issueMonthItemWiseReportBySubDeptId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("index") int index, @Param("subDeptId") int subDeptId);


	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,\r\n" + 
			"        month(:fromDate) as month_no,\r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_item.item_id as sub_dept_id,\r\n" + 
			"        concat(m_item.item_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_item.item_desc) as sub_dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate  \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                            \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId  and item_issue_detail.item_id=m_item.item_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId               \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                          \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate     \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId  and item_issue_detail.item_id=m_item.item_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId               \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                         \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate     \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                          \r\n" + 
			"    FROM\r\n" + 
			"         m_item,\r\n" + 
			"        (SELECT\r\n" + 
			"            @a\\:=:index) AS a       \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1 \r\n" + 
			"    order by\r\n" + 
			"        m_item.item_id"),nativeQuery=true)
	List<MonthSubDeptWiseIssueReport> issueMonthItemWiseReportWithTypeIdAndIsDevBySubDeptId(@Param("fromDate")String fromDate,@Param("toDate") String lastDate,
			@Param("typeId")int typeId,@Param("isDev") int isDev, @Param("index")int index,@Param("subDeptId") int subDeptId);


	@Query(value=("SELECT\r\n" + 
			"         @a\\:=@a+1 sr ,\r\n" + 
			"        month(:fromDate) as month_no,\r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_item.item_id as sub_dept_id,\r\n" + 
			"        concat(m_item.item_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_item.item_desc) as sub_dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail                                 \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                        \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                            \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                                          \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                      \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                                         \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                        \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id                            \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                          \r\n" + 
			"    FROM\r\n" + 
			"        m_item,\r\n" + 
			"        (SELECT\r\n" + 
			"            @a\\:=:index) AS a       \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1 \r\n" + 
			"    order by\r\n" + 
			"        m_item.item_id"),nativeQuery=true)
	List<MonthSubDeptWiseIssueReport> issueMonthItemWiseReportWithTypeIdBySubDeptId(@Param("fromDate")String fromDate,@Param("toDate") String lastDate,
			@Param("typeId")int typeId, @Param("index")int index,@Param("subDeptId") int subDeptId);


	@Query(value=("SELECT\r\n" + 
			"        @a\\:=@a+1 sr ,\r\n" + 
			"        month(:fromDate) as month_no,\r\n" + 
			"        monthname(:fromDate) as month_name,\r\n" + 
			"        m_item.item_id as sub_dept_id,\r\n" + 
			"        concat(m_item.item_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_item.item_desc) as sub_dept_code,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                    \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                        \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                            \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id                             \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                          \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                         \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id                            \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                                         \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                                         \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                                         \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                                             \r\n" + 
			"            and item_issue_header.delete_status=1                                                         \r\n" + 
			"            and item_issue_detail.del_status=1                                                         \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                                         \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id               \r\n" + 
			"            and item_issue_header.sub_dept_id=:subDeptId and item_issue_detail.item_id=m_item.item_id                           \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id                            \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id               \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id               \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_landing_value                          \r\n" + 
			"    FROM\r\n" + 
			"        m_item,\r\n" + 
			"        (SELECT\r\n" + 
			"            @a\\:=:index) AS a       \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1 \r\n" + 
			"    order by\r\n" + 
			"        m_item.item_id"),nativeQuery=true)
	List<MonthSubDeptWiseIssueReport> issueMonthItemWiseReportWithIsDevBySubDeptId(@Param("fromDate")String fromDate,@Param("toDate") String lastDate,
			@Param("isDev")int isDev,@Param("index") int index,@Param("subDeptId") int subDeptId);

}
