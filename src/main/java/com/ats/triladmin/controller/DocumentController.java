package com.ats.triladmin.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.model.Dept;
import com.ats.triladmin.model.FinancialYears;
import com.ats.triladmin.model.doc.DocumentBean;
import com.ats.triladmin.model.doc.SubDocument;
import com.ats.triladmin.repository.doc.DocumentBeanRepository;
import com.ats.triladmin.repository.doc.SubDocumentRepository;

@RestController
public class DocumentController {

	@Autowired
	DocumentBeanRepository documentBeanRepository;

	@Autowired
	SubDocumentRepository subDocumentRepository;

	
	//sachin 21 aug 2018
	@RequestMapping(value = { "/getDocumentInfo" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentInfo(@RequestParam("docId") int docId,
			@RequestParam("date") String date) {

		DocumentBean documentBean = null;
		try {

			documentBean = documentBeanRepository.findByDocIdAndDate(docId, date);

			
		}catch (Exception e) {
			
			System.err.println("Exception in getting /getDocumentInfo " +e.getMessage());
			
			e.printStackTrace();
			
		}
		return documentBean;
	}
	
	@RequestMapping(value = { "/getDocumentData" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentData(@RequestParam("docId") int docId,
			@RequestParam("date") String date, @RequestParam("catId") int catId, @RequestParam("typeId") int typeId) {

		DocumentBean documentBean = null;
		try {

			documentBean = documentBeanRepository.findByDocIdAndDate(docId, date);

			if (documentBean != null) {

				SubDocument subDocumentRes = subDocumentRepository.findByMIdAndCatIdAndDelStatusAndDocId(documentBean.getId(),
						catId, 0,typeId);
				documentBean.setSubDocument(subDocumentRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}

	@RequestMapping(value = { "/getDocumentDataForPO" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentDataForPO(@RequestParam("date") String date) {

		DocumentBean documentBean = null;
		try {
			Date now = new Date();

			documentBean = documentBeanRepository.findByDocIdAndDateForPO(date);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}

	@RequestMapping(value = { "/getDocumentDataForMrn" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean getDocumentDataForMrn(@RequestParam("date") String date) {

		DocumentBean documentBean = null;
		try {
			Date now = new Date();

			documentBean = documentBeanRepository.findByDocIdAndDateForMrn(date);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}

	@RequestMapping(value = { "/saveSubDoc" }, method = RequestMethod.POST)
	public @ResponseBody SubDocument updateSubDoc(@RequestBody SubDocument subDocument) {

		SubDocument res = new SubDocument();

		try {

			res = subDocumentRepository.saveAndFlush(subDocument);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/postDocumentData" }, method = RequestMethod.POST)
	public @ResponseBody DocumentBean postDocumentData(@RequestParam("docId") int docId,
			@RequestParam("date") String date, @RequestParam("catId") int catId) {

		DocumentBean documentBean = null;
		try {

			documentBean = documentBeanRepository.findByDocIdAndDate(docId, date);

			if (documentBean != null) {

				SubDocument subDocumentRes = subDocumentRepository.findByMIdAndCatIdAndDelStatus(documentBean.getId(),
						catId, 0);
				subDocumentRepository.save(subDocumentRes);
				documentBean.setSubDocument(subDocumentRes);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return documentBean;

	}
}
