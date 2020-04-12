package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: Student
 * @date 2020/4/12 3:50 下午
 */
@Data
public class Student {
    private Integer id;
    private Integer userId;
    private String name;
    private int sex;
    private Integer classId;

}
