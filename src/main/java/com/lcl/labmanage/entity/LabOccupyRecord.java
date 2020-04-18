package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: LabOccupyRecord
 * @date 2020/4/18 8:12 下午
 */
@Data
public class LabOccupyRecord {
    private Integer id;
    private String lab;
    private String purpose;
    private String reason;
    private String user;
    private String user_contact;
    private String start_time;
    private String end_time;
    private String state;
    private String note;
}
