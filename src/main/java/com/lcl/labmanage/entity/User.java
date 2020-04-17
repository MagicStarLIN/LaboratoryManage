package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: User
 * @Description: user实体类
 * @date 2020/4/12 3:44 下午
 */
@Data
public class User {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private String role_name;
}
