package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: Notice
 * @date 2020/4/17 5:53 下午
 */
@Data
public class Notice {
    private Integer id;

    private String title;

    private String noticeinfos;

    private String updatetime;

    private String publisher;
}
