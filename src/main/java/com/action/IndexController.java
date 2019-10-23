package com.action;
import java.util.*;
import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@PropertySource(value="classpath:param.properties",encoding = "utf-8")
@RestController
public class IndexController {
    @Value("${app.code}")
    private String code;
    @Autowired
    private  IDemoService ids;

    @RequestMapping(value = "/test" ,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Demo>  test(){
        System.out.println("-----------test code="+code);
        return ids.selectAll();
    }
    //denglu

    @RequestMapping(value="/login",produces ={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public  UserInfo  login(UserInfo u, HttpSession session){
        System.out.println("----login");
        session.setAttribute("userInfo",u);
        return  u;
    }

    @RequestMapping(value="/main",produces ={MediaType.APPLICATION_JSON_UTF8_VALUE})
    public  UserInfo  main(HttpSession session){
        System.out.println("----main");
       Object  obj=  session.getAttribute("userInfo");
       UserInfo  u=(UserInfo)obj;
       System.out.println();
        return u ;
    }

}
