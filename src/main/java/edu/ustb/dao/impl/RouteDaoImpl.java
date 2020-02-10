package edu.ustb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.RouteDao;
import edu.ustb.domain.Favorite;
import edu.ustb.domain.Route;
import edu.ustb.util.JDBCUtils;
import edu.ustb.vo.PageBean;

public class RouteDaoImpl implements RouteDao{
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	
	//根据rid找到一条route记录
	@Override
	public Route findOne(int rid){
		Route route=null;
		try{
		String sql="select * from tab_route where rid = ?";
		//根据rid找到一条route记录
		route=template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
		}catch(Exception ex){
			
		}
		
		return route;
	}
	
	//模糊查询旅游路线
	@Override
	public void getSplitPage(int cid,String rname,PageBean<Route> pb){
		List<Route> list=new ArrayList<Route>();
		if(rname != null && rname.length() > 0 && !"null".equals(rname)){
			if(cid != 0){
				String sql = "select * from tab_route where cid=? and rname like ? limit ?,?";
				String str="%"+rname+"%";
				list=template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid,str,(pb.getCurrentPage()-1)*pb.getPageSize(),pb.getPageSize());
			}else{
				String sql = "select * from tab_route where rname like ? limit ?,?";
				String str="%"+rname+"%";
				list=template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),str,(pb.getCurrentPage()-1)*pb.getPageSize(),pb.getPageSize());
			}
			
		}else{
			if(cid != 0){
				String sql = "select * from tab_route where cid=? limit ?,?";
				list=template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid,(pb.getCurrentPage()-1)*pb.getPageSize(),pb.getPageSize());
			}else{
				String sql = "select * from tab_route limit ?,?";
				list=template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),(pb.getCurrentPage()-1)*pb.getPageSize(),pb.getPageSize());
			}
		}
		pb.setList(list);
	}
	
	
	//计算符合条件的总行数
		public int getRouteNum(int cid,String rname){
			int num=0;
			if(rname!=null && !"".equals(cid)&& !"0".equals(cid)){
				if(cid!=0){
					String sql="select count(*) from tab_route where cid=? and rname like ?";
					String str="%"+rname+"%";
					num=template.queryForObject(sql,Integer.class,cid,str);
				}else{
					String sql="select count(*) from tab_route where rname like ?";
					String str="%"+rname+"%";
					num=template.queryForObject(sql,Integer.class,str);
				}
			}else{
				if(cid!=0 ){
					String sql="select count(*) from tab_route where cid=?";
					num=template.queryForObject(sql,Integer.class,cid);
				}else{
					String sql="select count(*) from tab_route ";
					num=template.queryForObject(sql,Integer.class);
				}
			}
			return num;
			
		}
		@Override
		public List<Route> findfavoriteAll(int uid){
		        String sql="SELECT  b.uid,a.rid,a.rname,a.price,a.rimage FROM tab_route a,tab_favorite b WHERE a.rid= b.rid AND b.uid=?";
		        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),uid);
		}
	
}
