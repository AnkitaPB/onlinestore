package com.att.onlinestore.util;



public class ProductUtil {
	public static int id=0;
	
	public static String getUniqueIdForProduct() {
		
		id++;
		String uid="P"+id;
		
		return uid;
	}
	
	
		
}
