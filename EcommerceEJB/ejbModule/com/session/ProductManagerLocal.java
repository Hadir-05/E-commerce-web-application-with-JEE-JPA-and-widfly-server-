package com.session;

import java.util.List;

import javax.ejb.Local;

import com.midvi.entities.Products;

@Local
public interface ProductManagerLocal {
	public void addProduct(Products p);
	public List<Products> getProducts();
	public Products getProduct(Long id);
	public Products editProducts(Long id, Products p);
	public void deleteProduct(Long id);
	public List<Products> Search(String libelle);
}
