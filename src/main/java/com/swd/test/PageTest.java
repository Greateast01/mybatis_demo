package com.swd.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swd.mapper.EmpMapper;
import com.swd.pojo.Emp;
import com.swd.utils.SqlSessionFactoryUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author SuWeiDong
 * @date 2022-09-01 9:49
 */
public class PageTest {
    @Test
    public void testPage(){
        EmpMapper empMapper = SqlSessionFactoryUtil.getSqlSessionFactory().openSession().getMapper(EmpMapper.class);
        PageHelper.startPage(1, 2);
        List<Emp> empList = empMapper.getAllEmp();
        PageInfo<Emp> pageInfo = new PageInfo<>(empList,3);

        empList.forEach(System.out::println);
        System.out.println("===========================================================================");
        System.out.println(pageInfo);

    }
}
