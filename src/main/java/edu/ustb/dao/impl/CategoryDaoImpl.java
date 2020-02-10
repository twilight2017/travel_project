/**
 * 
 */
package edu.ustb.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.CategoryDao;
import edu.ustb.domain.Category;
import edu.ustb.util.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao {
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	
	@Override
	public List<Category> findAllCategory() {
		String sql="select * from tab_category";
		return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}
	@Override
	public Category findByCid(int cid)
	{
			Category cat=null;
			String sql="select * from tab_category where cid=?";
			
			try {
				cat= template.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class),cid);
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cat;
		
	}
}
