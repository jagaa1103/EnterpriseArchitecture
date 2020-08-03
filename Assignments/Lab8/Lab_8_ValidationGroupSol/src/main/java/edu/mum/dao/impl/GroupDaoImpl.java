package edu.mum.dao.impl;

 

import org.springframework.stereotype.Repository;

import edu.mum.dao.GroupDao;
import edu.mum.domain.Grooups;


@Repository
public class GroupDaoImpl extends GenericDaoImpl<Grooups> implements GroupDao {

	public GroupDaoImpl() {
		super.setDaoType(Grooups.class );
		}

 
 }