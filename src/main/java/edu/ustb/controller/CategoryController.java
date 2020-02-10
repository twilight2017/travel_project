package edu.ustb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ustb.domain.Category;
import edu.ustb.service.CategoryService;
import edu.ustb.service.impl.CategoryServiceImpl;
import edu.ustb.vo.ResultInfo;

/**
 * Servlet implementation class category
 */
@WebServlet("/category/*")
public class CategoryController extends BaseServlet {
    private CategoryService cservice=new CategoryServiceImpl();
    /**
     * 显示导航栏里所有类别
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void  findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    	//得到所有旅游类别
    	List<Category> categoryList=cservice.findAllCategory();
    	
    	writeValue(categoryList,response);
//    	request.getRequestDispatcher(request.getContextPath()+"/route/pageQueryByRouteName").forward(request, response);
    	
    }
    

}
