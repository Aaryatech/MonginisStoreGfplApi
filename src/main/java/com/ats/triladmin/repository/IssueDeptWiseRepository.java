package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.IssueDeptWise; 

public interface IssueDeptWiseRepository extends JpaRepository<IssueDeptWise, Integer>{

	
	@Query(value=(" SELECT\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,' ',m_dept.dept_desc) as dept_code, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent\r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                            \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1 and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ "  and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail, \r\n" + 
			"            po_header,\r\n" + 
			"            indent                      \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                     \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 and "
			+ "  t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value              \r\n" + 
			"    FROM\r\n" + 
			"        m_dept             \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1 \r\n" + 
			"        and m_dept.dept_id=:deptId"),nativeQuery=true)
	List<IssueDeptWise> issueDeptWiseReportWithTypeIdAndIsDevAndDept(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId") int typeId,@Param("isDev") int isDev,@Param("deptId") int deptId);

	@Query(value=(" SELECT\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,' ',m_dept.dept_desc) as dept_code, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail             \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                            \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1 and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                      \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 "
			+ "  and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                     \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value              \r\n" + 
			"    FROM\r\n" + 
			"        m_dept             \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1 \r\n" + 
			"        and m_dept.dept_id=:deptId"),nativeQuery=true)
	List<IssueDeptWise> issueDeptWiseReportWithTypeIdAndDeptId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId")int typeId, @Param("deptId")int deptId);

	@Query(value=(" SELECT\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,' ',m_dept.dept_desc) as dept_code, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent\r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                            \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1 and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2  "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail, \r\n" + 
			"            po_header,\r\n" + 
			"            indent                      \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                     \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value              \r\n" + 
			"    FROM\r\n" + 
			"        m_dept             \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1  "),nativeQuery=true)
	List<IssueDeptWise> issueDeptWiseReportWithTypeIdAndIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId")int typeId,@Param("isDev") int isDev);

	@Query(value=("SELECT m_dept.dept_id, concat(m_dept.dept_code,' ',m_dept.dept_desc) as dept_code, coalesce((Select SUM(item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail             \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                            \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1 and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                      \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail                     \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value              \r\n" + 
			"    FROM\r\n" + 
			"        m_dept             \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1"),nativeQuery=true)
	List<IssueDeptWise> issueDeptWiseReportWithTypeId(@Param("fromDate")String fromDate,@Param("toDate") String toDate, @Param("typeId") int typeId);

	@Query(value=(" SELECT\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,' ',m_dept.dept_desc) as dept_code, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent\r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                            \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1 and item_issue_header.dept_id=m_dept.dept_id \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail, \r\n" + 
			"            po_header,\r\n" + 
			"            indent                      \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                     \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value              \r\n" + 
			"    FROM\r\n" + 
			"        m_dept             \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1  "),nativeQuery=true)
	List<IssueDeptWise> issueDeptWiseReportWithIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("isDev") int isDev);

	@Query(value=(" SELECT\r\n" + 
			"        m_dept.dept_id,\r\n" + 
			"        concat(m_dept.dept_code,' ',m_dept.dept_desc) as dept_code, \r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent\r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                            \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1 and item_issue_header.dept_id=m_dept.dept_id \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail, \r\n" + 
			"            po_header,\r\n" + 
			"            indent                      \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                     \r\n" + 
			"        FROM\r\n" + 
			"            item_issue_header,\r\n" + 
			"            item_issue_detail,\r\n" + 
			"            t_mrn_detail,\r\n" + 
			"            po_detail,\r\n" + 
			"            po_header,\r\n" + 
			"            indent                     \r\n" + 
			"        WHERE\r\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                             \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                 \r\n" + 
			"            and item_issue_header.delete_status=1                             \r\n" + 
			"            and item_issue_detail.del_status=1                             \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                             \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id\r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id\r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id and po_header.ind_id=indent.ind_m_id and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value              \r\n" + 
			"    FROM\r\n" + 
			"        m_dept             \r\n" + 
			"    where\r\n" + 
			"        m_dept.is_used=1  \r\n" + 
			"        and m_dept.dept_id=:deptId"),nativeQuery=true)
	List<IssueDeptWise> issueDeptWiseReportWithIsDevAndDeptId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("isDev")int isDev, @Param("deptId") int deptId);
	//done upto above
	
	@Query(value=("SELECT m_dept.dept_id, concat(m_dept.dept_code,' ',m_dept.dept_desc) as dept_code, coalesce((Select "
			+ "SUM(item_issue_detail.item_issue_qty) FROM item_issue_header, item_issue_detail WHERE item_issue_header.issue_date"
			+ " between :fromDate and :toDate AND item_issue_header.issue_id=item_issue_detail.issue_id and item_issue_header.delete_status=1 "
			+ "and item_issue_detail.del_status=1 and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2), 0) AS issue_qty, coalesce((Select "
			+ "SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) FROM item_issue_header, item_issue_detail, t_mrn_detail, po_detail "
			+ "WHERE item_issue_header.issue_date between :fromDate and :toDate and t_mrn_detail.is_header_item=1 AND item_issue_header.issue_id=item_issue_detail.issue_id "
			+ "and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2), 0) AS issue_qty_value, "
			+ "coalesce((Select SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) FROM item_issue_header, "
			+ "item_issue_detail, t_mrn_detail, po_detail WHERE  t_mrn_detail.is_header_item=1 and  item_issue_header.issue_date between :fromDate and :toDate "
			+ "AND item_issue_header.issue_id=item_issue_detail.issue_id and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2), 0) AS issue_landing_value "
			+ "FROM m_dept where m_dept.is_used=1 "),nativeQuery=true)
	List<IssueDeptWise> issueDeptWiseReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate);
//done
	@Query(value=("SELECT m_dept.dept_id, concat(m_dept.dept_code,' ',m_dept.dept_desc) as dept_code, coalesce((Select "
			+ "SUM(item_issue_detail.item_issue_qty) FROM item_issue_header, item_issue_detail WHERE item_issue_header.issue_date"
			+ " between :fromDate and :toDate AND item_issue_header.issue_id=item_issue_detail.issue_id and item_issue_header.delete_status=1 "
			+ "and item_issue_detail.del_status=1 and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2), 0) AS issue_qty, coalesce((Select "
			+ "SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) FROM item_issue_header, item_issue_detail, t_mrn_detail, po_detail "
			+ "WHERE  t_mrn_detail.is_header_item=1 and item_issue_header.issue_date between :fromDate and :toDate AND item_issue_header.issue_id=item_issue_detail.issue_id "
			+ "and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2), 0) AS issue_qty_value, "
			+ "coalesce((Select SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) FROM item_issue_header, "
			+ "item_issue_detail, t_mrn_detail, po_detail WHERE  t_mrn_detail.is_header_item=1 and item_issue_header.issue_date between :fromDate and :toDate "
			+ "AND item_issue_header.issue_id=item_issue_detail.issue_id and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id "
			+ "and po_detail.po_detail_id=t_mrn_detail.po_detail_id and item_issue_header.dept_id=m_dept.dept_id AND item_issue_detail.status = 2), 0) AS issue_landing_value "
			+ "FROM m_dept where m_dept.is_used=1 and m_dept.dept_id=:deptId"),nativeQuery=true)
	List<IssueDeptWise> issueDeptWiseReportWithDeptId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("deptId") int deptId);
//Done
	
	//Sub Departmentwise-------------------------------------------------------------------------------------------
	
	
	
	@Query(value=("SELECT\r\n" + 
			"        m_sub_dept.sub_dept_id as dept_id,\r\n" + 
			"        concat(m_sub_dept.sub_dept_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_sub_dept.sub_dept_desc) as dept_code,\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) \r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) \r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value \r\n" + 
			"    FROM\r\n" + 
			"        m_sub_dept \r\n" + 
			"    where\r\n" + 
			"        m_sub_dept.is_used=1\r\n" + 
			"        and m_sub_dept.dept_id=:deptId"),nativeQuery=true)
	List<IssueDeptWise> issueSubDeptWiseReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("deptId") int deptId);

	@Query(value=("SELECT\r\n" + 
			"         m_sub_dept.sub_dept_id as dept_id,\r\n" + 
			"        concat(m_sub_dept.sub_dept_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_sub_dept.sub_dept_desc) as dept_code,\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id               \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value                    \r\n" + 
			"    FROM\r\n" + 
			"        m_sub_dept \r\n" + 
			"    where\r\n" + 
			"        m_sub_dept.is_used=1\r\n" + 
			"        and m_sub_dept.dept_id=:deptId"),nativeQuery=true)
	List<IssueDeptWise> issueSubDeptWiseReportWithIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("isDev")int isDev,@Param("deptId") int deptId);

	@Query(value=("SELECT\r\n" + 
			"        m_sub_dept.sub_dept_id as dept_id,\r\n" + 
			"        concat(m_sub_dept.sub_dept_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_sub_dept.sub_dept_desc) as dept_code,\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              \r\n" + 
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
			"            item_issue_header.issue_date between :fromDate and :toDate                                           \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value   \r\n" + 
			"    FROM\r\n" + 
			"        m_sub_dept \r\n" + 
			"    where\r\n" + 
			"        m_sub_dept.is_used=1\r\n" + 
			"        and m_sub_dept.dept_id=:deptId"),nativeQuery=true)
	List<IssueDeptWise> issueSubDeptWiseReportWithTypeId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId")int typeId, @Param("deptId") int deptId);

	@Query(value=("SELECT\r\n" + 
			"       m_sub_dept.sub_dept_id as dept_id,\r\n" + 
			"        concat(m_sub_dept.sub_dept_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_sub_dept.sub_dept_desc) as dept_code,\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              \r\n" + 
			"            and item_issue_header.item_category=:typeId\r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id             \r\n" + 
			"            and item_issue_header.item_category=:typeId \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value  \r\n" + 
			"    FROM\r\n" + 
			"        m_sub_dept \r\n" + 
			"    where\r\n" + 
			"        m_sub_dept.is_used=1\r\n" + 
			"        and m_sub_dept.dept_id=:deptId"),nativeQuery=true)
	List<IssueDeptWise> issueSubDeptWiseReportWithTypeIdAndIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId")int typeId, @Param("isDev")int isDev, @Param("deptId") int deptId);

	
	//itemWise Report Sub Dept----------------------------------------------------------------------------------------------------------------
	
	
	
	@Query(value=("SELECT\r\n" + 
			"        m_item.item_id as dept_id,\r\n" + 
			"        concat(m_item.item_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_item.item_desc) as dept_code,\r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept AND item_issue_detail.status = 2),\r\n" + 
			"        0) AS issue_qty,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) \r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept AND item_issue_detail.status = 2"
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_qty_value,\r\n" + 
			"        coalesce((Select\r\n" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) \r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value \r\n" + 
			"    FROM\r\n" + 
			"        m_item \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1 "),nativeQuery=true)
	List<IssueDeptWise> issueItemWiseReportBySubDept(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("subDept") int subDept);

	
	@Query(value=("SELECT\r\n" + 
			"        m_item.item_id as dept_id,\r\n" + 
			"        concat(m_item.item_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_item.item_desc) as dept_code,\r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept              \r\n" + 
			"            and item_issue_header.item_category=:typeId\r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept              \r\n" + 
			"            and item_issue_header.item_category=:typeId\r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            item_issue_header.issue_date between :fromDate and :toDate               \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept              \r\n" + 
			"            and item_issue_header.item_category=:typeId \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value                    \r\n" + 
			"    FROM\r\n" + 
			"        m_item \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1 "),nativeQuery=true)
	List<IssueDeptWise> issueItemWiseReportWithTypeIdAndIsDevBySubDept(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId")int typeId, @Param("isDev") int isDev, @Param("subDept") int subDept);

	@Query(value=("SELECT\r\n" + 
			"        m_item.item_id as dept_id,\r\n" + 
			"        concat(m_item.item_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_item.item_desc) as dept_code,\r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept               \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept              \r\n" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              \r\n" + 
			"            and t_mrn_detail.po_id=po_header.po_id \r\n" + 
			"            and po_header.ind_id=indent.ind_m_id \r\n" + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value                    \r\n" + 
			"    FROM\r\n" + 
			"        m_item \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1 "),nativeQuery=true)
	List<IssueDeptWise> issueItemWiseWiseReportWithIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("isDev") int isDev, @Param("subDept") int subDept);

	@Query(value=("SELECT\r\n" + 
			"        m_item.item_id as dept_id,\r\n" + 
			"        concat(m_item.item_code,\r\n" + 
			"        ' ',\r\n" + 
			"        m_item.item_desc) as dept_code,\r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept              \r\n" + 
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
			"            item_issue_header.issue_date between :fromDate and :toDate                                           \r\n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               \r\n" + 
			"            and item_issue_header.delete_status=1                                           \r\n" + 
			"            and item_issue_detail.del_status=1                                           \r\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           \r\n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \r\n" + 
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept             \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
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
			"            and item_issue_detail.item_id=m_item.item_id and item_issue_detail.sub_dept_id=:subDept              \r\n" + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 "
			+ " and t_mrn_detail.is_header_item=1),\r\n" + 
			"        0) AS issue_landing_value                    \r\n" + 
			"    FROM\r\n" + 
			"       m_item \r\n" + 
			"    where\r\n" + 
			"        m_item.is_used=1"),nativeQuery=true)
	List<IssueDeptWise> issueItemWiseReportWithTypeId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId") int typeId,@Param("subDept") int subDept);
	 
	//Done all For and t_mrn_detail.is_header_item=1
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
