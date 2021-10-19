package com.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.midvi.entities.Products;

/**
 * Session Bean implementation class ProductManager
 */
@Stateless
@LocalBean
@Path("/produits")
public class ProductManager implements ProductManagerRemote, ProductManagerLocal {
	@PersistenceContext(unitName= "EcommerceEJB")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ProductManager() {
        // TODO Auto-generated constructor stub
    }
    //@GET
    //@Path("/addp_p/{produit}")
	//@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)

	@Override
	public void addProduct(Products p) {
		em.persist(p);
		// TODO Auto-generated method stub
		
	}
	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	@Path("/products")
	@Override
	public List<Products> getProducts(){
		Query req =em.createQuery( "SELECT p FROM Products p");
		return req.getResultList();
	}
	//localhost:8080/EcommerceEJB/ecommerce/
	@GET
	@Path("/getproduit_id/{idp}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	@Override
	public Products getProduct(@PathParam(value="idp")Long id) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("SELECT p FROM Products p where p.id="+id);
		return (Products)req.getResultList().get(0);
	}
	//@GET
	//@Path("/editproduit_id_p/{idp}/{produit}")
	//@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	@Override
	public Products editProducts(Long id, Products p) {
		Products produit = em.find(Products.class, id);
		produit.setDescription(p.getDescription());
		produit.setLibelle(p.getLibelle());
		produit.setPrix(p.getPrix());
		produit.setQuantite(p.getQuantite());
		em.merge(produit);
		return produit;
	}
	@GET
	@Path("/deleteproduit_id/{idp}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	@Override
	public void deleteProduct(@PathParam(value="idp")Long id) {
		Products p = em.find(Products.class, id);
		if(p!=null)
			em.remove(p);
		// TODO Auto-generated method stub
		
	}
	@GET
	@Path("/searchp_libell/{nom_produit}")
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Products> Search(@PathParam(value="nom_produit")String libelle) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT p FROM Products p WHERE p.libelle='"+libelle+"'");
		return q.getResultList();
	}



}
