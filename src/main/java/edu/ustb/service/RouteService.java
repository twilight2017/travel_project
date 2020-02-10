package edu.ustb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.ustb.domain.Route;
import edu.ustb.vo.PageBean;

public interface RouteService {
	//模糊查询旅游路线单页
	public void getSplitPage(int cid,String rname,PageBean pb);
	//计算符合条件的总行数
	public int getRouteNum(int cid,String rname);
	//封装pagebean
	public PageBean<Route> getQuery(int cid,String rname,int currentPage,HttpServletRequest request);
	//根据rid找到一条route记录
	Route findOne(int rid);
	List<Route> findfavoriteAll(int uid);
}
