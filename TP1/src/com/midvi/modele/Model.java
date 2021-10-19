package com.midvi.modele;

import java.util.ArrayList;
import java.util.List;

import com.midvi.entities.Products;
public class Model {
	private List<Products> productlist;
	private Products produit;
	private String msg;
	private boolean admin;
	public Model(List<Products> productlist, Products produit, String msg, boolean admin) {
		super();
		this.productlist = productlist;
		this.produit = produit;
		this.msg = msg;
		this.admin = admin;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public Model(List<Products> productlist, Products produit, String msg) {
		super();
		this.productlist = productlist;
		this.produit = produit;
		this.msg = msg;
	}
	public Model() {
		productlist = new ArrayList<Products>();
		admin = false;
		// TODO Auto-generated constructor stub
	}
	public List<Products> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Products> productlist) {
		this.productlist = productlist;
	}
	public Products getProduit() {
		return produit;
	}
	public void setProduit(Products produit) {
		this.produit = produit;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	

}
