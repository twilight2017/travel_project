package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.Favorite;
import edu.ustb.domain.Route;
import edu.ustb.vo.PageBean;

public interface RouteDao {
	//模糊查询旅游路线单页
	public void getSplitPage(int cid,String rname,PageBean<Route> pb);
	//计算符合条件的总行数
	public int getRouteNum(int cid,String rname);
	//根据rid找到route记录
	public Route findOne(int rid);
	public List<Route> findfavoriteAll(int uid);
}
