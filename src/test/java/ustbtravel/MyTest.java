package ustbtravel;

import java.util.List;

import org.junit.Test;

import edu.ustb.dao.RouteDao;
import edu.ustb.dao.impl.RouteDaoImpl;
import edu.ustb.domain.Route;
import edu.ustb.service.RouteService;
import edu.ustb.service.impl.RouteServiceImpl;
import edu.ustb.vo.PageBean;

public class MyTest {
	
	RouteDao routeDao=new RouteDaoImpl();
	RouteService routeService=new RouteServiceImpl();
	
	
	//测试取集合方法
	@Test
	public void testGetRoute(){
		String rname="宁夏";
		int cid=0;
		PageBean pb=new PageBean();
		pb.setCurrentPage(1);
		pb.setPageSize(5);
		pb.setTotalCount(6);
		pb.setTotalPage(2);
		List<Route> list=null;
		try {
			routeDao.getSplitPage(cid,rname,pb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pb.getList());
	}
	
	@Test
	public void testGetRouteService(){
		String rname="雪山";
		int cid=0;
		PageBean pb=new PageBean();
		pb.setCurrentPage(7);
		pb.setPageSize(5);
		pb.setTotalCount(6);
		pb.setTotalPage(2);
		List<Route> list=null;
		routeService.getSplitPage(cid,rname,pb);
		System.out.println(pb.getList());
	}
	
	//测试取集合元素方法
		@Test
	public void testGetRouteNum(){
		int num=0;
		String rname="null";
		int cid=0;
		
		List<Route> list=null;
		try {
			num=routeDao.getRouteNum(cid, rname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}
		
		//测试取集合元素方法
		@Test
		public void testGetRouteNumService(){
			int num=0;
			String rname="null";
			int cid=0;
			
			List<Route> list=null;
			num=routeService.getRouteNum(cid, rname);
			System.out.println(num);
		}
}
