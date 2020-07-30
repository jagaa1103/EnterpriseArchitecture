package edu.mum.service;

import java.util.List;

import edu.mum.domain.Grooups;
import edu.mum.domain.UserCredentials;
 
public interface GroupService {

	public void save(Grooups group);
	public void update(Grooups group);
	public List<Grooups> findAll();
 }
