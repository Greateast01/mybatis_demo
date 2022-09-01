package com.swd.mapper;

import com.swd.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SuWeiDong
 * @date 2022-08-31 15:57
 */
public interface DynamicsSQLMapper {

    /**
     * 多条件查询
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试choose when otherwise
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量删除
     * @param eids
     * @return
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 批量添加
     * @param emps
     * @return
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
