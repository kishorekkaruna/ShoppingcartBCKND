package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Cart;

public interface CartDAO {
	public List<Cart> list();
	public List<Cart> list(String mailid);
	public void saveOrUpdate(Cart cart);
	public Cart getByCartId(String cartId);
	public Cart getByCartName(String cartName);
	public void deleteByCartId(String cartId);
	public void deleteByCartName(String cartName);
	public void deleteByProductName(String productName);
	public boolean itemAlreadyExist(String mailid, String productId, boolean k);
	public Cart getByUserandProduct(String userId, String productId);
	public Long getTotalAmount(String id);
	public void save(Cart cart);
	
}
