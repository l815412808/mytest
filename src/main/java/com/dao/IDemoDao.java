package com.dao;
import com.entity.*;
import  java.util.*;
public interface IDemoDao {
    Demo selectByPrimaryKey(Integer did);
    int deleteByPrimaryKey(Integer did);
    int insertSelective(Demo d);
    int insert(Demo d);
    int updateByPrimaryKeySelective(Demo d);
    int updateByPrimaryKey(Demo d);
    List<Demo> selectAll();
}
