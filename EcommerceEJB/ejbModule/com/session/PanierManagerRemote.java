package com.session;

import java.util.List;

import javax.ejb.Remote;

import com.midvi.entities.CartProduct;
import com.midvi.entities.Panier;
import com.midvi.entities.Products;
import com.midvi.entities.User;

@Remote
public interface PanierManagerRemote {
	public void addPanier(Panier p, User user);
	public Panier addProducPanier(Panier p1, int qte,Long id);
	public Panier getPanierByUser(Long id);
	public Panier getPanierByUser(String email);
	public Panier addProducPanierByid(Long idP, int qte,Long id);


	}
