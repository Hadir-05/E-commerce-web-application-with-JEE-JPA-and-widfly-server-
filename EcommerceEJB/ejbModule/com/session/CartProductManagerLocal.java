package com.session;

import javax.ejb.Local;

import com.midvi.entities.CartProduct;

@Local
public interface CartProductManagerLocal {

	public void addCart(CartProduct c,int qte);
	public CartProduct getCartByProduct(Long id);

}
