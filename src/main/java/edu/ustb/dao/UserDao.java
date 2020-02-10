package edu.ustb.dao;

import edu.ustb.domain.User;

public interface UserDao {
	 /**
     * 用户保存
     * @param user
     */
    public int save(User user);
    
   User findByUserName(String userName);
   
   User findByCode(String code);

   void updateStatus(User user);
   User findByUsernameAndPassword(String username, String password); 
}
