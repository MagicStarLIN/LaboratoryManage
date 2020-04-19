package com.lcl.labmanage.service;

import com.lcl.labmanage.entity.Response;

public interface LabLogService {
    Response getAllLabLog(Integer page, Integer limit);
}
