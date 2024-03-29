package edu.mum.service.impl;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.exception.ValidationExceptionGroup;
import edu.mum.validation.groups.Details;

@Service
@Transactional
public class UserServiceImpl implements edu.mum.service.UserService {

	@Autowired
	private UserDao userDao;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(User user) {
		Boolean validationSuccess =  validate(user, Default.class) ;     
       	if (!validationSuccess)  
       			return;
		userDao.save(user);
	}

	@PreAuthorize("hasAuthority('LIST')")
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@PreAuthorize("hasAuthority('UPDATE')")
	public User update(User user) {
		Boolean validationSuccess =  validate(user, Details.class) ;     
       	if (!validationSuccess)  
       			return user;
		return userDao.update(user);

	}

	public User testRefresh(User user) {
		user.setEmail("Lotta@Doe.com");
		userDao.save(user);
		return user;
	}

 	@PreAuthorize("hasAuthority('READ')")
	public User findOne(Long id) {
		return userDao.findOne(id);
	}

	public Boolean validate(User user, Class<?> group) {
		// Using Hibernate validator...
		javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Object>> errors = validator.validate(user, group);
		Boolean validationSuccess = errors.size() == 0 ? true : false;
		if (!validationSuccess)
			throw new ValidationExceptionGroup(errors);

		/*
		 * for (ConstraintViolation<User> error : errors)
		 * System.out.println(error.getPropertyPath() + " " +error.getMessage());
		 */
		return validationSuccess;
	}

}
