package com.swd.mapper;

import com.swd.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author SuWeiDong
 * @date 2022-08-30 16:19
 */
public interface DeptMapper {
    /**
     * 通过分步查询，员工及所对应的部门信息
     * 分步查询第二步：通过did查询员工对应的部门信息
     * @param did
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /***
     * 获取部门以及部门中所有员工信息
     * @param did
     * @return
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     *
     * 通过分步查询，查询部门及对应的所有员工信息
     * 分步查询第一步：查询部门信息
     * @param did
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
