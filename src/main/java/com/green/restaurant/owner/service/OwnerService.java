package com.green.restaurant.owner.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface OwnerService {
	void enrollRestorant(HashMap<String, Object> map, HttpServletRequest request);
}
