package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUserByUsername(String username);

    User checkLogin(String username,String password);
    /**
     *
     */
    int insertUser(User user);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);


}
