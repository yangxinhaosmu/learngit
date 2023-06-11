package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ParameterTest {

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("root");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("root","123");
        System.out.println(user);
    }

    @Test
    public void testinsertuser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"root3","123456",33,"女","1234@qq.com");
        mapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("root","123");
        System.out.println(user);
    }
}
