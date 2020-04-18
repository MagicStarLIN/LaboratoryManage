package com.lcl.labmanage.service;

import com.lcl.labmanage.entity.Lab;
import com.lcl.labmanage.entity.Response;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: LabService
 * @date 2020/4/18 1:02 上午
 */
public interface LabService {
    Response getAllLabInfos(Integer page, Integer limit);

    Response addLab(Lab lab);
}
