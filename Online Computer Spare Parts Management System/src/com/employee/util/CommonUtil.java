package com.employee.util;

import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

import com.employee.service.IEmployeeService;


public class CommonUtil {

	public static final Logger log = Logger.getLogger(IEmployeeService.class.getName());

	public static final Properties properties = new Properties();


	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		String prefix = "EM";
		
		id = prefix + next;
		if (arrayList.contains(id)) {
			next++;
			id = prefix + next;
		}
		return id;
	}
}
