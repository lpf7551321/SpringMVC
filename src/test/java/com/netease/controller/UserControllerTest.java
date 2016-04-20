package com.netease.controller;

import static org.mockito.Mockito.when;


import com.netease.AbstractTest;
import com.netease.bean.User;
import com.netease.service.imp.UserServiceImp;
import junit.framework.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by miracler on 4/20/16.
 */
public class UserControllerTest extends AbstractTest {

    @Mock
    UserServiceImp userServiceImp;

    @InjectMocks
    UserController userController;

    private MockMvc mockMvc;

    private static final int USER_ID=1;
    private static final String USER_NAME="xyy";
    private static final int USER_AGE=17;

    User user;

    @BeforeTest
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(userController).build();

        user=new User();
        user.setId(USER_ID);
        user.setName(USER_NAME);
        user.setAge(USER_AGE);

        when(userServiceImp.save(user)).thenReturn(user.getId());
        when(userServiceImp.findById(user.getId())).thenReturn(user);
        when(userServiceImp.updateById(user)).thenReturn(user.getId());
        when(userServiceImp.deleteById(user.getId())).thenReturn(user.getId());


    }

    @Test(priority = 1)
    @Rollback(true)
    public void testSave(){
        try{
            ResultActions resultActions=mockMvc.perform(MockMvcRequestBuilders.post("/user/form"));
            resultActions.andExpect(MockMvcResultMatchers.view().name("formViewer"));
        }catch (Exception e){
            Assert.fail("save fail");
        }

    }
    @Test(priority = 2)
    @Rollback(true)
    public void testSuccess(){
        try{
            ResultActions resultActions=mockMvc.perform(MockMvcRequestBuilders.get("/user/success?name=xyy&age=17"));
            resultActions.andExpect(MockMvcResultMatchers.view().name("successResult"));
        }catch (Exception e){
            Assert.fail("success fail");
        }

    }
    @Test(priority = 3)
    @Rollback(true)
    public void testFind(){
        try{
            ResultActions resultActions=mockMvc.perform(MockMvcRequestBuilders.post("/user/find?id=1"));
            resultActions.andExpect(MockMvcResultMatchers.view().name("successResult"));
        }catch (Exception e){
            Assert.fail("save fail");
        }

    }
    @Test(priority = 4)
    @Rollback(true)
    public void testUpdate(){
        try{
            ResultActions resultActions=mockMvc.perform(MockMvcRequestBuilders.post("/user/update?id=1&name=xyy&age=17"));
            resultActions.andExpect(MockMvcResultMatchers.view().name("successResult"));
        }catch (Exception e){
            Assert.fail("save fail");
        }

    }

    @Test(priority = 99)
    @Rollback(true)
    public void testDelete(){
        try{
            ResultActions resultActions=mockMvc.perform(MockMvcRequestBuilders.post("/user/delete?id=1"));
            resultActions.andExpect(MockMvcResultMatchers.view().name("successResult"));
        }catch (Exception e){
            Assert.fail("save fail");
        }

    }

}
