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
    private String reason;
    private String class_name;
    private String user;
    private String user_contact;
    private String term;
    private Integer start_week;
    private Integer end_week;
    private String specific_time;
    private String state;
    private String note;
}
