package com.ats.triladmin.repository.doc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.triladmin.model.doc.DocumentBean;

@Repository
public interface DocumentBeanRepository extends JpaRepository<DocumentBean, Integer> {

	@Query(value = "Select * from m_doc where from_date <=:date And to_date >=:date and doc_id=:docId and del_status=0", nativeQuery = true)
	DocumentBean findByDocIdAndDate(@Param("docId") int docId, @Param("date") String date);

	@Query(value = "Select * from m_doc where from_date <=:date And to_date >=:date and doc_id=2 and del_status=0", nativeQuery = true)
	DocumentBean findByDocIdAndDateForPO(@Param("date") String date);

	@Query(value = "Select * from m_doc where from_date <=:date And to_date >=:date and doc_id=3 and del_status=0", nativeQuery = true)
	DocumentBean findByDocIdAndDateForMrn(@Param("date") String date);

	@Query(value = "select from_date from m_doc where del_status=0 group by from_date", nativeQuery = true)
	String getFirstDate();

	
	//sachin query item 
}
