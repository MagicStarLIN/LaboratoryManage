package com.lcl.labmanage.service;

import com.lcl.labmanage.entity.LabOccupyRecord;
import com.lcl.labmanage.entity.Response;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: OccupyLabService
 * @date 2020/4/18 11:43 下午
 */
public interface OccupyLabService {
    Response getAllOccupyInfosByLabName(String labName);

    Response applyForLab(LabOccupyRecord labOccupyRecord);

    Response confirmApply(Integer id, String result);
}
