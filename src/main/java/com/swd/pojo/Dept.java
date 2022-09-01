package com.swd.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author SuWeiDong
 * @date 2022-08-30 16:16
 */
@Data
@NoArgsConstructor
public class Dept {
    private Integer did;
    private String deptName;
    private List<Emp> emps;

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }
}
