package com.supplier.util;

import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

import com.product.service.*;


public class CommonUtil {

	public static final Logger log = Logger.getLogger(IProductService.class.getName());

	public static final Properties properties = new Properties();


	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		String prefix = "SU00";
		
		id = prefix + next;
		if (arrayList.contains(id)) {
			next++;
			id = prefix + next;
		}
		return id;
	}
}
