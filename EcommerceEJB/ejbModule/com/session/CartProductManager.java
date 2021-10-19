package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.midvi.entities.CartProduct;
import com.midvi.entities.Panier;
import com.midvi.entities.Products;
import com.midvi.entities.User;

/**
 * Session Bean implementation class CartProductManager
 */
@Stateless
@LocalBean
public class CartProductManager implements CartProductManagerRemote, CartProductManagerLocal {
	@PersistenceContext(unitName= "EcommerceEJB")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CartProductManager() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void addCart(CartProduct c,int qte) {
		// TODO Auto-generated method stub
    	c.setQuantite(qte);
		em.persist(c);
		
	}
	@Override
	public CartProduct getCartByProduct(Long id) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM CartProduct c ");
		
		List<CartProduct> carts = query.getResultList();
		for(CartProduct c : carts) {
			
			for(Products p : c.getProducts()) {
				if(p.getId().equals(id))
					return c;
			}
		}
		
		return null;
		
	}
	
    
}
