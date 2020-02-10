package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.RouteImg;

public interface RouteImgDao {
	//根据rid查图片
public List<RouteImg> findByRid(int rid);
}
