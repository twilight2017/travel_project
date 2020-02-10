/**
 * 
 */
package edu.ustb.service.impl;

import java.util.List;

import edu.ustb.dao.CategoryDao;
import edu.ustb.dao.impl.CategoryDaoImpl;
import edu.ustb.domain.Category;
import edu.ustb.service.CategoryService;

/**
 * @author 郭真铃
 * @功能
 * @日期 2019年7月17日
 * @类名 CategoryServiceImpl
 */
public class CategoryServiceImpl implements CategoryService {
	private CategoryDao cdao=new CategoryDaoImpl();
	@Override
	public List<Category> findAllCategory() {
			return cdao.findAllCategory();
	}

}
