package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ReportRecord
 * @Description: 报备信息
 * @date 2020/4/19 7:39 下午
 */
@Data
public class ReportRecord {

    private Integer id;
    private String lab;
    private String cat;
    private String device;
    private Integer amount;
    private String reporter;
    private String reporter_contact;
    private String state;
    private String note;

}
