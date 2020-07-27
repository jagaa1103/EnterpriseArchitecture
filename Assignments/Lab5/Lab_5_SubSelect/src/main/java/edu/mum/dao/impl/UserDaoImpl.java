package edu.mum.dao.impl;

 

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

import javax.persistence.Query;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class );
		}

 	public List<User> findAllJoinFetch() {
		Query query =  entityManager.createQuery("SELECT u FROM User AS u JOIN FETCH u.boughtItems AS b");
		List<User> users =  query.getResultList();
		  return users;
	}


 }