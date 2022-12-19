
package com.green.admin.category.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.admin.category.dao.AdminCategoryDao;
import com.green.admin.category.vo.AdminCategoryVo;

@Repository("admincategoryDao")
public class AdminCategoryDaoImpl implements AdminCategoryDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertCategory(AdminCategoryVo categoryVo) {
		
		sqlSession.insert("AdminCategory.insertCategory", categoryVo);
		
	}

	@Override
	public void deleteCategory(String category_name) {
		System.out.println("dao>>>>>>>>>>>>>>>>>category_name: " + category_name);
		sqlSession.delete("AdminCategory.DeleteCategory", category_name);
		
		
	}

	@Override
	public List<AdminCategoryVo> getCategoryList() {
		
		List<AdminCategoryVo> CategoryList = sqlSession.selectList("AdminCategory.CategoryList");
		
		return CategoryList;
	}

	@Override
	public List<AdminCategoryVo> CategoryRestaurant(String category_name) {
	
		List<AdminCategoryVo> categoryVo = sqlSession.selectList("AdminCategory.CategoryRestaurant", category_name);

		return categoryVo;
	}
	
}
