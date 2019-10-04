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

import com.ats.triladmin.model.AccountHead;
import com.ats.triladmin.model.Category;
import com.ats.triladmin.model.Company;
import com.ats.triladmin.model.DeliveryTerms;
import com.ats.triladmin.model.DepartmentMaster;
import com.ats.triladmin.model.Dept;
import com.ats.triladmin.model.DispatchMode;
import com.ats.triladmin.model.DocType;
import com.ats.triladmin.model.ErrorMessage;
import com.ats.triladmin.model.FinancialYears;
import com.ats.triladmin.model.GetItem;
import com.ats.triladmin.model.GetItemGroup;
import com.ats.triladmin.model.GetItemSubGrp;
import com.ats.triladmin.model.GetSubDept;
import com.ats.triladmin.model.Item;
import com.ats.triladmin.model.ItemGroup;
import com.ats.triladmin.model.ItemList;
import com.ats.triladmin.model.ItemSubGroup;
import com.ats.triladmin.model.PaymentTerms;
import com.ats.triladmin.model.SettingValue;
import com.ats.triladmin.model.State;
import com.ats.triladmin.model.SubDept;
import com.ats.triladmin.model.TaxForm;
import com.ats.triladmin.model.Type;
import com.ats.triladmin.model.Uom;
import com.ats.triladmin.model.User;
import com.ats.triladmin.model.Vendor;
import com.ats.triladmin.model.VendorListForRateVarification;
import com.ats.triladmin.repository.AccountHeadRepository;
import com.ats.triladmin.repository.CategoryRepository;
import com.ats.triladmin.repository.CompanyRepository;
import com.ats.triladmin.repository.DeliveryTermsRepository;
import com.ats.triladmin.repository.DepartmentMasterRepository;
import com.ats.triladmin.repository.DeptRepository;
import com.ats.triladmin.repository.DispatchModeRepository;
import com.ats.triladmin.repository.DocTypeRepository;
import com.ats.triladmin.repository.FinancialYearsRepository;
import com.ats.triladmin.repository.GetItemGroupRepository;
import com.ats.triladmin.repository.GetItemRepository;
import com.ats.triladmin.repository.GetItemSubGrpRepository;
import com.ats.triladmin.repository.GetSubDeptRepository;
import com.ats.triladmin.repository.ItemGroupRepository;
import com.ats.triladmin.repository.ItemRepository;
import com.ats.triladmin.repository.ItemSubGroupRepository;
import com.ats.triladmin.repository.PaymentTermsRepository;
import com.ats.triladmin.repository.SettingValueRepository;
import com.ats.triladmin.repository.StateRepository;
import com.ats.triladmin.repository.SubDeptRepository;
import com.ats.triladmin.repository.TaxFormRepository;
import com.ats.triladmin.repository.TypeRepository;
import com.ats.triladmin.repository.UomRepository;
import com.ats.triladmin.repository.UserRepository;
import com.ats.triladmin.repository.VendorListForRateVarificationRepository;
import com.ats.triladmin.repository.VendorRepository;

@RestController
public class MasterController {

	@Autowired
	DeptRepository deptRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	UomRepository uomRepository;

	@Autowired
	VendorRepository vendorRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	GetSubDeptRepository getSubDeptRepository;

	@Autowired
	FinancialYearsRepository financialYearsRepository;

	@Autowired
	SubDeptRepository subDeptRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	AccountHeadRepository accountHeadRepository;

	@Autowired
	DeliveryTermsRepository deliveryTermsRepository;

	@Autowired
	DispatchModeRepository dispatchModeRepository;

	@Autowired
	ItemGroupRepository itemGroupRepository;

	@Autowired
	ItemSubGroupRepository itemSubGroupRepository;

	@Autowired
	PaymentTermsRepository paymentTermsRepository;

	@Autowired
	GetItemSubGrpRepository getItemSubGrpRepository;

	@Autowired
	TaxFormRepository taxFormRepository;

	@Autowired
	GetItemGroupRepository getItemGroupRepository;

	@Autowired
	GetItemRepository getItemRepository;

	@Autowired
	DocTypeRepository docTypeRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@Autowired
	SettingValueRepository settingValueRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	VendorListForRateVarificationRepository vendorListForRateVarificationRepository;
	
	@Autowired
	DepartmentMasterRepository departmentMasterRepository;
	
	@RequestMapping(value = { "/getDepartmentMasterList" }, method = RequestMethod.GET)
	public @ResponseBody List<DepartmentMaster> getDepartmentMasterList() {

		List<DepartmentMaster> list = new ArrayList<>();

		try {

			list = departmentMasterRepository.findByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}
	
	@RequestMapping(value = { "/getCompanyDetails" }, method = RequestMethod.GET)
	public @ResponseBody Company getCompanyDetails() {

		Company res = new Company();

		try {

			res = companyRepository.findByComId(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}
	
	@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
	public @ResponseBody User saveUser(@RequestBody User user) {

		User res = new User();

		try {

			res = userRepository.save(user);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}
	
	@RequestMapping(value = { "/getUserList" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getUserList() {

		List<User> userList = new ArrayList<User>();

		try {

			userList = userRepository.findByDelStatus(0);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}
	
	@RequestMapping(value = { "/getUserById" }, method = RequestMethod.POST)
	public @ResponseBody User getUserById(@RequestParam("userId") int userId) {

		User user = new User();

		try {

			user = userRepository.findById(userId);
			 

		} catch (Exception e) {

			e.printStackTrace();

		}
		return user;

	}
	
	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteUser(@RequestParam("userId") int userId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {

			int delete = userRepository.delteUser(userId,1);
			
			if(delete==1) {
				
				errorMessage.setError(false);
				errorMessage.setMessage("deleted");
			}
			else {
				errorMessage.setError(true);
				errorMessage.setMessage("failed deleted");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/getSettingValue" }, method = RequestMethod.POST)
	public @ResponseBody  SettingValue  getSettingValue(@RequestParam("name") String name) {

		SettingValue settingValue = new SettingValue();

		try {

			settingValue = settingValueRepository.findAllByName(name);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return settingValue;

	}
	
	@RequestMapping(value = { "/getAlltype" }, method = RequestMethod.GET)
	public @ResponseBody List<Type> getAlltype() {

		List<Type> typeList = new ArrayList<Type>();

		try {

			typeList = typeRepository.findAllByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return typeList;

	}

	// -------------------Dept------------------------

	@RequestMapping(value = { "/saveDept" }, method = RequestMethod.POST)
	public @ResponseBody Dept saveDept(@RequestBody Dept dept) {

		Dept res = new Dept();

		try {

			res = deptRepository.saveAndFlush(dept);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getDeptByDeptId" }, method = RequestMethod.POST)
	public @ResponseBody Dept getDeptByDeptId(@RequestParam("deptId") int deptId) {

		Dept dept = null;
		try {
			dept = deptRepository.findDeptByDeptId(deptId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dept;

	}

	@RequestMapping(value = { "/getAllDeptByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Dept> getAllDeptByIsUsed() {

		List<Dept> dept = new ArrayList<Dept>();

		try {

			dept = deptRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dept;

	}

	@RequestMapping(value = { "/deleteDept" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDept(@RequestParam("deptId") int deptId,
			@RequestParam("deptDeletedIn") int deptDeletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = deptRepository.deleteDept(deptId, deptDeletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Dept Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// ------------------Financial Years------------------------

	@RequestMapping(value = { "/saveFinancialYears" }, method = RequestMethod.POST)
	public @ResponseBody FinancialYears saveFinancialYears(@RequestBody FinancialYears financialYears) {

		FinancialYears res = new FinancialYears();

		try {

			res = financialYearsRepository.saveAndFlush(financialYears);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getFinancialYearsByFYId" }, method = RequestMethod.POST)
	public @ResponseBody FinancialYears getFinancialYearsByFYId(@RequestParam("finYearId") int finYearId) {

		FinancialYears financialYears = null;
		try {
			financialYears = financialYearsRepository.findFinancialYearsByFinYearId(finYearId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return financialYears;

	}

	@RequestMapping(value = { "/getAllFinancialYears" }, method = RequestMethod.GET)
	public @ResponseBody List<FinancialYears> getAllFinancialYears() {

		List<FinancialYears> financialYearsList = new ArrayList<FinancialYears>();

		try {

			financialYearsList = financialYearsRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return financialYearsList;

	}

	@RequestMapping(value = { "/deleteFinancialYears" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteFinancialYears(@RequestParam("finYearId") int finYearId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = financialYearsRepository.deleteFinancialYears(finYearId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Year Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------SubDept------------------------

	@RequestMapping(value = { "/saveSubDept" }, method = RequestMethod.POST)
	public @ResponseBody SubDept saveSubDept(@RequestBody SubDept subDept) {

		SubDept res = new SubDept();

		try {

			res = subDeptRepository.saveAndFlush(subDept);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllSubDept" }, method = RequestMethod.GET)
	public @ResponseBody List<GetSubDept> getAllSubDept() {

		List<GetSubDept> subDeptList = new ArrayList<GetSubDept>();

		try {

			subDeptList = getSubDeptRepository.getAllSubDeptList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return subDeptList;

	}

	@RequestMapping(value = { "/getSubDeptBySubDeptId" }, method = RequestMethod.POST)
	public @ResponseBody GetSubDept getSubDeptBySubDeptId(@RequestParam("subDeptId") int subDeptId) {

		GetSubDept getSubDept = null;
		try {
			getSubDept = getSubDeptRepository.getSubDeptbySubDeptId(subDeptId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getSubDept;

	}

	@RequestMapping(value = { "/deleteSubDept" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSubDept(@RequestParam("subDeptId") int subDeptId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = subDeptRepository.deleteSubDept(subDeptId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("SubDept Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getSubDeptListByDeptId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetSubDept> getSubDeptListByDeptId(@RequestParam("deptId") int deptId) {

		List<GetSubDept> subDeptList = new ArrayList<GetSubDept>();

		try {

			subDeptList = getSubDeptRepository.getSubDeptListByDeptId(deptId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return subDeptList;

	}

	// -------------------Categroy-----------------------

	@RequestMapping(value = { "/saveCategory" }, method = RequestMethod.POST)
	public @ResponseBody Category saveCategory(@RequestBody Category category) {

		Category res = new Category();

		try {

			res = categoryRepository.saveAndFlush(category);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getCatByCatId" }, method = RequestMethod.POST)
	public @ResponseBody Category getCatByCatId(@RequestParam("catId") int catId) {

		Category category = null;
		try {
			category = categoryRepository.findCatByCatId(catId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return category;

	}

	@RequestMapping(value = { "/getAllCategoryByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategoryByIsUsed() {

		List<Category> category = new ArrayList<Category>();

		try {

			category = categoryRepository.findAllByIsUsedOrderByCatId(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return category;

	}

	@RequestMapping(value = { "/deleteCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteCategory(@RequestParam("catId") int catId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = categoryRepository.deleteCategory(catId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -------------------Account Head ---------------------

	@RequestMapping(value = { "/saveAccountHead" }, method = RequestMethod.POST)
	public @ResponseBody AccountHead saveAccountHead(@RequestBody AccountHead accountHead) {

		AccountHead res = new AccountHead();

		try {

			res = accountHeadRepository.saveAndFlush(accountHead);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAccontHeadByAccHeadId" }, method = RequestMethod.POST)
	public @ResponseBody AccountHead getAccontHeadByAccHeadId(@RequestParam("accHeadId") int accHeadId) {

		AccountHead accountHead = null;
		try {
			accountHead = accountHeadRepository.findCatByAccHeadId(accHeadId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return accountHead;

	}

	@RequestMapping(value = { "/getAllAccountHeadByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<AccountHead> getAllAccountHeadByIsUsed() {

		List<AccountHead> accountHead = new ArrayList<AccountHead>();

		try {

			accountHead = accountHeadRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return accountHead;

	}

	@RequestMapping(value = { "/deleteAccountHead" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteAccountHead(@RequestParam("accHeadId") int accHeadId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = accountHeadRepository.deleteAccountHead(accHeadId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Account Head Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -----------------DeliveryTerms--------------------------

	@RequestMapping(value = { "/saveDeliveryTerms" }, method = RequestMethod.POST)
	public @ResponseBody DeliveryTerms saveDeliveryTerms(@RequestBody DeliveryTerms deliveryTerms) {

		DeliveryTerms res = new DeliveryTerms();

		try {

			res = deliveryTermsRepository.saveAndFlush(deliveryTerms);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getDeliveryTermsByTermId" }, method = RequestMethod.POST)
	public @ResponseBody DeliveryTerms getDeliveryTermsByTermId(@RequestParam("deliveryTermId") int deliveryTermId) {

		DeliveryTerms deliveryTerms = null;
		try {
			deliveryTerms = deliveryTermsRepository.findDeliveryTermsByDeliveryTermId(deliveryTermId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return deliveryTerms;

	}

	@RequestMapping(value = { "/getAllDeliveryTermsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<DeliveryTerms> getAllDeliveryTermsByIsUsed() {

		List<DeliveryTerms> deliveryTermsList = new ArrayList<DeliveryTerms>();

		try {

			deliveryTermsList = deliveryTermsRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return deliveryTermsList;

	}

	@RequestMapping(value = { "/deleteDeliveryTerms" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDeliveryTerms(@RequestParam("deliveryTermId") int deliveryTermId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = deliveryTermsRepository.deleteDeliveryTerms(deliveryTermId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// -----------------DispatchMode-------------------------

	@RequestMapping(value = { "/saveDispatchMode" }, method = RequestMethod.POST)
	public @ResponseBody DispatchMode saveDispatchModes(@RequestBody DispatchMode dispatchMode) {

		DispatchMode res = new DispatchMode();

		try {

			res = dispatchModeRepository.saveAndFlush(dispatchMode);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getDispatchModeByTermId" }, method = RequestMethod.POST)
	public @ResponseBody DispatchMode getDispatchModeByTermId(@RequestParam("dispModeId") int dispModeId) {

		DispatchMode dispatchMode = null;
		try {
			dispatchMode = dispatchModeRepository.findByDispModeId(dispModeId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dispatchMode;

	}

	@RequestMapping(value = { "/getAllDispatchModesByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<DispatchMode> getAllDispatchModesByIsUsed() {

		List<DispatchMode> dispatchModeList = new ArrayList<DispatchMode>();

		try {

			dispatchModeList = dispatchModeRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dispatchModeList;

	}

	@RequestMapping(value = { "/deleteDispatchMode" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteDispatchMode(@RequestParam("dispModeId") int dispModeId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = dispatchModeRepository.deleteDispatchMode(dispModeId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// ------------------Item Group----------------------

	@RequestMapping(value = { "/saveItemGroup" }, method = RequestMethod.POST)
	public @ResponseBody ItemGroup saveItemGroup(@RequestBody ItemGroup itemGroup) {

		ItemGroup res = new ItemGroup();

		try {

			res = itemGroupRepository.saveAndFlush(itemGroup);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getItemGroupByGrpId" }, method = RequestMethod.POST)
	public @ResponseBody GetItemGroup getItemGroupByGrpId(@RequestParam("grpId") int grpId) {

		GetItemGroup itemGroup = null;
		try {
			itemGroup = getItemGroupRepository.getItemGrpByGrpId(grpId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemGroup;

	}

	@RequestMapping(value = { "/getAllItemGroupByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItemGroup> getAllItemGroupByIsUsed() {

		List<GetItemGroup> itemGroupList = new ArrayList<GetItemGroup>();

		try {

			itemGroupList = getItemGroupRepository.getAllItemGrpList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemGroupList;

	}

	@RequestMapping(value = { "/deleteItemGroup" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteItemGroup(@RequestParam("grpId") int grpId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = itemGroupRepository.deleteItemGroup(grpId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getgroupListByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemGroup> getgroupListByCatId(@RequestParam("catId") int catId) {

		List<GetItemGroup> itemGroupList = new ArrayList<GetItemGroup>();

		try {

			itemGroupList = getItemGroupRepository.getgroupListByCatId(catId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemGroupList;

	}

	// ------------------Item Sub Group----------------------

	@RequestMapping(value = { "/saveItemSubGroup" }, method = RequestMethod.POST)
	public @ResponseBody ItemSubGroup saveItemSubGroup(@RequestBody ItemSubGroup itemSubGroup) {

		ItemSubGroup res = new ItemSubGroup();

		try {

			res = itemSubGroupRepository.saveAndFlush(itemSubGroup);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getItemSubGrpBysubgrpId" }, method = RequestMethod.POST)
	public @ResponseBody GetItemSubGrp getItemSubGrpBysubgrpId(@RequestParam("subgrpId") int subgrpId) {

		GetItemSubGrp getItemSubGrp = null;
		try {
			getItemSubGrp = getItemSubGrpRepository.getSubItemBySubGroupId(subgrpId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getItemSubGrp;

	}

	@RequestMapping(value = { "/getAllItemSubGroup" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItemSubGrp> getAllItemSubGroup() {

		List<GetItemSubGrp> getItemSubGrpList = new ArrayList<GetItemSubGrp>();

		try {

			getItemSubGrpList = getItemSubGrpRepository.getAllItemSubGrpList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getItemSubGrpList;

	}

	@RequestMapping(value = { "/deleteItemSubGroup" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteItemSubGroup(@RequestParam("subgrpId") int subgrpId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = itemSubGroupRepository.deleteItemSubGroup(subgrpId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/getSubGroupByGroupId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItemSubGrp> getSubGroupByGroupId(@RequestParam("grpId") int grpId) {

		List<GetItemSubGrp> getItemSubGrpList = new ArrayList<GetItemSubGrp>();

		try {

			getItemSubGrpList = getItemSubGrpRepository.getSubGroupByGroupId(grpId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return getItemSubGrpList;

	}

	// -----------------Payment Terms---------------------

	@RequestMapping(value = { "/savePaymentTerms" }, method = RequestMethod.POST)
	public @ResponseBody PaymentTerms savePaymentTerms(@RequestBody PaymentTerms paymentTerms) {

		PaymentTerms res = new PaymentTerms();

		try {

			res = paymentTermsRepository.saveAndFlush(paymentTerms);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllPaymentTermsByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<PaymentTerms> getAllPaymentTermsByIsUsed() {

		List<PaymentTerms> paymentTermsList = new ArrayList<PaymentTerms>();

		try {

			paymentTermsList = paymentTermsRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return paymentTermsList;

	}

	@RequestMapping(value = { "/getPaymetTermsByPaymentTermId" }, method = RequestMethod.POST)
	public @ResponseBody PaymentTerms getPaymetTermsByPaymentTermId(@RequestParam("pymtTermId") int pymtTermId) {

		PaymentTerms paymentTerms = null;
		try {
			paymentTerms = paymentTermsRepository.findByPymtTermId(pymtTermId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return paymentTerms;

	}

	@RequestMapping(value = { "/deletePaymentTerms" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deletePaymentTerms(@RequestParam("pymtTermId") int pymtTermId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = paymentTermsRepository.deletePaymentTerms(pymtTermId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// ----------------Tax Form--------------------

	@RequestMapping(value = { "/saveTaxForm" }, method = RequestMethod.POST)
	public @ResponseBody TaxForm saveTaxForm(@RequestBody TaxForm taxForm) {

		TaxForm res = new TaxForm();

		try {

			res = taxFormRepository.saveAndFlush(taxForm);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getTaxFormByTaxId" }, method = RequestMethod.POST)
	public @ResponseBody TaxForm getTaxFormByTaxId(@RequestParam("taxId") int taxId) {

		TaxForm taxForm = null;
		try {
			taxForm = taxFormRepository.findByTaxId(taxId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taxForm;

	}

	@RequestMapping(value = { "/getAllTaxForms" }, method = RequestMethod.GET)
	public @ResponseBody List<TaxForm> getAllTaxForms() {

		List<TaxForm> taxFormList = new ArrayList<TaxForm>();

		try {

			taxFormList = taxFormRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taxFormList;

	}

	@RequestMapping(value = { "/deleteTaxForm" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteTaxForm(@RequestParam("taxId") int taxId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = taxFormRepository.deleteTaxForm(taxId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// ------------------Vendor-----------------------

	@RequestMapping(value = { "/saveVendor" }, method = RequestMethod.POST)
	public @ResponseBody Vendor saveVendor(@RequestBody Vendor vendor) {

		Vendor res = new Vendor();

		try {

			res = vendorRepository.saveAndFlush(vendor);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getVendorByVendorId" }, method = RequestMethod.POST)
	public @ResponseBody Vendor getVendorByVendorId(@RequestParam("vendorId") int vendorId) {

		Vendor vendor = null;
		try {
			vendor = vendorRepository.findByVendorId(vendorId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vendor;

	}

	@RequestMapping(value = { "/getAllVendorByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<Vendor> getAllVendorByIsUsed() {

		List<Vendor> vendor = new ArrayList<Vendor>();

		try {

			vendor = vendorRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vendor;

	}

	@RequestMapping(value = { "/deleteVendor" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteVendor(@RequestParam("vendorId") int vendorId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = vendorRepository.deleteVendor(vendorId, deletedIn);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage("Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}
	
	
	@RequestMapping(value = { "/getVendorListByItemIdForRateVerification" }, method = RequestMethod.POST)
	public @ResponseBody List<VendorListForRateVarification> getVendorListByItemIdForRateVerification(@RequestParam("itemId") int itemId) {

		List<VendorListForRateVarification> vendor = new ArrayList<VendorListForRateVarification>();

		try {

			vendor = vendorListForRateVarificationRepository.getVendorListByItemIdForRateVerification(itemId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vendor;

	}

	// ----------------Uom --------------------------

	@RequestMapping(value = { "/saveUom" }, method = RequestMethod.POST)
	public @ResponseBody Uom saveUom(@RequestBody Uom uom) {

		Uom res = new Uom();

		try {

			res = uomRepository.saveAndFlush(uom);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getUomFormByUomId" }, method = RequestMethod.POST)
	public @ResponseBody Uom getUomFormByUomId(@RequestParam("uomId") int uomId) {

		Uom uom = null;
		try {
			uom = uomRepository.findByUomId(uomId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return uom;

	}

	@RequestMapping(value = { "/getAllUoms" }, method = RequestMethod.GET)
	public @ResponseBody List<Uom> getAllUoms() {

		List<Uom> uomList = new ArrayList<Uom>();

		try {

			uomList = uomRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return uomList;

	}

	@RequestMapping(value = { "/deleteUom" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteUom(@RequestParam("uomId") int uomId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = uomRepository.deleteUom(uomId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// ---------------State --------------------------

	@RequestMapping(value = { "/saveState" }, method = RequestMethod.POST)
	public @ResponseBody State saveState(@RequestBody State state) {

		State res = new State();

		try {

			res = stateRepository.saveAndFlush(state);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getStateByStateId" }, method = RequestMethod.POST)
	public @ResponseBody State getStateByStateId(@RequestParam("stateId") int stateId) {

		State state = null;
		try {
			state = stateRepository.findByStateId(stateId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return state;

	}

	@RequestMapping(value = { "/getAllStates" }, method = RequestMethod.GET)
	public @ResponseBody List<State> getAllStates() {

		List<State> stateList = new ArrayList<State>();

		try {

			stateList = stateRepository.findAllByIsUsed(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return stateList;

	}

	@RequestMapping(value = { "/deleteState" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteState(@RequestParam("stateId") int stateId) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = stateRepository.deleteState(stateId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	// ------------ITEM --------------------------

	@RequestMapping(value = { "/saveItem" }, method = RequestMethod.POST)
	public @ResponseBody Item saveItem(@RequestBody Item item) {

		Item res = new Item();

		try {

			res = itemRepository.saveAndFlush(item);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getItemByItemId" }, method = RequestMethod.POST)
	public @ResponseBody GetItem getItemByItemId(@RequestParam("itemId") int itemId) {

		GetItem item = null;
		try {
			item = getItemRepository.getItemByItemId(itemId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return item;

	}

	@RequestMapping(value = { "/getAllItems" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItem> getAllItems() {

		List<GetItem> itemList = new ArrayList<GetItem>();

		try {

			itemList = getItemRepository.getAllItems();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}
	
	@RequestMapping(value = { "/getItemByItemIds" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItem> getItemByItemIds(@RequestParam("itemIds") List<Integer> itemIds) {

		List<GetItem> itemList = new ArrayList<GetItem>();

		try {

			itemList = getItemRepository.getItemListByItemIds(itemIds);
			 

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/itemListByGroupId" }, method = RequestMethod.POST)
	public @ResponseBody ItemList itemListByGroupId(@RequestParam("groupId") int groupId) {
		ItemList resList = new ItemList();
		List<GetItem> itemList = new ArrayList<GetItem>();

		try {

			itemList = getItemRepository.itemListByGroupId(groupId);
			resList.setItems(itemList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return resList;

	}

	@RequestMapping(value = { "/itemListByCatId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItem> itemListByCatId(@RequestParam("catId") int catId) {
		ItemList resList = new ItemList();
		List<GetItem> itemList = new ArrayList<GetItem>();

		try {

			itemList = getItemRepository.itemListByCatId(catId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/deleteItem" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteItem(@RequestParam("itemId") int itemId,
			@RequestParam("deletedIn") int deletedIn) {

		ErrorMessage errorMessage = new ErrorMessage();

		try {
			int delete = itemRepository.deleteItem(itemId);

			if (delete == 1) {
				errorMessage.setError(false);
				errorMessage.setMessage(" Deleted Successfully");
			} else {
				errorMessage.setError(true);
				errorMessage.setMessage("Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("Deletion Failed :EXC");

		}
		return errorMessage;
	}

	@RequestMapping(value = { "/saveDocType" }, method = RequestMethod.POST)
	public @ResponseBody DocType saveDocType(@RequestBody DocType docType) {

		DocType res = new DocType();

		try {

			res = docTypeRepository.saveAndFlush(docType);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/docTypeById" }, method = RequestMethod.POST)
	public @ResponseBody DocType docTypeById(@RequestParam("docTypeId") int docTypeId) {

		DocType res = new DocType();

		try {

			res = docTypeRepository.findByDocId(docTypeId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/docTypeByDocName" }, method = RequestMethod.POST)
	public @ResponseBody DocType docTypeByDocName(@RequestParam("docName") String docName) {

		DocType res = new DocType();

		try {

			res = docTypeRepository.findByDocName(docName);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllDocType" }, method = RequestMethod.GET)
	public @ResponseBody List<DocType> getAllDocType() {

		List<DocType> res = new ArrayList<DocType>();

		try {

			res = docTypeRepository.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}
	
	@RequestMapping(value = { "/getNextVendorNo" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage getNextVendorNo(@RequestParam("str") String str) {

		Vendor vendor = new Vendor();
		ErrorMessage errorMessage = new ErrorMessage();
		try {
			vendor = vendorRepository.getNextVendorNo(str);
			
			if(vendor!=null)
			{
				String code = vendor.getVendorCode();
				String alpha = new String();
				String zero = new String();
				int codeNo = 0;
				
				for(int i = 0 ; i<code.length() ; i++)
				{
					char ch = code.charAt(i);
					if(Character.isDigit(ch)){
						codeNo = Integer.parseInt(code.substring(i, code.length()))+1; 
						break;
					}
					else {
						alpha = alpha+ch;
					}
				}
				
				for(int i = 0 ; i< (6-(alpha.length()+String.valueOf(codeNo).length())) ; i++)
				{
					zero=zero+"0";
				}
				
				code=alpha+zero+String.valueOf(codeNo);
				System.out.println("new VedorCode    " + code); 
				errorMessage.setError(false);
				errorMessage.setMessage(code); 
			}
			else
			{
				errorMessage.setError(true);
				String alpha = str;
				String zero = new String();
				String code; 
				
				for(int i = 0 ; i< (5-alpha.length()) ; i++)
				{
					zero=zero+"0";
				}
				code=alpha+zero+"1";
				errorMessage.setMessage(code); 
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;

	}
	
	@RequestMapping(value = { "/getNextItemCode" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage getNextItemCode(@RequestParam("str") String str) {

		Item item = new Item();
		ErrorMessage errorMessage = new ErrorMessage();
		try {
			item = itemRepository.getNextItemCode(str);
			
			if(item!=null)
			{
				String code = item.getItemCode();
				String alpha = new String();
				String zero = new String();
				int codeNo = 0;
				
				for(int i = 0 ; i<code.length() ; i++)
				{
					char ch = code.charAt(i);
					if(Character.isDigit(ch)){
						codeNo = Integer.parseInt(code.substring(i, code.length()))+1; 
						break;
					}
					else {
						alpha = alpha+ch;
					}
				}
				
				for(int i = 0 ; i< (6-(alpha.length()+String.valueOf(codeNo).length())) ; i++)
				{
					zero=zero+"0";
				}
				
				code=alpha+zero+String.valueOf(codeNo);
				System.out.println("new VedorCode    " + code); 
				errorMessage.setError(false);
				errorMessage.setMessage(code); 
			}
			else
			{
				errorMessage.setError(true);
				String alpha = str;
				String zero = new String();
				String code; 
				
				for(int i = 0 ; i< (5-alpha.length()) ; i++)
				{
					zero=zero+"0";
				}
				code=alpha+zero+"1";
				errorMessage.setMessage(code); 
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return errorMessage;

	}

}
