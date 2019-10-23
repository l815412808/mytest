package com.action;
import com.entity.*;
import java.util.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//ajax  跨域问题  解决 CrossOrigin
@CrossOrigin(allowCredentials = "true",maxAge = 3600)
@RestController
public class DemoController {
    @Autowired
    private IDemoService ids;

    @RequestMapping(value="/alldemo",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Demo> alldemo(){
        return ids.selectAll();
    }

    @RequestMapping(value="/onedemo/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Demo onedemo(@PathVariable(value="id") Integer did){
        return ids.selectByPrimaryKey(did);
    }

    @RequestMapping(value="/deldemo/{id}",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer  deldemo(@PathVariable(value="id") Integer did){
        return ids.deleteByPrimaryKey(did);
    }

    @RequestMapping(value="/adddemo")
    public Integer adddemo(Demo demo){
        return ids.insertSelective(demo);
    }

    @RequestMapping(value="/updatedemo",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Integer updatedemo(Demo demo){
        return ids.updateByPrimaryKeySelective(demo);
    }
}
