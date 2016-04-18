package com.netease.service.imp;

import com.netease.AbstractTest;
import com.netease.bean.User;
import com.netease.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by miracler on 4/17/16.
 */
public class UserServiceImpTest extends AbstractTest{

    @Autowired
    IUserService userService;
    static final int USER_ID=2;

    @Test(priority = 1)
    @Rollback(true)
    public void save(){
        User user =new User();
        user.setName("testUser");
        user.setAge(100);
        userService.save(user);
        Assert.assertEquals(true,true);
    }
    @Test(priority = 2)
    @Rollback(true)
    public void findById(){
        User user=userService.findById(USER_ID);
        Assert.assertEquals(user.getId(),USER_ID);
    }


}
