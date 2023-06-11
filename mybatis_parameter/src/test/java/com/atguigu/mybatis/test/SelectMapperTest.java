package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        PageHelper.startPage(1,4);
        List<User> list = mapper.getAllUser();
        PageInfo<User>pageInfo=new PageInfo<>(list,5);
        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> user = mapper.getUserByIdToMap(2);
        System.out.println(user);

    }
}
