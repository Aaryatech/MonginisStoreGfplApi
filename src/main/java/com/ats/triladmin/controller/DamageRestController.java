package com.ats.triladmin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.model.Damage;
import com.ats.triladmin.model.ErrorMessage;
import com.ats.triladmin.model.GetDamage;
import com.ats.triladmin.repository.DamageRepository;
import com.ats.triladmin.repository.GetDamageRepository; 

@RestController
public class DamageRestController {
	
	@Autowired
	DamageRepository damageRepository;
	
	@Autowired
	GetDamageRepository getDamageRepository;

	@RequestMapping(value = { "/saveDamage" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveDamage(@RequestBody List<Damage> damageList) {
		
		List<Damage> save = new ArrayList<Damage>();
		ErrorMessage errorMessage = new ErrorMessage();
		try {

			save = damageRepository.saveAll(damageList);
			
			if(save!=null)
			{
				errorMessage.setError(false);
				errorMessage.setMessage("save");
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed");
			}
 
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed");

		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/saveDamageSingle" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveDamageSingle(@RequestBody Damage damage) {
		
		Damage save = new Damage();
		ErrorMessage errorMessage = new ErrorMessage();
		try {

			save = damageRepository.save(damage);
			
			if(save!=null)
			{
				errorMessage.setError(false);
				errorMessage.setMessage("save");
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("failed");
			}
 
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed");

		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/getDamageList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDamage> getDamageList(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate
			, @RequestParam("typeId") List<Integer> typeId) {
		
		List<GetDamage> getDamageList = new ArrayList<GetDamage>();

		try {

			getDamageList = getDamageRepository.getDamageList(fromDate,toDate,typeId);
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getDamageList;

	}
	
	@RequestMapping(value = { "/getDamageById" }, method = RequestMethod.POST)
	public @ResponseBody GetDamage getDamageById(@RequestParam("damageId") int damageId) {
		
		GetDamage getDamage = new GetDamage();

		try {

			getDamage = getDamageRepository.getDamageById(damageId);
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return getDamage;

	}
	
	@RequestMapping(value = { "/deleteDamage" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDamage(@RequestParam("damageId") int damageId) {
		
		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int delete = damageRepository.deleteDamage(damageId);
			
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("fail");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("deleted");
			}
 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;

	}

}
