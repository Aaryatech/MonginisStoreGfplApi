package com.ats.triladmin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.model.ItemExcel;
import com.ats.triladmin.repository.ItemExcelRepo;

@RestController
public class ETEVenSupController {
	@Autowired
	ItemExcelRepo itemExcelRepo;

	@RequestMapping(value = { "/getItemExcelList" }, method = RequestMethod.GET)
	public @ResponseBody List<ItemExcel> getItemExcelList() {

		List<ItemExcel> itemExcelList = new ArrayList<ItemExcel>();

		try {

			itemExcelList = itemExcelRepo.getItemExcelList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemExcelList;

	}

}
