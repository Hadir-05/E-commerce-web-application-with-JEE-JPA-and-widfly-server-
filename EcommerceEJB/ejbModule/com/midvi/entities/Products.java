package com.midvi.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Products
 *
 */
@Entity
@Table(name = "produit")
public class Products implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nom")
	private String libelle;
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		Categorie = categorie;
	}

	private String Categorie;
	public Products(Long id) {
		super();
		this.id = id;
	}

	private String description;
	private double prix;
	private int quantite;
	private static final long serialVersionUID = 1L;

	public Products() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Products(String libelle,String Categorie, String description, double prix, int quantite) {
		super();
		this.libelle = libelle;
		this.Categorie=Categorie;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}   
	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
   
}
