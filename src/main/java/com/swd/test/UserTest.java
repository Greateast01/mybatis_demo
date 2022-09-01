package com.swd.test;

import com.swd.mapper.UserMapper;
import com.swd.pojo.User;
import com.swd.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SuWeiDong
 * @date 2022-08-30 16:24
 */
public class UserTest {
    @Test
    public void testSelectAll() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testGetByUsername(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getByUsername("swd");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("swd","swd123");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","swd");
        map.put("password","swd123");
        User user = userMapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLoginByParam("swd","swd123");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.insertUser(new User(null,"hlp","123"));

    }

    @Test
    public void testGetUserToMap(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> user = userMapper.getUserToMap(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> users = userMapper.getAllUserToMap();
        System.out.println(users);
    }

    @Test
    public void testGetAllUserToListMap(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Map<String, Object>> users = userMapper.getAllUserToListMap();
        System.out.println(users);
    }

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserByLike("wd");
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res  = userMapper.deleteMore("5,6,7");
    }
}
