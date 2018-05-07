package com.att.onlinestore.bean;

public class Product {
	
	private String id;
	private String name;
	private String descrption;
	private String imageUrl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", descrption=" + descrption + ", imageUrl=" + imageUrl + "]";
	}
	public Product(String id, String name, String descrption, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.descrption = descrption;
		this.imageUrl = imageUrl;
	}
	
	
	
	

}
