package com.ats.triladmin.service;

import java.util.List;

import com.ats.triladmin.model.AccessRightModule;
import com.ats.triladmin.model.AssignRoleDetailList;
import com.ats.triladmin.model.Info;
import com.ats.triladmin.model.User;

public interface AccessRightService {

	List<AccessRightModule> getAllModulAndSubModule();

	Info saveAssignRole(AssignRoleDetailList assignRoleDetailList);

	List<AssignRoleDetailList> getAllAccessRole();
	
	Info updateRoleIdByEmpId(int id, int roleId);

	List<User> getAllUser();

	String getRoleJson(int usrId);

	
	
}
