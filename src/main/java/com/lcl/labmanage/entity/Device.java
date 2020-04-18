package com.lcl.labmanage.entity;

import lombok.Data;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: Device
 * @date 2020/4/18 8:08 下午
 */
@Data
public class Device {

    private Integer id;
    private String equipment_name;
    private String lab_name;
    private Integer total_count;
    private Integer broken_count;
    private Integer usable_count;
    private String updatetime;

}
