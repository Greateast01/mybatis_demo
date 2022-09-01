package com.swd.mapper;


import com.swd.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectAll();

    User getByUsername(String username);

    User checkLogin(String username,String password);

    User checkLoginByMap(Map<String,Object> map);

    User checkLoginByParam(@Param("username") String username, @Param("password") String password );

    int insertUser(User user);

    Map<String,Object> getUserToMap(@Param("id") Integer id);


    List<Map<String,Object>> getAllUserToListMap();

    @MapKey("id")
    Map<String,Object> getAllUserToMap();

    List<User> getUserByLike(@Param("username") String username);

    int deleteMore(@Param("ids") String ids);
}
