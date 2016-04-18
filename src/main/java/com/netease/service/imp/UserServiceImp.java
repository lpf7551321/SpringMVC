package com.netease.service.imp;

import com.netease.bean.User;
import com.netease.dao.IUserDAO;
import com.netease.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by miracler on 4/17/16.
 */

@Service("userService")
public class UserServiceImp implements IUserService {

    IUserDAO userDAO;

    public int save(User user) {
        return userDAO.insert(user);
    }

    public int deleteById(int id) {
        return userDAO.deleteById(id);
    }

    public int updateById(User user) {
        return userDAO.updateById(user);
    }

    public User findById(final int id) {
        return userDAO.selectById(id);
    }


    @Autowired
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
