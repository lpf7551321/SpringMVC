package com.netease.dao;

import com.netease.bean.User;

/**
 * Created by miracler on 4/17/16.
 */
public interface IUserDAO {
    int insert(User user);
    int deleteById(int id);
    int updateById(User user);
    User selectById(int id);
}
