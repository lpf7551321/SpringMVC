package com.netease.service;

import com.netease.bean.User;

/**
 * Created by miracler on 4/17/16.
 */
public interface IUserService {
    int save(User user);
    int deleteById(int id);
    int updateById(User user);
    User findById(int id);
}
