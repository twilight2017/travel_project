package edu.ustb.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.ustb.dao.CategoryDao;
import edu.ustb.dao.RouteDao;
import edu.ustb.dao.RouteImgDao;
import edu.ustb.dao.SellerDao;
import edu.ustb.dao.impl.CategoryDaoImpl;
import edu.ustb.dao.impl.RouteDaoImpl;
import edu.ustb.dao.impl.RouteImgDaoImpl;
import edu.ustb.dao.impl.SellerDaoImpl;
import edu.ustb.domain.Category;
import edu.ustb.domain.Route;
import edu.ustb.domain.RouteImg;
import edu.ustb.domain.Seller;
import edu.ustb.service.RouteService;
import edu.ustb.vo.PageBean;

public class RouteServiceImpl implements RouteService{
	
	RouteDao routeDao=new RouteDaoImpl();
	private RouteImgDao routeImgDao=new RouteImgDaoImpl();
	private SellerDao sellerDao=new SellerDaoImpl();
	private CategoryDao catDao=new CategoryDaoImpl();
	
	//查询详情路线
	 @Override
	 public  Route findOne(int rid){
		 //根据rid找路线
		 Route route=routeDao.findOne(rid);
		 //根据route的id查询图片集合信息
		 List<RouteImg> routeImgList=routeImgDao.findByRid(rid);
		 //将集合设置到route对象
		 route.setRouteImgList(routeImgList);
		 //根据route的sid查询商家对象
		 Seller seller=sellerDao.findById(route.getSid());
		 route.setSeller(seller);
		 //跟据route的cid查詢Category對象
		 Category cat=catDao.findByCid(route.getCid());
		 route.setCategory(cat);
		 return route;
	 }
	
	//模糊查询旅游路线单页
	public void getSplitPage(int cid,String rname,PageBean pb) {
		routeDao.getSplitPage(cid, rname, pb);
	}
	//计算符合条件的总行数
	public int getRouteNum(int cid,String rname) {
		return routeDao.getRouteNum(cid, rname);
	}
	//封装pagebean
	public PageBean<Route> getQuery(int cid,String rname,int currentPage,HttpServletRequest request){
		PageBean<Route> pb=new PageBean<Route>();
		
		
		if(request.getParameter("currentPage")!=null&&!"".equals(request.getParameter("currentPage"))){
			//接收当前页面上的页数
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		if(currentPage==0){
			currentPage=1;
		}
		pb.setTotalCount(getRouteNum(cid, rname));
		if(currentPage>pb.getTotalPage()){
			currentPage=pb.getTotalPage();
		}
		pb.setCurrentPage(currentPage);
		getSplitPage(cid, rname, pb);
		
		return pb;
	}
	@Override
	public List<Route> findfavoriteAll(int uid){
		return routeDao.findfavoriteAll(uid);
	}
	
}
