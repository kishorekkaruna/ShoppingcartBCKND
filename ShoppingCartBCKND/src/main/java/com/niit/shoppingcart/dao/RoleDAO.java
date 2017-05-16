package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.domain.Role;

public interface RoleDAO {

	public void save(Role user);
	public void update(Role user);
	public Role getUserByUserId(String userId);
	public Role  getUserByUserMailId(String userMailId);
	public Role getUserByUserName(String userName);
	public void deleteByUserId(String userId);
	
}
