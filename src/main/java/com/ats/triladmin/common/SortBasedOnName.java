package com.ats.triladmin.common;

import java.util.Comparator;

import com.ats.triladmin.model.IndentStatusReport;

public class SortBasedOnName implements Comparator{

	public int compare(Object o1, Object o2) 
	{

		IndentStatusReport dd1 = (IndentStatusReport)o1;// where FBFriends_Obj is your object class
		IndentStatusReport dd2 = (IndentStatusReport)o2;
	    return dd1.getIndMNo().compareToIgnoreCase(dd2.getIndMNo());//where uname is field name
	}

}
