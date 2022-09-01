package com.swd.test;

import com.swd.mapper.DeptMapper;
import com.swd.mapper.EmpMapper;
import com.swd.pojo.Dept;
import com.swd.pojo.Emp;
import com.swd.utils.SqlSessionFactoryUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author SuWeiDong
 * @date 2022-08-30 16:25
 */
public class EmpDeptTest {
    @Test
    public void testGetAllEmp(){
        EmpMapper empMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.getAllEmp();
        empList.forEach(System.out::println);
    }

    @Test
    public void testGetEmpAndDept(){
        EmpMapper empMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDept(5);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        EmpMapper empMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp);
    }

    @Test
    public void testGetDeptAndEmp(){
        DeptMapper deptMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        DeptMapper deptMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }
}
