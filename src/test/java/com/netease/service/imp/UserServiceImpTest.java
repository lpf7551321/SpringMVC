package com.netease.service.imp;

import com.netease.AbstractTest;
import com.netease.bean.User;
import com.netease.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Created by miracler on 4/17/16.
 */
public class UserServiceImpTest extends AbstractTest{

    @Resource(name = "userService")
    IUserService userService;

    @Test(priority = 1)
    @Rollback(false)
    public void save(){
        User user =new User();
        user.setName("testUser");
        user.setAge(100);
        userService.save(user);
        Assert.assertEquals(true,true);
    }
}
