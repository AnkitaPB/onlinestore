package com.att.onlinestore.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.att.onlinestore.bean.Product;


@Component 
class ProductServiceImpl implements ProductService {
	public static int id=1;
	public static Map<String,Map<String,String>> plist=new HashMap<String, Map<String, String>>();
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	private static final String UPLOADED_FOLDER = "C://tmp//";	


	@Override
	public void save(Product createProduct,MultipartFile file) {
		
		Map<String,String> prd=new HashMap<String,String>();
		 prd.put("id", createProduct.getId());
		 prd.put("name",createProduct.getName());
		 prd.put("description", createProduct.getDescrption());
		 prd.put("url", createProduct.getImageUrl());
		 plist.put(createProduct.getId(),prd);
		 logger.info("Created Product: "+plist);
		 System.out.println("Created Product: "+plist);
		 fileUpload(file);
		
		 
		
	}
	
	

	
	
	private void fileUpload(MultipartFile file) {

		 try {
	       	  
	       	   byte[] bytes = file.getBytes();
	              Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	          
				Files.write(path, bytes);
				logger.info("File uploaded");
			} catch (IOException e) {
				logger.trace("File Upload method  failed..");
				e.printStackTrace();
			}
		
	}





	





	@Override
	public   List<Map<String, String>>   getProductList() {
	    List<Map<String,String>> getPrdList=new ArrayList<Map<String, String>>();

		System.out.println("display service"+plist);
		
		Map<String,String> m=new HashMap<>();
		for (Entry<String, Map<String, String>> outerMapEntry : plist.entrySet()) {
	        // do something with outerMapEntry
	       System.out.println(outerMapEntry.getKey() + " => " + outerMapEntry.getValue());
	       /* for (Entry<String, String> innerMapEntry : outerMapEntry.getValue().entrySet()) {
	            // do something with inner map entry
	           System.out.println(innerMapEntry.getKey() + " => " + innerMapEntry.getValue());
	        	
	        	m.put(innerMapEntry.getKey(), innerMapEntry.getValue());
	        	
	        }*/
	        getPrdList.add(outerMapEntry.getValue());

	    }
    	

    	System.out.println("=================getProductList:=============");
    	System.out.println(getPrdList);
		return getPrdList;
	}

	@Override
	public void editProduct(String id,Product p) {

		 
		 Map<String,String> prd=plist.get(id);
		 prd.put("id", p.getId());
		 prd.put("name",p.getName());
		 prd.put("description", p.getDescrption());
		 prd.put("url", p.getImageUrl());
		 plist.put(id,prd);
		 
		
		
	}

	@Override
	public Map<String, Map<String, String>> deleteProduct(String id) {
		/*if(!getPrdList.isEmpty() && getPrdList!=null)
		{
		for(Map<String, String> child : getPrdList){
		    for(String key : child.keySet()){
		                if(child.get(id)==id && child.get(name)==name && child.get(descr)==descr && child.get(url)==url)
		                    child.remove(key);
		                	getPrdList.remove(child);
		    }
		    	System.out.println("deleted list"+getPrdList);
		    	if(getPrdList.isEmpty())
		    	{
		    		return null;
		    	}
		}
		return getPrdList;
		}
		return null;*/
		
		Iterator<Map.Entry<String, Map<String, String>>> parent = plist.entrySet().iterator();
		while (parent.hasNext()) {
		    Map.Entry<String, Map<String, String>> parentPair = parent.next();
		   // System.out.println("parentPair.getKey() :   " + parentPair.getKey() + " parentPair.getValue()  :  " + parentPair.getValue());
		    if(parentPair.getKey().equals(id))
		    {
		    	parent.remove();
		    }
		    
		}
		
		System.out.println("Plist after remove: "+plist);
			return plist;
	


	}
	


	


}
	









	

