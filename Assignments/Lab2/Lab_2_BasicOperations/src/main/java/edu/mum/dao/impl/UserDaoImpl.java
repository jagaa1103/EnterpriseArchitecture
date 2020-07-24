package edu.mum.dao.impl;

 

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.mum.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

import java.util.List;


@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public User findByEmail(String email) {
		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		return (User) query.setParameter("email", email).getSingleResult();
	}


	@Override
	public void save(User user) {
		entityManager.persist(user);
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public User findOne(Long id) {
		return null;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}
}