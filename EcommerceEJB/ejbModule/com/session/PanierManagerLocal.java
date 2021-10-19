package com.session;

import java.util.List;

import javax.ejb.Local;

import com.midvi.entities.CartProduct;
import com.midvi.entities.Panier;
import com.midvi.entities.Products;
import com.midvi.entities.User;

@Local
public interface PanierManagerLocal {
	public void addPanier(Panier p, User user);
	public Panier getPanierByUser(Long id);
	public Panier addProducPanier(Panier p1, int qte,Long id);
	public Panier getPanierByUser(String email);
	public Panier addProducPanierByid(Long idP, int qte,Long id);
	 
	}
