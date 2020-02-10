package edu.ustb.service;

public interface FavoriteService {
	//判断是否已经存在收藏对象
	public boolean isFavorite(String rid, int uid);
	//增加收藏对象
	public void add(String rid, int uid);
}
