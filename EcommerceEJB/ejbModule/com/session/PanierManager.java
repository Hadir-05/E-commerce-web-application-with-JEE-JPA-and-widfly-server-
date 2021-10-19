package com.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.midvi.entities.CartProduct;
import com.midvi.entities.Panier;
import com.midvi.entities.Products;
import com.midvi.entities.User;

/**
 * Session Bean implementation class PanierManager
 */
@Stateless
@LocalBean
@Path("/panier")
public class PanierManager implements PanierManagerRemote, PanierManagerLocal {
	@PersistenceContext(unitName= "EcommerceEJB")
	EntityManager em;
	@Inject
	 private CartProductManagerLocal cartManager;
	@Inject
	private ProductManagerLocal metier;
    public PanierManager() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addPanier(Panier p, User user) {
		// TODO Auto-generated method stub
		em.persist(p);
		p.setUser(user);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getpanieruser/{id}")
	@Override
	public Panier getPanierByUser(@PathParam("id")Long id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Panier> q = cb.createQuery(Panier.class);
		Root<Panier> c = q.from(Panier.class);
		q.select(c).where(cb.equal(c.get("user"),user));
		
		List<Panier> p = em.createQuery(q).getResultList();
		
		return p.get(0);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getpanier/{email}")
	@Override
	public Panier getPanierByUser(@PathParam("email")String email) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT u FROM User u where u.email ='"+email+"'");
		
		User user = (User) query.getSingleResult();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Panier> q = cb.createQuery(Panier.class);
		Root<Panier> c = q.from(Panier.class);
		q.select(c).where(cb.equal(c.get("user"),user));
		
		List<Panier> p = em.createQuery(q).getResultList();
		
		return p.get(0);
	}
	@Override
	public Panier addProducPanier(Panier p1, int qte, Long id) {
		// TODO Auto-generated method stub
		
		Panier panier = em.find(Panier.class, p1.getId());
		//panier.getCartproduit().add(p);
		//em.persist(p);
		CartProduct cc;boolean  flag = false;
		for(CartProduct c : panier.getCartproduit())
		{
			for(Products ps : c.getProducts() ) {
				if(ps.getId().equals(id)) {
				 c.setQuantite(c.getQuantite()+qte);flag=true;
				}
			}
		}
		if(!flag) {
			CartProduct p = new CartProduct();
			p.getProducts().add(metier.getProduct(id));
			p.setQuantite(qte);
			em.persist(p);
			panier.getCartproduit().add(p);
		}
		else {
			
		}
		/*
		 * int index = 0 ; for(Products pp : p.getProducts()) {
		 * if(pp.getId().equals(id)) { index = p.getProducts().lastIndexOf(pp);
		 * 
		 * }
		 * 
		 * } CartProduct cart =
		 * cartManager.getCartByProduct(p.getProducts().get(index).getId());
		 */
		em.merge(panier);
		return panier;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPanier/{idP}/{qte}/{id}")
	@Override
	public Panier addProducPanierByid(@PathParam("idP")Long idP,
			@PathParam("qte")int qte,
			@PathParam("id") Long id) 
	{
		// TODO Auto-generated method stub
		
				Panier panier = em.find(Panier.class,idP);
				//panier.getCartproduit().add(p);
				//em.persist(p);
				CartProduct cc;boolean  flag = false;
				for(CartProduct c : panier.getCartproduit())
				{
					for(Products ps : c.getProducts() ) {
						if(ps.getId().equals(id)) {
						 c.setQuantite(c.getQuantite()+qte);flag=true;
						}
					}
				}
				if(!flag) {
					CartProduct p = new CartProduct();
					p.getProducts().add(metier.getProduct(id));
					p.setQuantite(qte);
					em.persist(p);
					panier.getCartproduit().add(p);
				}
				else {
					
				}
				/*
				 * int index = 0 ; for(Products pp : p.getProducts()) {
				 * if(pp.getId().equals(id)) { index = p.getProducts().lastIndexOf(pp);
				 * 
				 * }
				 * 
				 * } CartProduct cart =
				 * cartManager.getCartByProduct(p.getProducts().get(index).getId());
				 */
				em.merge(panier);
				return panier;
		
	}
	
   

}
