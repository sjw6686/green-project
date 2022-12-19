package com.green.admin.category.Service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.admin.category.Service.AdminCategoryService;
import com.green.admin.category.dao.AdminCategoryDao;
import com.green.admin.category.vo.AdminCategoryVo;

@Service("admincategoryService")
public class AdminCategoryServiceimpl implements AdminCategoryService {

	@Autowired
	private AdminCategoryDao dao;
	
	// boolean ���엯�쑝濡� 蹂��닔�깮�꽦�븯�뿬 return�쓣 true or false濡� �굹���깂
	/*public boolean addCategory(CategoryVo categoryVo) {
		Integer n =Integer.parseInt(
		// �벑濡앸맂 移댄뀒怨좊━ 紐낆씠 �엳�뒗吏�
		if(n != 0) {
			// �씠誘� 議댁옱�븯�뒗 移댄뀒怨좊━媛� �엳�쑝硫� �떎�뙣
			return false;
		}
		// 移댄뀒怨좊━媛� 議댁옱�븯吏� �븡�쑝硫� 異붽�
		dao.insertCategory(categoryVo);
		
		return true;
	}*/
	
	// 移댄뀒怨좊━ 紐⑤몢 遺덈윭�삤湲�
	public List<AdminCategoryVo> getCategoryList(){
		
		List<AdminCategoryVo> categoryList = dao.getCategoryList();
		
		return categoryList;
	}

	@Override
	public void insertCategory(AdminCategoryVo categoryVo) {
		
		dao.insertCategory(categoryVo);
		
	}

	@Override
	public void deleteCategory(String category_name) {
		System.out.println("service>>>>>>>>>>>>>>>>>category_name: " + category_name);
		dao.deleteCategory(category_name);
		
	}

	@Override
	public List<AdminCategoryVo> CategoryRestaurant(String category_name) {
	
		List<AdminCategoryVo> categoryVo = dao.CategoryRestaurant(category_name);
		
		return categoryVo;
	}

}
