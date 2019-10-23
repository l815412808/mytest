package com;
import java.util.*;
import com.entity.*;
import com.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class TestBean {
    /*
    * junit4测试
    * */
    @Autowired
    private  IDemoService ids;

    @Transactional   //事务
    @Rollback       //回滚
    @Test
    public  void test1(){
        List<Demo> dlist=ids.selectAll();
         for(Demo d: dlist){
                    System.out.println(d);
                 }
        System.out.println("dlist-size="+dlist.size());
     }
}
