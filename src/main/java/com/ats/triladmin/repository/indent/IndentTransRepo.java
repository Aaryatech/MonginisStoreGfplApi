package com.ats.triladmin.repository.indent;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.triladmin.model.indent.GetIndentByStatus;
import com.ats.triladmin.model.indent.IndentTrans;

public interface IndentTransRepo extends JpaRepository<IndentTrans, Integer> {
	
	IndentTrans save(IndentTrans indentTrans);
	
	List<IndentTrans> findByIndDStatus(int indDStatus);
	
	List<IndentTrans> findByIndMIdAndDelStatus(int indMId,int delStatus);
	
	@Transactional
	@Modifying
	@Query(" UPDATE IndentTrans  SET indQty=:indQty , indFyr=:indQty ,indItemSchd=:schDay , indItemSchddt=:schDate, indRemark=:remark WHERE indDId=:indDId ")
		int updateIndentDetail(@Param("indQty") 
		float indQty,@Param("indDId") int indDId,@Param("schDay")int schDay, @Param("schDate")Date schDate,@Param("remark")String remark);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE IndentTrans  SET delStatus=:delStatus"
			+ " WHERE indDId=:indDId ")
		int delteIndentDetail(@Param("delStatus") 
		int delStatus,@Param("indDId") int indDId);

	List<IndentTrans> findByItemIdAndDelStatus(int itemId, int i);

	//List<IndentTrans> findByIndMId(int indId);
	//apr 1 if dStatus==7
	@Transactional
	@Modifying
	@Query(" UPDATE IndentTrans  SET indDStatus=:indDStatus,ind_apr1_date=:apr1Date WHERE indDId IN (:indDetailIdList) AND indMId=:indentId ")
	int approve1Indent(@Param("indDStatus") int indDStatus,@Param("indDetailIdList") List<Integer> indDetailIdList,
			@Param("indentId") int indentId,@Param("apr1Date") Date apr1Date);
	
	
	//apr 2 if dStatus==0
		@Transactional
		@Modifying
		@Query(" UPDATE IndentTrans  SET indDStatus=:indDStatus,ind_apr2_date=:apr2Date WHERE indDId IN (:indDetailIdList) AND indMId=:indentId ")
		int approve2Indent(@Param("indDStatus") int indDStatus,@Param("indDetailIdList") List<Integer> indDetailIdList,
				@Param("indentId") int indentId,@Param("apr2Date") Date apr2Date);
		
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE IndentTrans  SET indDStatus=:indDStatus WHERE indDId NOT IN (:indDetailIdList)  AND indMId=:indentId ")
	int approveIndentUnSelected(@Param("indDStatus") int indDStatus,@Param("indDetailIdList") List<Integer> indDetailIdList,
			@Param("indentId") int indentId);

	List<IndentTrans> findByIndDStatusNotInAndIndMIdAndDelStatus(List<Integer> i, int indMId, int j);

	List<IndentTrans> findByIndDStatusAndIndMIdAndDelStatus(int i, int indMId, int j);

	
	@Transactional
	@Modifying
	@Query(" UPDATE IndentTrans  SET indQty=:indQty , indFyr=:indQty , indItemSchddt=:schDate, indRemark=:remark WHERE indDId=:indDId ") 
	int updateIndentDetail(@Param("indQty")float indQty, @Param("indDId")int indDId,@Param("schDate") Date schDate,@Param("remark") String remark);
	
}
