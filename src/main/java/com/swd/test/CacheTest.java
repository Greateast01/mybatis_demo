package com.swd.test;

import com.swd.mapper.CacheMapper;
import com.swd.pojo.Emp;
import com.swd.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author SuWeiDong
 * @date 2022-09-01 8:51
 */
public class CacheTest {

    /**
     * 一级缓存失效的四种情况
     * 1. 不同的SqlSession对应不同的一级缓存
     * 2. 同一个SqlSession但是查询条件不同
     * 3. 同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 4. 同一个SqlSession两次查询期间手动清空了缓存
     */

    @Test
    public void testCache(){

        //mybatis 一级缓存默认开启 范围为 sqlSession

        SqlSession sqlSession1 = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();

        CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);

        Emp emp1 = cacheMapper1.getEmpByEid(1);
        System.out.println(emp1);

        sqlSession1.clearCache();  //清空缓存

        Emp emp2 = cacheMapper1.getEmpByEid(1);
        System.out.println(emp2);

        System.out.println("=====================================================================");

        SqlSession sqlSession2 = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        //mybatis 一级缓存默认开启
        Emp emp3 = cacheMapper2.getEmpByEid(1);
        System.out.println(emp3);
        Emp emp4 = cacheMapper2.getEmpByEid(1);
        System.out.println(emp4);

    }
}
