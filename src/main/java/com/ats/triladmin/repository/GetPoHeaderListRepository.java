package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetPoHeaderList;

public interface GetPoHeaderListRepository extends JpaRepository<GetPoHeaderList, Integer> {

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderListBetweenDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "select p.*,v.vendor_name from po_header p,m_vendor v where po_id=:poId and del_status=1 and v.vendor_id =p.vend_id", nativeQuery = true)
	GetPoHeaderList getPoHeaderAndDetailByHeaderId(@Param("poId") int poId);

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id AND p.po_status IN(:poStatus)", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderByStatus(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("poStatus") List<Integer> poStatus);

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id AND p.po_status IN(:poStatus)  AND p.po_type IN(:poTypeList)", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderByStatusAndPoTypeList(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("poStatus") List<Integer> poStatus,
			@Param("poTypeList") List<Integer> poTypeList);

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id AND p.po_status IN(:poStatus)  AND p.po_type IN(:poTypeList)  AND p.vend_id IN(:vendorIdList)", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderByStatusAndPoTypeAndVendorList(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("poStatus") List<Integer> poStatus,
			@Param("poTypeList") List<Integer> poTypeList, @Param("vendorIdList") List<Integer> vendorIdList);

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id   AND p.po_type IN(:poTypeList)  AND p.vend_id IN(:vendorIdList)", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderByVendorAndPoType(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("poTypeList") List<Integer> poTypeList,
			@Param("vendorIdList") List<Integer> vendorIdList);

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id   AND  p.vend_id IN(:vendorIdList)", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderByVendor(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("vendorIdList") List<Integer> vendorIdList);

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id   AND p.po_type IN(:poTypeList) ", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderByVendorAndPoTypeList(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("poTypeList") List<Integer> poTypeList );

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where   p.del_status=1 and v.vendor_id =p.vend_id and p.po_status in (:status)", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderListForApprove(@Param("status") List<Integer> status);

	
	@Query(value = "select\r\n" + 
			"        p.*,\r\n" + 
			"        v.vendor_name \r\n" + 
			"    from\r\n" + 
			"        po_header p,\r\n" + 
			"        m_vendor v,\r\n" + 
			"        indent i\r\n" + 
			"    where\r\n" + 
			"        p.po_date between :fromDate and :toDate\r\n" + 
			"        and p.del_status=1 \r\n" + 
			"        and v.vendor_id =p.vend_id  and p.ind_id=i.ind_m_id\r\n" + 
			"        and i.cat_id=:catId and p.po_type=:typeId", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderListBetweenDateAndCatId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("catId") int catId,@Param("typeId") int typeId);

	
	@Query(value = "select\r\n" + 
			"        p.*,\r\n" + 
			"        v.vendor_name \r\n" + 
			"    from\r\n" + 
			"        po_header p,\r\n" + 
			"        m_vendor v,\r\n" + 
			"        indent i\r\n" + 
			"    where\r\n" + 
			"        p.po_date between :fromDate and :toDate\r\n" + 
			"        and p.del_status=1 \r\n" + 
			"        and v.vendor_id =p.vend_id  and p.ind_id=i.ind_m_id\r\n" + 
			"        and i.cat_id=:catId", nativeQuery = true)
	List<GetPoHeaderList> getPoHeaderListBetweenDateAndCatId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("catId") int catId);

	@Query(value = " select p.*,v.vendor_name from po_header p,m_vendor v where p.po_date between :fromDate and :toDate and del_status=1 and v.vendor_id =p.vend_id and p.po_type=:typeId", nativeQuery = true)
	 List<GetPoHeaderList> getPoHeaderListBetweenDateAndTypeId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate,@Param("typeId") int typeId);

}
