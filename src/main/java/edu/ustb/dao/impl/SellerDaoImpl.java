package edu.ustb.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.SellerDao;
import edu.ustb.domain.RouteImg;
import edu.ustb.domain.Seller;
import edu.ustb.util.JDBCUtils;

public class SellerDaoImpl implements SellerDao{

	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	@Override 
public Seller findById(int id)
{
	Seller seller=null;
	String sql="select * from tab_seller where sid=?";
	
	try {
		seller= template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class),id);
	} catch (DataAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return seller;
	
}
}
