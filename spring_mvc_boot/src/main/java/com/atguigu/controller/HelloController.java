package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/fim")
    public String hello(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password"+password);
        return "index";
    }
    @RequestMapping("/param")
    @ResponseBody
    public String getParam(@RequestParam(value = "username") String username,
                           String password,
                           @CookieValue("JSESSIONID") String jsessionId){
        System.out.println("jsessionId:"+jsessionId);
        System.out.println("username:"+username+",password"+password);
        return "OK";
    }

    @RequestMapping("/param/pojo")
    @ResponseBody
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
    @RequestMapping("/test/mav")
    public ModelAndView testMav(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("testRequestScope","hello,mav");
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,model");
        return "success";
    }
    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public Map<String,Object>testResJson(){
        Map<String, Object> map = new HashMap<>();
        map.put("101",1);
        map.put("102",2);
        return map;
    }

}
