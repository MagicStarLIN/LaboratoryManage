package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.LabMapper;
import com.lcl.labmanage.dao.OccupyInfoMapper;
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
    @Autowired
    private OccupyInfoMapper occupyInfoMapper;
    @Override
    public Response getAllLabInfos(Integer page, Integer limit) {
        return Response.success(labMapper.getAllLabsByPage((page - 1) * limit, limit), labMapper.getCountOfLab());
    }
    /**
     * @Title addLab
     * @Description 新增实验室
     * @Author liuchanglin
     * @Param [lab]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response addLab(Lab lab) {
        return Response.success(labMapper.addLab(lab));
    }

    /**
     * @Title deleteLab
     * @Description 删除实验室
     * @Author liuchanglin
     * @Date 2020/5/3 1:32 上午
     * @Param [id]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response deleteLab(Integer id) {
        String lab = labMapper.getLabById(id).getLabName();
        return Response.success(labMapper.deleteLab(id) && occupyInfoMapper.deleteRecordByLabName(lab));
    }

    @Override
    public Response getAllLabName() {
        return Response.success(labMapper.getAllLabName());
    }

}
