package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: Class
 * @date 2020/4/12 3:46 下午
 */
@Data
public class ClassInfo {
    private Integer id;
    /**
     * 班级
     */
    private String className;
    /**
     * 专业
     */
    private String professional;
    /**
     * 学院
     */
    private String college;
}
