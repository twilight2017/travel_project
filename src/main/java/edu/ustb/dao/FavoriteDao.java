package edu.ustb.dao;

import edu.ustb.domain.Favorite;

public interface FavoriteDao {
	//通过用户id与路线id查找收藏对象
	public Favorite findByRidAndUid(int rid, int uid);
	//通过路线id查询个数
	public int findCountByRid(int rid);
	//添加收藏对象
	public void add(int rid, int uid);
}
