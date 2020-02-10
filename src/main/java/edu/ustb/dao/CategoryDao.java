/**
 * 
 */
package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.Category;

/**
 * @author 郭真铃
 * @功能
 * @日期 2019年7月17日
 * @类名 CategoryDao
 * @version 1.0
 */
public interface CategoryDao {
	public List<Category> findAllCategory();
	//跟据cid找category
	public Category findByCid(int cid);
}
