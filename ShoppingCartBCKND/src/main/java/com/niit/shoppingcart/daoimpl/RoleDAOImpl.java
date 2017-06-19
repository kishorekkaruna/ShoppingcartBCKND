package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.RoleDAO;
import com.niit.shoppingcart.domain.Role;
import com.niit.shoppingcart.domain.User;

@Repository("RoleDAO")
@Transactional
public class RoleDAOImpl implements RoleDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public void save(Role role) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(role);
		
	}

	
	public void update(Role role) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(role);
	}

	
	public Role getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		String hql = "from User where id ='" + userId + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) (query).list();

		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}
		return null;
	}

	
	public Role getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		String hql = "from User where name ='" + userName + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) (query).list();

		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}
		return null;
	}
	
	
	public Role getUserByUserMailId(String userMailId) {
		// TODO Auto-generated method stub
		String hql = "from Role where email ='" + userMailId + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Role> listRole = (List<Role>) (query).list();

		if (listRole != null && !listRole.isEmpty()) {
			return listRole.get(0);
		}

		return null;
	}


	
	public void deleteByUserId(String userId) {
		// TODO Auto-generated method stub
		User roleToDelete = new User();
		roleToDelete.setId(userId);
		sessionFactory.getCurrentSession().delete(roleToDelete);

	}

}
