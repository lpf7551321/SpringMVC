package com.netease.controller;

import com.netease.bean.User;
import com.netease.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by miracler on 4/17/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/form")
    public String form(ModelMap model){
        return "formViewer";
    }

    @RequestMapping("/success")
    public String success(ModelMap model,@RequestParam String name,@RequestParam int age){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        model.addAttribute("user",user);
        model.addAttribute("message","add");
        System.out.println(user.getName());
        userService.save(user);
        return "successResult";
    }
    @RequestMapping("/find")
    public String find(ModelMap model,@RequestParam int id){
        User user=userService.findById(id);
        model.addAttribute("user",user);
        model.addAttribute("message","find");
        return "successResult";
    }
    @RequestMapping("/update")
    public String update(ModelMap model,@RequestParam Integer id,@RequestParam String name,@RequestParam Integer age){
        User newUser=new User();
        if (null!=id){
            newUser.setId(id);
        }
        if(null!=name){
            newUser.setName(name);
        }
        if (null!=age){
            newUser.setAge(age);
        }
        userService.updateById(newUser);
        model.addAttribute("message","update");
        model.addAttribute("user",newUser);
        return "successResult";
    }
    @RequestMapping("/delete")
    public String delete(ModelMap model,@RequestParam int id){
        User user=userService.findById(id);
        userService.deleteById(id);
        model.addAttribute("user",user);
        model.addAttribute("message","delete");
        return "successResult";
    }
}
