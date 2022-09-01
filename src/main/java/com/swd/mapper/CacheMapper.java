package com.swd.mapper;

import com.swd.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author SuWeiDong
 * @date 2022-09-01 8:49
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);
}
