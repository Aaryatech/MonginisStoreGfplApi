package com.ats.triladmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.triladmin.model.ItemQtyWithRecieptNo;

public interface ItemQtyWithRecieptNoRepository extends JpaRepository<ItemQtyWithRecieptNo, Integer>{

	
	@Query(value="Select @a\\:=@a+1 sr,t_mrn_detail.mrn_detail_id as id,t_mrn_header.bill_date as date,t_mrn_header.mrn_no as recept_no,"
			+ "t_mrn_detail.approve_qty as qty FROM t_mrn_detail, t_mrn_header,(SELECT @a\\:=:index) AS a where t_mrn_header.mrn_date =:date "
			+ "AND t_mrn_header.mrn_id=t_mrn_detail.mrn_id AND t_mrn_detail.item_id=:itemId and t_mrn_header.del_status=1 "
			+ "and t_mrn_detail.del_status=1 and t_mrn_detail.mrn_detail_status=4",nativeQuery=true)
	List<ItemQtyWithRecieptNo> getMrnDataByDate(@Param("date") String date,@Param("itemId") int itemId,@Param("index") int index);

	@Query(value="Select @a\\:=@a+1 sr,item_issue_detail.issue_detail_id as id, item_issue_header.issue_date as date, "
			+ "item_issue_header.issue_no as recept_no, item_issue_detail.item_issue_qty as qty FROM item_issue_detail, item_issue_header,(SELECT @a\\:=:index) AS a  "
			+ "where item_issue_header.issue_date =:date AND item_issue_header.issue_id=item_issue_detail.issue_id "
			+ "AND item_issue_detail.item_id=:itemId and item_issue_header.delete_status=1 and item_issue_detail.del_status=1 AND item_issue_detail.status = 2",nativeQuery=true)
	List<ItemQtyWithRecieptNo> getIssueDataByDate(@Param("date") String date,@Param("itemId") int itemId,@Param("index") int index);

	@Query(value="Select t_gatepass_detail.gp_detail_id as id, t_gatepass_header.gp_date as date, t_gatepass_header.gp_no as recept_no, "
			+ "t_gatepass_detail.gp_qty as qty FROM t_gatepass_detail, t_gatepass_header where t_gatepass_header.gp_date =:date "
			+ "AND t_gatepass_header.gp_id=t_gatepass_detail.gp_id AND t_gatepass_detail.gp_item_id=:itemId and t_gatepass_header.is_used=1 "
			+ "and t_gatepass_detail.is_used=1 ",nativeQuery=true)
	List<ItemQtyWithRecieptNo> getGatePassDataByDate(@Param("date") String date,@Param("itemId") int itemId);

	@Query(value="Select t_getpass_return_detail.return_detail_id as id, t_getpass_return.gp_return_date as date, "
			+ "t_getpass_return.return_no as recept_no, t_getpass_return_detail.return_qty as qty FROM  t_getpass_return_detail, "
			+ "t_getpass_return where t_getpass_return.gp_return_date =:date AND "
			+ "t_getpass_return.return_id=t_getpass_return_detail.return_id AND t_getpass_return_detail.gp_item_id=:itemId "
			+ "and t_getpass_return.is_used=1 and t_getpass_return_detail.is_used=1 ",nativeQuery=true)
	List<ItemQtyWithRecieptNo> getReturnGatePassDataByDate(@Param("date") String date,@Param("itemId") int itemId);
	
	@Query(value="Select\r\n" + 
			"        @a\\:=@a+1 sr,t_damage.damage_id as id,\r\n" + 
			"        t_damage.date as date,\r\n" + 
			"        t_damage.damage_no as recept_no,\r\n" + 
			"        t_damage.qty as qty \r\n" + 
			"    FROM\r\n" + 
			"        t_damage,(SELECT @a\\:=:index) AS a \r\n" + 
			"    where\r\n" + 
			"        t_damage.date =:date\r\n" + 
			"        AND t_damage.item_id=:itemId\r\n" + 
			"        and t_damage.del_status=1  ",nativeQuery=true)
	List<ItemQtyWithRecieptNo> getDamageDataByDate(@Param("date") String date,@Param("itemId") int itemId,@Param("index") int index);

}
