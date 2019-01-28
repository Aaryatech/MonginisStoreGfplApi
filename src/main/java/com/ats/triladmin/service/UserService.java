package com.ats.triladmin.service;

import java.util.List;

import com.ats.triladmin.model.Department;
import com.ats.triladmin.model.GetUserType;
import com.ats.triladmin.model.Info;
import com.ats.triladmin.model.LoginResponse;
import com.ats.triladmin.model.User;



public interface UserService {

	public LoginResponse findUserByUsername(String username,String password);

	public String save(User user);

	public Info insertUser(User user);

	public List<Department> getAllDept();

	public List<GetUserType> getAllUserType();
}
