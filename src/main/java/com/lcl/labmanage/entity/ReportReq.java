package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ReportReq
 * @date 2020/4/20 1:53 上午
 */
@Data
public class ReportReq {
    private Integer id;
    private String cat;
    private Integer amount;
    private String note;
    private String reporter;
    private String reporter_contact;
}
