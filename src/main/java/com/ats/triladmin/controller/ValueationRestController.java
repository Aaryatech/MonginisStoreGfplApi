package com.ats.triladmin.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.triladmin.common.DateConvertor;
import com.ats.triladmin.model.ConsumptionReportData;
import com.ats.triladmin.model.ConsumptionReportWithCatId;
import com.ats.triladmin.model.IndentStatusReport;
import com.ats.triladmin.model.IndentValueLimit;
import com.ats.triladmin.model.IssueAndMrnGroupWise;
import com.ats.triladmin.model.IssueAndMrnItemWise;
import com.ats.triladmin.model.IssueDeptWise;
import com.ats.triladmin.model.IssueMonthWiseList;
import com.ats.triladmin.model.ItemExpectedReport;
import com.ats.triladmin.model.ItemQtyWithRecieptNo;
import com.ats.triladmin.model.ItemValuationList;
import com.ats.triladmin.model.MonthCategoryWiseMrnReport;
import com.ats.triladmin.model.MonthItemWiseMrnReport;
import com.ats.triladmin.model.MonthItemWiseMrnReportRepository;
import com.ats.triladmin.model.MonthSubDeptWiseIssueReport;
import com.ats.triladmin.model.MonthWiseIssueReport;
import com.ats.triladmin.model.MrnMonthWiseList;
import com.ats.triladmin.model.ShortItemReport;
import com.ats.triladmin.model.StockValuationCategoryWise;
import com.ats.triladmin.model.Type;
import com.ats.triladmin.model.doc.SubDocument;
import com.ats.triladmin.repository.ConsumptionReportRepository;
import com.ats.triladmin.repository.IndentStatusReportRepository;
import com.ats.triladmin.repository.IndentValueLimitRepository;
import com.ats.triladmin.repository.IssueAndMrnGroupWiseRepository;
import com.ats.triladmin.repository.IssueAndMrnItemWiseRepository;
import com.ats.triladmin.repository.IssueDeptWiseRepository;
import com.ats.triladmin.repository.ItemExpectedReportRepository;
import com.ats.triladmin.repository.ItemQtyWithRecieptNoRepository;
import com.ats.triladmin.repository.MonthCategoryWiseMrnReportRepository;
import com.ats.triladmin.repository.MonthSubDeptWiseIssueRepository;
import com.ats.triladmin.repository.MonthWiseIssueRepository;
import com.ats.triladmin.repository.ShortItemReportRepository;
import com.ats.triladmin.repository.StockValuationCategoryWiseRepository;
import com.ats.triladmin.repository.TypeRepository;
import com.ats.triladmin.repository.doc.DocumentBeanRepository; 

@RestController
public class ValueationRestController {
	
	@Autowired
	ItemQtyWithRecieptNoRepository itemQtyWithRecieptNoRepository;
	
	@Autowired
	StockValuationCategoryWiseRepository stockValuationCategoryWiseRepository;
	
	@Autowired
	IssueAndMrnGroupWiseRepository issueAndMrnGroupWiseRepository;
	
	@Autowired
	IssueAndMrnItemWiseRepository issueAndMrnItemWiseRepository;
	
	@Autowired
	IssueDeptWiseRepository issueDeptWiseRepository;
	
	@Autowired
	DocumentBeanRepository documentBeanRepository;
	
	@Autowired
	MonthWiseIssueRepository monthWiseIssueRepository;
	
	@Autowired
	MonthSubDeptWiseIssueRepository monthSubDeptWiseIssueRepository;
	
	@Autowired
	ConsumptionReportRepository consumptionReportRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@Autowired
	MonthCategoryWiseMrnReportRepository monthCategoryWiseMrnReportRepository;
	
	@Autowired
	MonthItemWiseMrnReportRepository monthItemWiseMrnReportRepository;
	
	@Autowired
	IndentValueLimitRepository indentValueLimitRepository;
	
	@Autowired
	IndentStatusReportRepository indentStatusReportRepository;
	
	@Autowired
	ItemExpectedReportRepository itemExpectedReportRepository;
	
	@Autowired
	ShortItemReportRepository shortItemReportRepository;
	
	@RequestMapping(value = { "/valueationReportDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemValuationList> valueationReportDetail(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("itemId") int itemId) {
		
		 List<ItemValuationList> finalList = new  ArrayList<ItemValuationList>();

		try {
			 
		 
			 

					 List<Date> dates = new ArrayList<Date>(); 
					 DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
					 Date  startDate = (Date)formatter.parse(fromDate); 
					 Date  endDate = (Date)formatter.parse(toDate);

					 long interval = 24*1000 * 60 * 60; 
					 long endTime =endDate.getTime() ; 
					 long curTime = startDate.getTime();

					 while (curTime <= endTime) {

					     dates.add(new Date(curTime)); 
					     curTime += interval;

					 }
					 
					 int index=0;

					 for(int i=0;i<dates.size();i++){

					     Date lDate =(Date)dates.get(i); 
					     String ds = formatter.format(lDate);
 
					     List<ItemQtyWithRecieptNo> getMrnDataByDate = new ArrayList<>(); 
					     getMrnDataByDate = itemQtyWithRecieptNoRepository.getMrnDataByDate(DateConvertor.convertToYMD(ds),itemId, index); 
					     for(int j = 0 ; j< getMrnDataByDate.size() ; j++)
					     {
					    	 ItemValuationList itemValuationList = new ItemValuationList();
					    	 itemValuationList.setDate(ds);
					    	 itemValuationList.setTypeName("MRN APPROVED QTY");
					    	 itemValuationList.setReceptNo(getMrnDataByDate.get(j).getReceptNo());
					    	 itemValuationList.setQty(getMrnDataByDate.get(j).getQty());
					    	 itemValuationList.setType(1);
					    	 finalList.add(itemValuationList);
					     }
					     if(!getMrnDataByDate.isEmpty()) {
					    	 
					    	 index=getMrnDataByDate.get(getMrnDataByDate.size()-1).getSr();
					     }
					     
					     List<ItemQtyWithRecieptNo> getIssueDataByDate = new ArrayList<>(); 
					     getIssueDataByDate = itemQtyWithRecieptNoRepository.getIssueDataByDate(DateConvertor.convertToYMD(ds),itemId,index); 
					     for(int j = 0 ; j< getIssueDataByDate.size() ; j++)
					     {
					    	 ItemValuationList itemValuationList = new ItemValuationList();
					    	 itemValuationList.setDate(ds);
					    	 itemValuationList.setTypeName("ISSUE QTY");
					    	 itemValuationList.setReceptNo(getIssueDataByDate.get(j).getReceptNo());
					    	 itemValuationList.setQty(getIssueDataByDate.get(j).getQty());
					    	 itemValuationList.setType(0);
					    	 finalList.add(itemValuationList);
					     }
					     
					     if(!getIssueDataByDate.isEmpty()) {
					    	 
					    	 index=getIssueDataByDate.get(getIssueDataByDate.size()-1).getSr();
					     }
					     
					     List<ItemQtyWithRecieptNo> getDamageDataByDate = new ArrayList<>(); 
					     getDamageDataByDate = itemQtyWithRecieptNoRepository.getDamageDataByDate(DateConvertor.convertToYMD(ds),itemId,index); 
					     for(int j = 0 ; j< getDamageDataByDate.size() ; j++)
					     {
					    	 ItemValuationList itemValuationList = new ItemValuationList();
					    	 itemValuationList.setDate(ds);
					    	 itemValuationList.setTypeName("DAMAGE QTY");
					    	 itemValuationList.setReceptNo(getDamageDataByDate.get(j).getReceptNo());
					    	 itemValuationList.setQty(getDamageDataByDate.get(j).getQty());
					    	 itemValuationList.setType(0);
					    	 finalList.add(itemValuationList);
					     }
					     
					     if(!getDamageDataByDate.isEmpty()) {
					    	 
					    	 index=getDamageDataByDate.get(getDamageDataByDate.size()-1).getSr();
					     }
					     
					     /*List<ItemQtyWithRecieptNo> getReturnGatePassDataByDate = new ArrayList<>(); 
					     getReturnGatePassDataByDate = itemQtyWithRecieptNoRepository.getReturnGatePassDataByDate(DateConvertor.convertToYMD(ds),itemId); 
					     for(int j = 0 ; j< getReturnGatePassDataByDate.size() ; j++)
					     {
					    	 ItemValuationList itemValuationList = new ItemValuationList();
					    	 itemValuationList.setDate(ds);
					    	 itemValuationList.setTypeName("RETURN GATEPASS QTY");
					    	 itemValuationList.setReceptNo(getReturnGatePassDataByDate.get(j).getReceptNo());
					    	 itemValuationList.setQty(getReturnGatePassDataByDate.get(j).getQty());
					    	 itemValuationList.setType(1);
					    	 finalList.add(itemValuationList);
					     }*/

					 }
					 
					 System.out.println("finalList   "  + finalList);
 
				 
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/stockValueationReport" }, method = RequestMethod.POST)
	public @ResponseBody List<StockValuationCategoryWise> stockValueationReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId) {
		
		 List<StockValuationCategoryWise> finalList = new  ArrayList<StockValuationCategoryWise>();

		try {
			  
					  if(typeId==0) {
						  finalList = stockValuationCategoryWiseRepository.stockValueationReport(fromDate,toDate);  
					  }
					  else {
						  finalList = stockValuationCategoryWiseRepository.stockValueationReport(fromDate,toDate,typeId); 
					  }
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueAndMrnCatWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<StockValuationCategoryWise> issueAndMrnCatWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev) {
		
		 List<StockValuationCategoryWise> finalList = new  ArrayList<StockValuationCategoryWise>();

		try {
			  
					  
					  if(typeId!=0 && isDev!=-1){
						  finalList = stockValuationCategoryWiseRepository.issueAndMrnCatWiseReport(fromDate,toDate,typeId,isDev); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  finalList = stockValuationCategoryWiseRepository.issueAndMrnCatWiseReport(fromDate,toDate,typeId); 
					  }
					  else if(typeId==0 && isDev!=-1){
						  finalList = stockValuationCategoryWiseRepository.issueAndMrnCatWiseReportWithIsDev(fromDate,toDate,isDev); 
					  }
					  else{
						  finalList = stockValuationCategoryWiseRepository.issueAndMrnCatWiseReport(fromDate,toDate);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueAndMrnGroupWisReportByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueAndMrnGroupWise> issueAndMrnGroupWisReportByCatId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("catId") int catId) {
		
		 List<IssueAndMrnGroupWise> finalList = new  ArrayList<IssueAndMrnGroupWise>();

		try {
			   
					  if(typeId!=0 && isDev!=-1){
						  finalList = issueAndMrnGroupWiseRepository.issueAndMrnGroupWisReportByCatId(fromDate,toDate,typeId,isDev,catId); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  finalList = issueAndMrnGroupWiseRepository.issueAndMrnGroupWisReportByCatIdWithAllDevelopment(fromDate,toDate,typeId,catId); 
					  }
					  else if(typeId==0 && isDev!=-1){
						  finalList = issueAndMrnGroupWiseRepository.issueAndMrnGroupWisReportByCatIdWithAllType(fromDate,toDate,isDev,catId); 
					  }
					  else{
						  finalList = issueAndMrnGroupWiseRepository.issueAndMrnGroupWisReportByCatId(fromDate,toDate,catId);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueAndMrnItemWiseReportByGroupId" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueAndMrnItemWise> issueAndMrnItemWiseReportByGroupId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("groupId") int groupId) {
		
		 List<IssueAndMrnItemWise> finalList = new  ArrayList<IssueAndMrnItemWise>();

		try {
			   
					  if(typeId!=0 && isDev!=-1){
						  finalList = issueAndMrnItemWiseRepository.issueAndMrnItemWiseReportByGroupIdWithTypeIdAndIsDev(fromDate,toDate,typeId,isDev,groupId); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  finalList = issueAndMrnItemWiseRepository.issueAndMrnGroupWisReportByGroupWithAllDevelopment(fromDate,toDate,typeId,groupId); 
					  }
					  else if(typeId==0 && isDev!=-1){
						  finalList = issueAndMrnItemWiseRepository.issueAndMrnGroupWisReportByCatIdWithAllType(fromDate,toDate,isDev,groupId); 
					  }
					  else{
						  finalList = issueAndMrnItemWiseRepository.issueAndMrnGroupWisReportByCatId(fromDate,toDate,groupId);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueDepartmentWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueDeptWise> issueDepartmentWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("deptId") int deptId) {
		
		 List<IssueDeptWise> finalList = new  ArrayList<IssueDeptWise>();

		try {
			   
					  if(typeId!=0 && isDev!=-1 && deptId!=0){
						  finalList = issueDeptWiseRepository.issueDeptWiseReportWithTypeIdAndIsDevAndDept(fromDate,toDate,typeId,isDev,deptId); 
					  }
					  else if(typeId!=0 && isDev==-1 && deptId!=0) {
						  
						  finalList = issueDeptWiseRepository.issueDeptWiseReportWithTypeIdAndDeptId(fromDate,toDate,typeId,deptId); 
					  }
					  else if(typeId!=0 && isDev!=-1 && deptId==0) {
						  finalList = issueDeptWiseRepository.issueDeptWiseReportWithTypeIdAndIsDev(fromDate,toDate,typeId,isDev); 
					  }
					  else if(typeId!=0 && isDev==-1 && deptId==0) {
						  finalList = issueDeptWiseRepository.issueDeptWiseReportWithTypeId(fromDate,toDate,typeId); 
					  }
					  else if(typeId==0 && isDev!=-1 && deptId==0) {
						  finalList = issueDeptWiseRepository.issueDeptWiseReportWithIsDev(fromDate,toDate,isDev);  
					  }
					  else if(typeId==0 && isDev!=-1 && deptId!=0) {
						  finalList = issueDeptWiseRepository.issueDeptWiseReportWithIsDevAndDeptId(fromDate,toDate,isDev,deptId);  
					  }
					  else if(typeId==0 && isDev==-1 && deptId!=0) {
						  finalList = issueDeptWiseRepository.issueDeptWiseReportWithDeptId(fromDate,toDate,deptId);  
					  }
					  else {
						  finalList = issueDeptWiseRepository.issueDeptWiseReport(fromDate,toDate);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueSubDepartmentWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueDeptWise> issueSubDepartmentWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("deptId") int deptId) {
		
		 List<IssueDeptWise> finalList = new  ArrayList<IssueDeptWise>();

		try {
			   
					  if(typeId!=0 && isDev!=-1){
						  finalList = issueDeptWiseRepository.issueSubDeptWiseReportWithTypeIdAndIsDev(fromDate,toDate,typeId,isDev,deptId); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  
						  finalList = issueDeptWiseRepository.issueSubDeptWiseReportWithTypeId(fromDate,toDate,typeId,deptId); 
					  }
					  else if(typeId==0 && isDev!=-1 ) {
						  finalList = issueDeptWiseRepository.issueSubDeptWiseReportWithIsDev(fromDate,toDate,isDev,deptId); 
					  } 
					  else {
						  finalList = issueDeptWiseRepository.issueSubDeptWiseReport(fromDate,toDate,deptId);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueItemWiseReportBySubDept" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueDeptWise> issueItemWiseReportBySubDept(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("subDept") int subDept) {
		
		 List<IssueDeptWise> finalList = new  ArrayList<IssueDeptWise>();

		try {
			   
					  if(typeId!=0 && isDev!=-1){
						  finalList = issueDeptWiseRepository.issueItemWiseReportWithTypeIdAndIsDevBySubDept(fromDate,toDate,typeId,isDev,subDept); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  
						  finalList = issueDeptWiseRepository.issueItemWiseReportWithTypeId(fromDate,toDate,typeId,subDept); 
					  }
					  else if(typeId==0 && isDev!=-1 ) {
						  finalList = issueDeptWiseRepository.issueItemWiseWiseReportWithIsDev(fromDate,toDate,isDev,subDept); 
					  } 
					  else {
						  finalList = issueDeptWiseRepository.issueItemWiseReportBySubDept(fromDate,toDate,subDept);  
					  }
					   
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return finalList;

	}
	
	@RequestMapping(value = { "/issueMonthWiseReportByDept" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueMonthWiseList> issueMonthWiseReportByDept(@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev ) {
		
		
		List<IssueMonthWiseList> monthWiseList = new ArrayList<>();
		

		try {
			   
			String firstDate = documentBeanRepository.getFirstDate();
			System.out.println("firstDate " + firstDate);
			 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date d = sdf.parse(firstDate);
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(d);
	            int month = cal.get(Calendar.MONTH);  
	            int yer = cal.get(Calendar.YEAR);
	            
	            cal.add(Calendar.MONTH, 1);  
	            cal.set(Calendar.DAY_OF_MONTH, 1);  
	            cal.add(Calendar.DATE, -1);
	            int dd = cal.get(Calendar.DATE); 
	            firstDate=yer+"-"+(month+1)+"-"+"01";
	            String lastDate=yer+"-"+(month+1)+"-"+dd;
	            
	            /*System.out.println("First Date of month  " + firstDate);
	            System.out.println("Last Date of month  " + lastDate);*/
	            int index=0;
	            for(int i=0 ; i<12 ; i++) {
	            	IssueMonthWiseList issueMonth  = new IssueMonthWiseList();
	            	 List<MonthWiseIssueReport> finalList = new  ArrayList<MonthWiseIssueReport>();
	            	 
	            	if(typeId!=0 && isDev!=-1){
						  finalList = monthWiseIssueRepository.issueMonthWiseReportWithTypeIdAndIsDev(firstDate,lastDate,typeId,isDev,index); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  
						  finalList = monthWiseIssueRepository.issueMonthWiseReportWithTypeId(firstDate,lastDate,typeId,index); 
					  }
					  else if(typeId==0 && isDev!=-1 ) {
						  finalList = monthWiseIssueRepository.issueMonthWiseWiseReportWithIsDev(firstDate,lastDate,isDev,index); 
					  } 
					  else {
						  finalList = monthWiseIssueRepository.issueMonthWiseReport(firstDate,lastDate,index);  
					  }
	            	index=finalList.get(finalList.size()-1).getSr();
	            	issueMonth.setMonthList(finalList); 
	            	monthWiseList.add(issueMonth);
	            	System.out.println(finalList);
	            	finalList = new  ArrayList<MonthWiseIssueReport>();
	            	Date da = sdf.parse(firstDate);
		            Calendar cala = Calendar.getInstance();
		            cala.setTime(da);
		            cala.add(Calendar.MONTH, 1);
		            cala.set(Calendar.DATE, cala.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		            int montha = cala.get(Calendar.MONTH);  
		            int yere = cala.get(Calendar.YEAR);
		            
		            cala.add(Calendar.MONTH, 1);  
		            cala.set(Calendar.DAY_OF_MONTH, 1);  
		            cala.add(Calendar.DATE, -1);
		            int dda = cala.get(Calendar.DATE);
		            firstDate=yere+"-"+(montha+1)+"-"+"01";
		             lastDate=yere+"-"+(montha+1)+"-"+dda;
		           /* System.out.println("First Date of month  " + firstDate);
		            System.out.println("Last Date of month  " + lastDate);
		            
		            */
	            }
			
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return monthWiseList;

	}
	
	@RequestMapping(value = { "/issueMonthSubDeptWiseReportByDeptId" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueMonthWiseList> issueMonthSubDeptWiseReportByDeptId(@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("deptId") int deptId) {
		
		
		List<IssueMonthWiseList> monthWiseList = new ArrayList<>();
		

		try {
			   
			String firstDate = documentBeanRepository.getFirstDate();
			System.out.println("firstDate " + firstDate);
			 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date d = sdf.parse(firstDate);
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(d);
	            int month = cal.get(Calendar.MONTH);  
	            int yer = cal.get(Calendar.YEAR);
	            
	            cal.add(Calendar.MONTH, 1);  
	            cal.set(Calendar.DAY_OF_MONTH, 1);  
	            cal.add(Calendar.DATE, -1);
	            int dd = cal.get(Calendar.DATE); 
	            firstDate=yer+"-"+(month+1)+"-"+"01";
	            String lastDate=yer+"-"+(month+1)+"-"+dd;
	            
	            /*System.out.println("First Date of month  " + firstDate);
	            System.out.println("Last Date of month  " + lastDate);*/
	            int index=0;
	            for(int i=0 ; i<12 ; i++) {
	            	IssueMonthWiseList issueMonth  = new IssueMonthWiseList();
	            	 List<MonthSubDeptWiseIssueReport> finalList = new  ArrayList<MonthSubDeptWiseIssueReport>();
	            	 
	            	if(typeId!=0 && isDev!=-1){
						  finalList = monthSubDeptWiseIssueRepository.issueMonthWiseReportWithTypeIdAndIsDevByDeptId(firstDate,lastDate,typeId,isDev,index,deptId); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  
						  finalList = monthSubDeptWiseIssueRepository.issueMonthWiseReportWithTypeIdByDeptId(firstDate,lastDate,typeId,index,deptId); 
					  }
					  else if(typeId==0 && isDev!=-1 ) {
						  finalList = monthSubDeptWiseIssueRepository.issueMonthWiseWiseReportWithIsDevByDeptId(firstDate,lastDate,isDev,index,deptId); 
					  } 
					  else {
						  finalList = monthSubDeptWiseIssueRepository.issueMonthWiseReportByDeptId(firstDate,lastDate,index,deptId);  
					  }
	            	index=finalList.get(finalList.size()-1).getSr();
	            	issueMonth.setMonthSubDeptList(finalList); 
	            	monthWiseList.add(issueMonth);
	            	System.out.println(finalList);
	            	finalList = new  ArrayList<MonthSubDeptWiseIssueReport>();
	            	Date da = sdf.parse(firstDate);
		            Calendar cala = Calendar.getInstance();
		            cala.setTime(da);
		            cala.add(Calendar.MONTH, 1);
		            cala.set(Calendar.DATE, cala.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		            int montha = cala.get(Calendar.MONTH);  
		            int yere = cala.get(Calendar.YEAR);
		            
		            cala.add(Calendar.MONTH, 1);  
		            cala.set(Calendar.DAY_OF_MONTH, 1);  
		            cala.add(Calendar.DATE, -1);
		            int dda = cala.get(Calendar.DATE);
		            firstDate=yere+"-"+(montha+1)+"-"+"01";
		             lastDate=yere+"-"+(montha+1)+"-"+dda;
		           /* System.out.println("First Date of month  " + firstDate);
		            System.out.println("Last Date of month  " + lastDate);
		            
		            */
	            }
			
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return monthWiseList;

	}
	
	@RequestMapping(value = { "/issueMonthItemWiseReportBySubDeptId" }, method = RequestMethod.POST)
	public @ResponseBody List<IssueMonthWiseList> issueMonthItemWiseReportBySubDeptId(@RequestParam("typeId") int typeId,@RequestParam("isDev") int isDev,
			@RequestParam("subDeptId") int subDeptId) {
		
		
		List<IssueMonthWiseList> monthWiseList = new ArrayList<>();
		

		try {
			   
			String firstDate = documentBeanRepository.getFirstDate();
			System.out.println("firstDate " + firstDate);
			 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date d = sdf.parse(firstDate);
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(d);
	            int month = cal.get(Calendar.MONTH);  
	            int yer = cal.get(Calendar.YEAR);
	            
	            cal.add(Calendar.MONTH, 1);  
	            cal.set(Calendar.DAY_OF_MONTH, 1);  
	            cal.add(Calendar.DATE, -1);
	            int dd = cal.get(Calendar.DATE); 
	            firstDate=yer+"-"+(month+1)+"-"+"01";
	            String lastDate=yer+"-"+(month+1)+"-"+dd;
	            
	            /*System.out.println("First Date of month  " + firstDate);
	            System.out.println("Last Date of month  " + lastDate);*/
	            int index=0;
	            for(int i=0 ; i<12 ; i++) {
	            	IssueMonthWiseList issueMonth  = new IssueMonthWiseList();
	            	 List<MonthSubDeptWiseIssueReport> finalList = new  ArrayList<MonthSubDeptWiseIssueReport>();
	            	 
	            	if(typeId!=0 && isDev!=-1){
						  finalList = monthSubDeptWiseIssueRepository.issueMonthItemWiseReportWithTypeIdAndIsDevBySubDeptId(firstDate,lastDate,typeId,isDev,index,subDeptId); 
					  }
					  else if(typeId!=0 && isDev==-1) {
						  
						  finalList = monthSubDeptWiseIssueRepository.issueMonthItemWiseReportWithTypeIdBySubDeptId(firstDate,lastDate,typeId,index,subDeptId); 
					  }
					  else if(typeId==0 && isDev!=-1 ) {
						  finalList = monthSubDeptWiseIssueRepository.issueMonthItemWiseReportWithIsDevBySubDeptId(firstDate,lastDate,isDev,index,subDeptId); 
					  } 
					  else {
						  finalList = monthSubDeptWiseIssueRepository.issueMonthItemWiseReportBySubDeptId(firstDate,lastDate,index,subDeptId);  
					  }
	            	index=finalList.get(finalList.size()-1).getSr();
	            	issueMonth.setMonthSubDeptList(finalList); 
	            	monthWiseList.add(issueMonth);
	            	System.out.println(finalList);
	            	finalList = new  ArrayList<MonthSubDeptWiseIssueReport>();
	            	Date da = sdf.parse(firstDate);
		            Calendar cala = Calendar.getInstance();
		            cala.setTime(da);
		            cala.add(Calendar.MONTH, 1);
		            cala.set(Calendar.DATE, cala.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		            int montha = cala.get(Calendar.MONTH);  
		            int yere = cala.get(Calendar.YEAR);
		            
		            cala.add(Calendar.MONTH, 1);  
		            cala.set(Calendar.DAY_OF_MONTH, 1);  
		            cala.add(Calendar.DATE, -1);
		            int dda = cala.get(Calendar.DATE);
		            firstDate=yere+"-"+(montha+1)+"-"+"01";
		             lastDate=yere+"-"+(montha+1)+"-"+dda;
		           /* System.out.println("First Date of month  " + firstDate);
		            System.out.println("Last Date of month  " + lastDate);
		            
		            */
	            }
			
			 
		} catch (Exception e) {

			e.printStackTrace();

		}
		return monthWiseList;

	}
	
	 @RequestMapping(value = { "/getConsumptionMrnData" }, method = RequestMethod.POST)
	public @ResponseBody List<ConsumptionReportWithCatId> getConsumptionData(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		 List<ConsumptionReportWithCatId> list = new ArrayList<ConsumptionReportWithCatId>();
		try {
			String firstDate = documentBeanRepository.getFirstDate();
			List<Type> typeList = typeRepository.findAllByDelStatus(1);
			
			int index=0;

			for(int i = 0 ; i<typeList.size() ;i++) {
				ConsumptionReportWithCatId consumptionReportWithCatId = new ConsumptionReportWithCatId();
				List<ConsumptionReportData> consumptionReportData = consumptionReportRepository.findByPoTypeAndDate(typeList.get(i).getTypeId(),firstDate,fromDate,toDate,index);
				consumptionReportWithCatId.setTypeId(typeList.get(i).getTypeId());
				consumptionReportWithCatId.setTypeName(typeList.get(i).getTypeName());
				consumptionReportWithCatId.setConsumptionReportList(consumptionReportData);
				index=consumptionReportData.get(consumptionReportData.size()-1).getSr();
				list.add(consumptionReportWithCatId);
			}
			
				System.out.println(list);

		} catch (Exception e) {
			

			e.printStackTrace();
			 
		}
		return list;

	} 
	 
	 @RequestMapping(value = { "/getConsumptionIssueData" }, method = RequestMethod.POST)
		public @ResponseBody List<ConsumptionReportWithCatId> getConsumptionIssueData(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

			 List<ConsumptionReportWithCatId> list = new ArrayList<ConsumptionReportWithCatId>();
			try {
				String firstDate = documentBeanRepository.getFirstDate();
				List<Type> typeList = typeRepository.findAllByDelStatus(1);
				
				int index=0;

				for(int i = 0 ; i<typeList.size() ;i++) {
					ConsumptionReportWithCatId consumptionReportWithCatId = new ConsumptionReportWithCatId();
					List<ConsumptionReportData> consumptionReportData = consumptionReportRepository.findByPoTypeAndDateIssueDate(typeList.get(i).getTypeId(),firstDate,fromDate,toDate,index);
					consumptionReportWithCatId.setTypeId(typeList.get(i).getTypeId());
					consumptionReportWithCatId.setTypeName(typeList.get(i).getTypeName());
					consumptionReportWithCatId.setConsumptionReportList(consumptionReportData);
					index=consumptionReportData.get(consumptionReportData.size()-1).getSr();
					list.add(consumptionReportWithCatId);
				}
				
					System.out.println(list);

			} catch (Exception e) {
				

				e.printStackTrace();
				 
			}
			return list;

		} 
	 
	 
	 @RequestMapping(value = { "/mrnMonthCategoryWiseReport" }, method = RequestMethod.POST)
		public @ResponseBody List<MrnMonthWiseList> mrnMonthCategoryWiseReport(@RequestParam("typeId") int typeId,@RequestParam("isDev") List<Integer> isDev,
				@RequestParam("deptId") int deptId,@RequestParam("subDeptId") int subDeptId) {
			
			
			List<MrnMonthWiseList> monthWiseList = new ArrayList<MrnMonthWiseList>();
			

			try {
				   
				String firstDate = documentBeanRepository.getFirstDate();
				System.out.println("firstDate " + firstDate);
				 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		            Date d = sdf.parse(firstDate);
		            Calendar cal = Calendar.getInstance();
		            cal.setTime(d);
		            int month = cal.get(Calendar.MONTH);  
		            int yer = cal.get(Calendar.YEAR);
		            
		            cal.add(Calendar.MONTH, 1);  
		            cal.set(Calendar.DAY_OF_MONTH, 1);  
		            cal.add(Calendar.DATE, -1);
		            int dd = cal.get(Calendar.DATE); 
		            firstDate=yer+"-"+(month+1)+"-"+"01";
		            String lastDate=yer+"-"+(month+1)+"-"+dd;
		            
		            /*System.out.println("First Date of month  " + firstDate);
		            System.out.println("Last Date of month  " + lastDate);*/
		            int index=0;
		            for(int i=0 ; i<12 ; i++) {
		            	MrnMonthWiseList mrnMonth  = new MrnMonthWiseList();
		            	 List<MonthCategoryWiseMrnReport> finalList = new  ArrayList<MonthCategoryWiseMrnReport>();
		            	 
		            	if(typeId!=0 && deptId!=0){
		            		
		            		if(subDeptId!=0) {
		            			finalList = monthCategoryWiseMrnReportRepository.MrnMonthcategoryReportWithTypeIdAndDeptIdAndSubDeptId(firstDate,lastDate,typeId,isDev,deptId,subDeptId,index);
								
		            		}
		            		else {
		            			finalList = monthCategoryWiseMrnReportRepository.MrnMonthcategoryReportWithTypeIdAndDeptId(firstDate,lastDate,typeId,isDev,deptId,index);
								  
		            		}
							   
						  }
		            	else if(typeId==0 && deptId!=0 ) {
							  
							  if(subDeptId!=0) {
								  
								  finalList = monthCategoryWiseMrnReportRepository.MrnMonthcategoryReportWithDeptIdAndSubDeptId(firstDate,lastDate,isDev,deptId,subDeptId,index);
									
			            			
			            		}
			            		else {
			            			finalList = monthCategoryWiseMrnReportRepository.MrnMonthcategoryReportWithDeptId(firstDate,lastDate,isDev,deptId,index);
									
			            		}
							   
						  } 
						  else if(typeId!=0 && deptId==0) { 
							  
							  finalList = monthCategoryWiseMrnReportRepository.MrnMonthcategoryReportWithTypeId(firstDate,lastDate,typeId,isDev,index);
							  
						  }
						  
						  else {
							  finalList = monthCategoryWiseMrnReportRepository.MrnMonthcategoryReport(firstDate,lastDate,isDev,index); 
						  }
		            	index=finalList.get(finalList.size()-1).getSr();
		            	mrnMonth.setMonthList(finalList); 
		            	monthWiseList.add(mrnMonth);
		            	System.out.println(finalList);
		            	finalList = new  ArrayList<MonthCategoryWiseMrnReport>();
		            	Date da = sdf.parse(firstDate);
			            Calendar cala = Calendar.getInstance();
			            cala.setTime(da);
			            cala.add(Calendar.MONTH, 1);
			            cala.set(Calendar.DATE, cala.getActualMinimum(Calendar.DAY_OF_MONTH)); 
			            int montha = cala.get(Calendar.MONTH);  
			            int yere = cala.get(Calendar.YEAR);
			            
			            cala.add(Calendar.MONTH, 1);  
			            cala.set(Calendar.DAY_OF_MONTH, 1);  
			            cala.add(Calendar.DATE, -1);
			            int dda = cala.get(Calendar.DATE);
			            firstDate=yere+"-"+(montha+1)+"-"+"01";
			             lastDate=yere+"-"+(montha+1)+"-"+dda;
			           /* System.out.println("First Date of month  " + firstDate);
			            System.out.println("Last Date of month  " + lastDate);
			            
			            */
		            }
				
				 
			} catch (Exception e) {

				e.printStackTrace();

			}
			return monthWiseList;

		}
	 
	 
	 @RequestMapping(value = { "/mrnMonthItemWiseReport" }, method = RequestMethod.POST)
		public @ResponseBody List<MrnMonthWiseList> mrnMonthItemWiseReport(@RequestParam("typeId") int typeId,@RequestParam("isDev") List<Integer> isDev,
				@RequestParam("catId") int catId,@RequestParam("deptId") int deptId,@RequestParam("subDeptId") int subDeptId) {
			
			
			List<MrnMonthWiseList> monthWiseList = new ArrayList<MrnMonthWiseList>();
			

			try {
				   
				String firstDate = documentBeanRepository.getFirstDate();
				System.out.println("firstDate " + firstDate);
				 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		            Date d = sdf.parse(firstDate);
		            Calendar cal = Calendar.getInstance();
		            cal.setTime(d);
		            int month = cal.get(Calendar.MONTH);  
		            int yer = cal.get(Calendar.YEAR);
		            
		            cal.add(Calendar.MONTH, 1);  
		            cal.set(Calendar.DAY_OF_MONTH, 1);  
		            cal.add(Calendar.DATE, -1);
		            int dd = cal.get(Calendar.DATE); 
		            firstDate=yer+"-"+(month+1)+"-"+"01";
		            String lastDate=yer+"-"+(month+1)+"-"+dd;
		            
		            /*System.out.println("First Date of month  " + firstDate);
		            System.out.println("Last Date of month  " + lastDate);*/
		            int index=0;
		            for(int i=0 ; i<12 ; i++) {
		            	MrnMonthWiseList mrnMonth  = new MrnMonthWiseList();
		            	 List<MonthItemWiseMrnReport> finalList = new  ArrayList<MonthItemWiseMrnReport>();
		            	 
		            	if(typeId!=0 && deptId!=0){
		            		
		            		if(subDeptId!=0) {
		            			finalList = monthItemWiseMrnReportRepository.MrnMonthItemReportWithTypeIdAndDeptIdAndSubDeptId(firstDate,lastDate,catId,typeId,isDev,deptId,subDeptId,index);
								
		            		}
		            		else {
		            			finalList = monthItemWiseMrnReportRepository.MrnMonthItemReportWithTypeIdAndDeptId(firstDate,lastDate,catId,typeId,isDev,deptId,index);
								  
		            		}
							   
						  }
		            	else if(typeId==0 && deptId!=0 ) {
							  
							  if(subDeptId!=0) {
								  
								  finalList = monthItemWiseMrnReportRepository.MrnMonthItemReportWithDeptIdAndSubDeptId(firstDate,lastDate,catId,isDev,deptId,subDeptId,index);
									
			            			
			            		}
			            		else {
			            			finalList = monthItemWiseMrnReportRepository.MrnMonthItemReportWithDeptId(firstDate,lastDate,catId,isDev,deptId,index);
									
			            		}
							   
						  } 
						  else if(typeId!=0 && deptId==0) { 
							  
							  finalList = monthItemWiseMrnReportRepository.MrnMonthItemReportWithTypeId(firstDate,lastDate,catId,typeId,isDev,index);
							  
						  }
						  
						  else {
							  finalList = monthItemWiseMrnReportRepository.MrnMonthItemReport(firstDate,lastDate,catId,isDev,index); 
						  }
		            	index=finalList.get(finalList.size()-1).getSr();
		            	mrnMonth.setItemWiseMonthList(finalList); 
		            	monthWiseList.add(mrnMonth);
		            	System.out.println(finalList);
		            	finalList = new  ArrayList<MonthItemWiseMrnReport>();
		            	Date da = sdf.parse(firstDate);
			            Calendar cala = Calendar.getInstance();
			            cala.setTime(da);
			            cala.add(Calendar.MONTH, 1);
			            cala.set(Calendar.DATE, cala.getActualMinimum(Calendar.DAY_OF_MONTH)); 
			            int montha = cala.get(Calendar.MONTH);  
			            int yere = cala.get(Calendar.YEAR);
			            
			            cala.add(Calendar.MONTH, 1);  
			            cala.set(Calendar.DAY_OF_MONTH, 1);  
			            cala.add(Calendar.DATE, -1);
			            int dda = cala.get(Calendar.DATE);
			            firstDate=yere+"-"+(montha+1)+"-"+"01";
			             lastDate=yere+"-"+(montha+1)+"-"+dda;
			           /* System.out.println("First Date of month  " + firstDate);
			            System.out.println("Last Date of month  " + lastDate);
			            
			            */
		            }
				
				 
			} catch (Exception e) {

				e.printStackTrace();

			}
			return monthWiseList;

		}
	
	 @RequestMapping(value = { "/getIndentValueLimit" }, method = RequestMethod.POST)
		public @ResponseBody List<IndentValueLimit> getIndentValueLimit(@RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate, @RequestParam("typeId") String typeId, @RequestParam("catId") String catId
				,@RequestParam("status") List<Integer> status) {

			 List<IndentValueLimit> list = new ArrayList<IndentValueLimit>();
			try {
				 
				 list = indentValueLimitRepository.getIndentValueLimit(fromDate,toDate,typeId,catId,status); 

			} catch (Exception e) {
				 
				e.printStackTrace(); 
			}
			return list;

		}
	 
	 @RequestMapping(value = { "/indentStatusReport" }, method = RequestMethod.POST)
		public @ResponseBody List<IndentStatusReport> indentStatusReport(@RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate,@RequestParam("flag") int flag  ) {

			 List<IndentStatusReport> indentPendig = new ArrayList<IndentStatusReport>();
			 List<IndentStatusReport> pendingPo = new ArrayList<IndentStatusReport>();
			 List<IndentStatusReport> rejectedMrn = new ArrayList<IndentStatusReport>();
			try {
				 int index=0;
				 
				 if(flag==0) {
					 
					 indentPendig = indentStatusReportRepository.indentPendig(fromDate,toDate,index); 
						
						if(!indentPendig.isEmpty()) {
					    	 
					    	 index=indentPendig.get(indentPendig.size()-1).getSr();
					     }
						
						pendingPo = indentStatusReportRepository.pendingPo(fromDate,toDate,index); 

						if(!pendingPo.isEmpty()) {
					    	 
					    	 index=pendingPo.get(pendingPo.size()-1).getSr();
					     }
						
						rejectedMrn = indentStatusReportRepository.rejectedMrn(fromDate,toDate,index); 
						
						
						
						for(int i=0 ; i<pendingPo.size() ; i++) {
							
							indentPendig.add(pendingPo.get(i));
						}
						
						for(int i=0 ; i<rejectedMrn.size() ; i++) {
							
							indentPendig.add(rejectedMrn.get(i));
						}
						
						Collections.sort(indentPendig, new Comparator<IndentStatusReport>() {
				            @Override
				            public int compare(IndentStatusReport indentStatusReport, IndentStatusReport t1) {
				                String s1 = indentStatusReport.getIndMNo();
				                String s2 = t1.getIndMNo();
				                return s1.compareToIgnoreCase(s2);
				            }

				        });
				 }else {
					 
					 indentPendig = indentStatusReportRepository.indentPendigBySchDate(fromDate,toDate,index); 
						
						if(!indentPendig.isEmpty()) {
					    	 
					    	 index=indentPendig.get(indentPendig.size()-1).getSr();
					     }
						
						pendingPo = indentStatusReportRepository.pendingPoBySchDate(fromDate,toDate,index); 

						if(!pendingPo.isEmpty()) {
					    	 
					    	 index=pendingPo.get(pendingPo.size()-1).getSr();
					     }
						
						rejectedMrn = indentStatusReportRepository.rejectedMrn(fromDate,toDate,index); 
						
						
						
						for(int i=0 ; i<pendingPo.size() ; i++) {
							
							indentPendig.add(pendingPo.get(i));
						}
						
						for(int i=0 ; i<rejectedMrn.size() ; i++) {
							
							indentPendig.add(rejectedMrn.get(i));
						}
						
						Collections.sort(indentPendig, new Comparator<IndentStatusReport>() {
				            @Override
				            public int compare(IndentStatusReport indentStatusReport, IndentStatusReport t1) {
				                String s1 = indentStatusReport.getIndMNo();
				                String s2 = t1.getIndMNo();
				                return s1.compareToIgnoreCase(s2);
				            }

				        });
				 }
				
				
			} catch (Exception e) {
				 
				e.printStackTrace(); 
			}
			return indentPendig;

		}
	 
	 @RequestMapping(value = { "/getItemExpectedReportBetweenDate" }, method = RequestMethod.POST)
		public @ResponseBody List<ItemExpectedReport> getItemExpectedReportBetweenDate(@RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate ,@RequestParam("status") List<Integer> status,@RequestParam("catId") int catId) {

			 List<ItemExpectedReport> list = new ArrayList<ItemExpectedReport>();
			try {
				 if(catId==0) {
				 list = itemExpectedReportRepository.getItemExpectedReportBetweenDate(fromDate,toDate,status); 
				 }else {
					 
					 list = itemExpectedReportRepository.getItemExpectedReportBetweenDate(fromDate,toDate,status,catId); 
				 }

			} catch (Exception e) {
				 
				e.printStackTrace(); 
			}
			return list;

		}
	 
	 @RequestMapping(value = { "/getShortItemReportBetweenDate" }, method = RequestMethod.POST)
		public @ResponseBody List<ShortItemReport> getShortItemReportBetweenDate(@RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate ,@RequestParam("catId") int catId) {

			 List<ShortItemReport> list = new ArrayList<ShortItemReport>();
			try {
				 
				if(catId==0) {
				 list = shortItemReportRepository.getShortItemReportBetweenDate(fromDate,toDate); 
				}else {
					list = shortItemReportRepository.getShortItemReportBetweenDate(fromDate,toDate,catId); 
				}

			} catch (Exception e) {
				 
				e.printStackTrace(); 
			}
			return list;

		} 

}
