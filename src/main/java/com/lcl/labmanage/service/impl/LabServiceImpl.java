package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.LabMapper;
import com.lcl.labmanage.entity.Lab;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: LabServiceImpl
 * @date 2020/4/18 1:06 上午
 */
@Service
public class LabServiceImpl implements LabService {
    @Autowired
    private LabMapper labMapper;
    @Override
    public Response getAllLabInfos(Integer page, Integer limit) {
        return Response.success(labMapper.getAllLabsByPage((page - 1) * limit, limit), labMapper.getCountOfLab());
    }

    @Override
    public Response addLab(Lab lab) {
        return Response.success(labMapper.addLab(lab));
    }

}
