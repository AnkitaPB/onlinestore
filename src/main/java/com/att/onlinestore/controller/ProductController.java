package com.att.onlinestore.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.att.onlinestore.bean.Product;
import com.att.onlinestore.service.LoginService;
import com.att.onlinestore.service.ProductService;

@Controller
@SessionAttributes("name")
public class ProductController {

	@Autowired
	LoginService loginService;
	
	@Autowired 
	ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginPage(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model,@RequestParam String name,@RequestParam String password)
	{
		boolean isValidUser=loginService.validateUser(name,password);
		if(!isValidUser)
		{
			model.put("errorMessage","Invalid Credetials");
			return "login";
		}
		model.put("name",name);
		model.put("password",password);
		return "home";
	}
	
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String showProductForm(Model model )
	{
		return "add";
		
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String showProduct(Model model )
	{
		return "home";
		
	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProdutcInfo(ModelMap model,@RequestParam String id,@RequestParam String name,@RequestParam String descr,@RequestParam("url") MultipartFile file)
	{
		logger.info("File Name:"+file.getOriginalFilename()+" "+file.getName());

		Product createProduct=new Product(id, name, descr, file.getOriginalFilename());
		System.out.println(createProduct.toString());
		
		productService.save(createProduct,file);
		
		List<Map<String, String>> prodList = productService.getProductList();
		List<JSONObject> jsonObj = new ArrayList<JSONObject>();

		for(Map<String, String> data : prodList) {
		    JSONObject obj = new JSONObject(data);
		    jsonObj.add(obj);
		}

		JSONArray test = new JSONArray(jsonObj);
		
		model.put("prodlist", test);
		return "displayProducts";
	}
	
	@RequestMapping(value="/displayProducts",method=RequestMethod.GET)
	public String displayProductInfo(ModelMap model) {
		System.out.println("***********In Display controller************");
		List<Map<String, String>> prodList = productService.getProductList();
		if(!prodList.isEmpty())
		{
		List<JSONObject> jsonObj = new ArrayList<JSONObject>();
		for(Map<String, String> data : prodList) {
		    JSONObject obj = new JSONObject(data);
		    jsonObj.add(obj);
		}

		JSONArray test = new JSONArray(jsonObj);
		
		model.put("prodlist", test);
		
		System.out.println("display product: "+prodList);
		return "displayProducts";
		}
		else
		{
			return "home";
		}
	}
	
	@RequestMapping(value="/editProduct/{id}")
	public String callEditProductPage(@PathVariable String id) {
	
		return "editProduct";
	}
	
	@RequestMapping(value="/updateProduct", method=RequestMethod.GET)
	public String editProductById(ModelMap model,@RequestParam String id,@RequestParam String pname,@RequestParam String descr,@RequestParam String url)
	{
		System.out.println("***********Update Controller*************");
		Product editProduct=new Product(id, pname, descr, url);
		System.out.println("update "+editProduct.toString());
		productService.editProduct(id,editProduct);
		List<JSONObject> jsonObj = new ArrayList<JSONObject>();
		List<Map<String, String>> prodList = productService.getProductList();

		
		for(Map<String, String> data : prodList) {
		    JSONObject obj = new JSONObject(data);
		    jsonObj.add(obj);
		}

		JSONArray test = new JSONArray(jsonObj);
		model.put("prodlist", test);

		System.out.println("&&& update: "+test);
		return "displayProducts";
	}
	
	@RequestMapping(value="/deleteProduct/{id}", method=RequestMethod.GET)
	public String deleteProductById(ModelMap model,@PathVariable String id)
	{
		System.out.println("delete controller");
		
		List<JSONObject> jsonObj = new ArrayList<JSONObject>();
		productService.deleteProduct(id);
		List<Map<String, String>> prodList = productService.getProductList();
		logger.info("After Delete the product list is:"+prodList);
		//System.out.println("prd:"+prodList);
		if(prodList!=null)
		{
		
			for(Map<String, String> data : prodList) {
				JSONObject obj = new JSONObject(data);
				jsonObj.add(obj);
			}

			JSONArray test = new JSONArray(jsonObj);
			model.put("prodlist", test);

			System.out.println(" * delete: "+test);
			return "displayProducts";
		}
		else
		{
			return "productNotExist";
		}
		}
	
	@RequestMapping(value="/productNotExist", method=RequestMethod.GET)
	public String productNotExist()
	{
		
		return "home";
	}
	
}
	

