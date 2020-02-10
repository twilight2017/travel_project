package edu.ustb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ustb.domain.Route;
import edu.ustb.domain.User;
import edu.ustb.service.FavoriteService;
import edu.ustb.service.RouteService;
import edu.ustb.service.impl.FavoriteServiceImpl;
import edu.ustb.service.impl.RouteServiceImpl;
import edu.ustb.vo.PageBean;

@WebServlet("/route/*")
public class RouteController extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private RouteService routeService =new RouteServiceImpl();
	private FavoriteService favoriteService=new FavoriteServiceImpl();
    
	
	
	//根据rid查询一个线路
	public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid=Integer.parseInt(request.getParameter("rid"));

		Route route=routeService.findOne(rid);
		writeValue(route,response);
		
	}
	
	public void pageQueryByRouteName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cidStr=request.getParameter("cid");
		String rnameStr=request.getParameter("rname");
		
		int cid = 0;
        if(cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)){
            cid = Integer.parseInt(cidStr);
        }
	    
 		String rname=null;
 		if(rnameStr != null && rnameStr.length() > 0 && !"null".equals(rnameStr)){
 			rname = rnameStr;
        }
 		
 		int currentPage=1;
 		
		PageBean<Route> pb=new PageBean<Route>();
		
		pb=routeService.getQuery(cid,rname,currentPage,request);
		writeValue(pb, response);
	}
	
	 //判断当前登录用户是否收藏过该线路
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if(user == null){
            uid = 0;
        }else{
            uid = user.getUid();
        }
        boolean flag = favoriteService.isFavorite(rid, uid);
        writeValue(flag,response);
    }

    //添加收藏
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if(user == null){
            return ;
        }else{
            uid = user.getUid();
        }
        favoriteService.add(rid,uid);
    }
    public void findfavoriteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();
        //3. 调用service查询PageBean对象
         List<Route> list= routeService.findfavoriteAll(uid);
        //4. 将pageBean对象序列化为json，返回
         writeValue(list,response);

    }
}
