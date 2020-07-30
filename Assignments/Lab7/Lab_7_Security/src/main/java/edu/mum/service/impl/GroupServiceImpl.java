package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GroupDao;
import edu.mum.domain.Grooups;
import edu.mum.service.GroupService;

@Service
@Transactional 
public class GroupServiceImpl implements GroupService {
	
 	@Autowired
	private GroupDao groupDao;

//  	@PreAuthorize("hasRole('ROLE_ADMIN')")
  	public void save(Grooups group) {		
  		groupDao.save(group);
	}
  	
  	public void update(Grooups group) {		
  		groupDao.update(group);
	}
  	
	public List<Grooups> findAll() {
		return (List<Grooups>)groupDao.findAll();
	}

 
}
