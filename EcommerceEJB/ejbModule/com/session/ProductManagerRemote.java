package com.session;

import java.util.List;

import javax.ejb.Remote;

import com.midvi.entities.Products;

@Remote
public interface ProductManagerRemote {
	public void addProduct(Products p);
	public List<Products> getProducts();
	public Products getProduct(Long id);
	public Products editProducts(Long id, Products p);
	public void deleteProduct(Long id);
	public List<Products> Search(String libelle);
}
