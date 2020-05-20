package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: Lab
 * @date 2020/4/17 11:28 下午
 */
@Data
public class Lab {

    private Integer id;
    private String lab;
    private String administrator;
    private String admin_contact;
    private String location;

}
