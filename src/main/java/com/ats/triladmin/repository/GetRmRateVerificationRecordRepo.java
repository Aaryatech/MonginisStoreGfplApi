package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.GetRmRateVerificationRecord;

public interface GetRmRateVerificationRecordRepo extends JpaRepository<GetRmRateVerificationRecord, Integer>{

	
	@Query(value=("select rvr.*,v.vendor_name,i.item_desc from rate_varification_record rvr,m_vendor v,m_item i where i.item_id=rvr.rm_id and v.vendor_id=rvr.supp_id"),nativeQuery=true)
	List<GetRmRateVerificationRecord> getRateVerificationRecordList();

	@Query(value=("select rvr.*,v.vendor_name,i.item_desc from rate_varification_record rvr,m_vendor v,m_item i where i.item_id=rvr.rm_id and v.vendor_id=rvr.supp_id and rvr.supp_id=:vendId and rvr.rm_id=:itemId and "
			+ "(rate_date>=:fromDate or rate_date<=:toDate)"),nativeQuery=true)
	List<GetRmRateVerificationRecord> getRateVerificationRecordListByVendIdAndItemId(@Param("fromDate")String fromDate,@Param("toDate") String toDate, @Param("vendId") int vendId,@Param("itemId") int itemId);

	@Query(value=("select rvr.*,v.vendor_name,i.item_desc from rate_varification_record rvr,m_vendor v,m_item i where i.item_id=rvr.rm_id and v.vendor_id=rvr.supp_id and rvr.supp_id=:vendId and "
			+ "(rate_date>=:fromDate or rate_date<=:toDate)"),nativeQuery=true)
	List<GetRmRateVerificationRecord> getRateVerificationRecordListByVendId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("vendId") int vendId);

	@Query(value=("select rvr.*,v.vendor_name,i.item_desc from rate_varification_record rvr,m_vendor v,m_item i where i.item_id=rvr.rm_id and v.vendor_id=rvr.supp_id and rvr.rm_id=:itemId and "
			+ "(rate_date>=:fromDate or rate_date<=:toDate)"),nativeQuery=true)
	List<GetRmRateVerificationRecord> getRateVerificationRecordListByItemId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("itemId") int itemId);

	@Query(value=("select rvr.*,v.vendor_name,i.item_desc from rate_varification_record rvr,m_vendor v,m_item i where i.item_id=rvr.rm_id and v.vendor_id=rvr.supp_id and (rate_date>=:fromDate or rate_date<=:toDate)"),nativeQuery=true)
	List<GetRmRateVerificationRecord> getRateVerificationRecordListByDate(@Param("fromDate")String fromDate,@Param("toDate")String toDate);

	@Query(value=("select rvr.rm_rate_ver_id as rvr_id ,rvr.rm_id,rvr.supp_id,rvr.rate_date,rvr.rate_tax_extra,rvr.rate_tax_incl,0 as extra1,0 as extra2,0 as varchar1,0 as varchar2,v.vendor_name,i.item_desc from m_rm_rate_verif rvr,m_vendor v,m_item i where i.item_id=rvr.rm_id and v.vendor_id=rvr.supp_id and i.cat_id=:catId and i.is_used=1 and v.is_used=1 order by v.vendor_name,rvr.rate_tax_extra"),nativeQuery=true)
	List<GetRmRateVerificationRecord> getItemRateListByCatId(@Param("catId") int catId);
 

}
