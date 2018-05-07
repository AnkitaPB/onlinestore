package com.att.onlinestore.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.att.onlinestore.bean.Product;

public interface ProductService {

	void save(Product createProduct, MultipartFile file);


	void editProduct(String id,Product P);


	Map<String, Map<String, String>> deleteProduct(String id);

	List<Map<String, String>> getProductList();

	
}
