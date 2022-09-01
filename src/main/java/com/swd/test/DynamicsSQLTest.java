package com.swd.test;

import com.swd.mapper.DynamicsSQLMapper;
import com.swd.pojo.Emp;
import com.swd.utils.SqlSessionFactoryUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author SuWeiDong
 * @date 2022-08-31 16:08
 */
public class DynamicsSQLTest {
    @Test
    public void testGetEmpByCondition(){
        DynamicsSQLMapper dynamicsSQLMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(DynamicsSQLMapper.class);
        Emp emp = new Emp(null,"",null,null,null);
        List<Emp> empList = dynamicsSQLMapper.getEmpByCondition(emp);
        empList.forEach(System.out::println);
    }


    @Test
    public void testGetEmpByChoose(){
        DynamicsSQLMapper dynamicsSQLMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(DynamicsSQLMapper.class);
        Emp emp = new Emp(null,"张三",null,null,null);
        List<Emp> empList = dynamicsSQLMapper.getEmpByChoose(emp);
        empList.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreByArray(){
        DynamicsSQLMapper dynamicsSQLMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession(true).getMapper(DynamicsSQLMapper.class);
        int num = dynamicsSQLMapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println("删除了"+num+"条记录");
    }

    @Test
    public void testInsertMoreByList(){
        DynamicsSQLMapper dynamicsSQLMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession(true).getMapper(DynamicsSQLMapper.class);
        Emp e1 =  new Emp(null,"a",12,"男","456@qq.com");
        Emp e2 =  new Emp(null,"b",24,"女","456@qq.com");
        Emp e3 =  new Emp(null,"c",32,"男","456@qq.com");
        List<Emp> emps = Arrays.asList(e1, e2, e3);
        int num = dynamicsSQLMapper.insertMoreByList(emps);
        System.out.println("添加了"+num+"条记录");
    }
}
