package com.netease.service.imp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.netease.AbstractTest;
import com.netease.bean.User;
import com.netease.dao.IUserDAO;
import com.netease.service.IUserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by miracler on 4/17/16.
 */
public class UserServiceImpTest extends AbstractTest{

    @Mock
    IUserDAO userDAO;

    @InjectMocks
    UserServiceImp userServiceImp;

    private static final int USER_ID=1;
    private static final String USER_NAME="xyy";
    private static final int USER_AGE=17;

    User user;
    @BeforeTest
    public void setup(){
        MockitoAnnotations.initMocks(this);
        user=new User();
        user.setId(USER_ID);
        user.setName(USER_NAME);
        user.setAge(USER_AGE);
        when(userDAO.insert(user)).thenReturn(user.getId());
        when(userDAO.selectById(USER_ID)).thenReturn(user);
        when(userDAO.updateById(user)).thenReturn(user.getId());
        when(userDAO.deleteById(USER_ID)).thenReturn(user.getId());

    }



    @Test(priority = 1)
    @Rollback(true)
    public void testSave(){
        int id=userServiceImp.save(user);
        Assert.assertEquals(id,user.getId());
    }

    @Test(priority = 2)
    @Rollback(true)
    public void testUpdateById(){
        int id=userServiceImp.updateById(user);
        Assert.assertEquals(id,user.getId());

    }

    @Test(priority = 3)
    @Rollback(true)
    public void testFindById(){
        User u=userServiceImp.findById(user.getId());
        Assert.assertEquals(u.getName(),user.getName());

    }

    @Test(priority = 99)
    @Rollback(true)
    public void testDeleteById(){
        int id=userServiceImp.deleteById(user.getId());
        Assert.assertEquals(id,user.getId());

    }





}
