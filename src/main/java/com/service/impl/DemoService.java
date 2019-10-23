package com.service.impl;
import com.service.IDemoService;

import java.util.*;
import com.entity.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.*;
@Transactional
@MapperScan(basePackages = "com.dao")
@Service("demoService")
public class DemoService implements IDemoService{
   @Autowired
    private IDemoDao idao;
    @Override
    public Demo selectByPrimaryKey(Integer did) {
        return idao.selectByPrimaryKey(did);
    }

    @Override
    public int deleteByPrimaryKey(Integer did) {
        return idao.deleteByPrimaryKey(did);
    }

    @Override
    public int insertSelective(Demo d) {
        return idao.insertSelective(d);
    }

    @Override
    public int updateByPrimaryKeySelective(Demo d) {
        return idao.updateByPrimaryKeySelective(d);
    }

    @Override
    public List<Demo> selectAll() {
        return idao.selectAll();
    }

    @Override
    public int insert(Demo d) {
        return idao.insert(d);
    }

    @Override
    public int updateByPrimaryKey(Demo d) {
        return idao.updateByPrimaryKey(d);
    }
}
