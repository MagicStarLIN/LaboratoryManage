package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.OccupyInfoMapper;
import com.lcl.labmanage.entity.LabOccupyRecord;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.entity.ResultCode;
import com.lcl.labmanage.service.OccupyLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: OccupyLabServiceImpl
 * @date 2020/4/18 11:44 下午
 */
@Service
public class OccupyLabServiceImpl implements OccupyLabService {
    @Autowired
    private OccupyInfoMapper occupyInfoMapper;

    @Override
    public Response getAllOccupyInfosByLabName(String labName) {
        if (occupyInfoMapper.getLabOccupyRecordByName(labName).size() != 0) {
            return Response.success(occupyInfoMapper.getLabOccupyRecordByName(labName), occupyInfoMapper.getCountOfOccupyInfosByName(labName));
        } else {
            return Response.error(ResultCode.NULL_DATA.getCode(), ResultCode.NULL_DATA.getMsg());
        }
    }

    @Override
    public Response applyForLab(LabOccupyRecord labOccupyRecord) {
        labOccupyRecord.setState("待审批");
        if (occupyInfoMapper.getCountOfOccupyInfosByTime(labOccupyRecord.getLab(), labOccupyRecord.getEnd_time()) != 0) {
            return Response.error(ResultCode.AREADY_OCCUPIED.getCode(), ResultCode.AREADY_OCCUPIED.getMsg());
        } else {
            return Response.success(occupyInfoMapper.insertNewOccupyRecord(labOccupyRecord));
        }
    }

    @Override
    public Response confirmApply(Integer id, String result) {
        return Response.success(occupyInfoMapper.updateStateById(id, result));
    }
}
