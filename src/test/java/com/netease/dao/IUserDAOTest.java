package com.netease.dao;

import com.netease.AbstractTest;
import com.netease.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by miracler on 4/17/16.
 */
public class IUserDAOTest extends AbstractTest{

    @Autowired
    IUserDAO userDAO;

    private static final int USER_ID=1;
    private static final String USER_NAME="xyy";
    private static final int USER_AGE=17;

    User user;
    @BeforeTest
    public void setup(){
        user=new User();
        user.setId(USER_ID);
        user.setName(USER_NAME);
        user.setAge(USER_AGE);

    }

    @Test(priority = 1)
    @Rollback(true)
    public void testInsert(){
        int id=userDAO.insert(user);
        Assert.assertEquals(id,USER_ID);
    }

    @Test(priority = 3)
    @Rollback(true)
    public void testSelectById(){
        User user=userDAO.selectById(USER_ID);
        Assert.assertEquals(user.getId(),USER_ID);
    }
    @Test(priority = 99)
    @Rollback(true)
    public void testUpdateById(){
        int id=userDAO.updateById(user);
        Assert.assertEquals(id,USER_ID);
    }

    @Test(priority = 2)
    @Rollback(true)
    public void testDeleteById(){
        int id=userDAO.deleteById(USER_ID);
        Assert.assertEquals(id,USER_ID);
    }


}
