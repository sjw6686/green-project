package com.green.admin.category.dao;

import java.util.HashMap;
import java.util.List;

import com.green.admin.category.vo.AdminCategoryVo;

public interface AdminCategoryDao {
	
	public List<AdminCategoryVo> getCategoryList();
	public void insertCategory(AdminCategoryVo categoryVo);
	void deleteCategory(String category_name);

	List<AdminCategoryVo> CategoryRestaurant(String category_name);
}
