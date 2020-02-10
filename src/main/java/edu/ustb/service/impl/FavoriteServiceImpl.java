package edu.ustb.service.impl;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.impl.FavoriteDaoImpl;
import edu.ustb.domain.Favorite;
import edu.ustb.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService{
	
	private FavoriteDao favoriteDao = new FavoriteDaoImpl();
	//判断是否已经存在收藏对象
    @Override
    public boolean isFavorite(String rid, int uid) {

        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite != null;//如果对象有值，则为true，反之，则为false
    }
    //增加收藏对象
    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }
}
