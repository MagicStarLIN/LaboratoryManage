package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: LabLog
 * @Description: 实验日志
 * @date 2020/4/19 7:30 下午
 */
@Data
public class LabLog {
    private Integer id;
    private Integer occupy_id;
    private String lab;
    private String reason;
    private String attendance;
    private String device;
    private String user;
    private String contact;
}
