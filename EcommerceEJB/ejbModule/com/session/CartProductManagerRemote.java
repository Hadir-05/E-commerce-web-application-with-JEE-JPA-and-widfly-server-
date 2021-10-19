package com.session;

import javax.ejb.Remote;

import com.midvi.entities.CartProduct;

@Remote
public interface CartProductManagerRemote {
	public void addCart(CartProduct c,int qte);
	public CartProduct getCartByProduct(Long id);


}
