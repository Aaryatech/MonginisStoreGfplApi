package com.ats.triladmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.triladmin.model.DocType;

public interface DocTypeRepository extends JpaRepository<DocType, Integer>{

	DocType findByDocId(int docTypeId);

	DocType findByDocName(String docName);

}
