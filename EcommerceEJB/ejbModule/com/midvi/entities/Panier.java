package com.midvi.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


@Entity

public class Panier implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_panier")
	private Long id;
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<CartProduct> cartproduit;
	
	public List<CartProduct> getCartproduit() {
		return cartproduit;
	}
	public void setCartproduit(List<CartProduct> cartproduit) {
		this.cartproduit = cartproduit;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Panier() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
