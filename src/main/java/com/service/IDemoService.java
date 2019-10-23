package com.service;
import com.entity.*;
import java.util.*;
public interface IDemoService {
    Demo selectByPrimaryKey(Integer did);
    int deleteByPrimaryKey(Integer did);
    int insertSelective(Demo d);
    int updateByPrimaryKeySelective(Demo d);
    List<Demo> selectAll();
    int insert(Demo d);
    int updateByPrimaryKey(Demo d);
}
