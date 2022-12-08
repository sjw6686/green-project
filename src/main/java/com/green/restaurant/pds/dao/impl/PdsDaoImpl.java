package com.green.restaurant.pds.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.restaurant.pds.dao.PdsDao;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao {
	@Autowired
	private SqlSession sqlSession;
	
}
