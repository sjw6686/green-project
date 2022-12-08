package com.green.restaurant.pds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.restaurant.pds.dao.PdsDao;
import com.green.restaurant.pds.service.PdsService;

@Service("pdsService")
public class PdsServiceImpl implements PdsService {
	@Autowired
	private PdsDao pdsDao;
}
