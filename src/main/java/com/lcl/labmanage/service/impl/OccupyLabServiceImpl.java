package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.LabLogMapper;
import com.lcl.labmanage.dao.OccupyInfoMapper;
import com.lcl.labmanage.entity.LabLog;
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
    @Autowired
    private LabLogMapper labLogMapper;

    @Override
    public Response getAllOccupyInfosByPage(Integer page, Integer limit) {
        return Response.success(occupyInfoMapper.getLabOccupyRecordByPage((page - 1) * limit, limit), occupyInfoMapper.getCountOfOccupyRecord());
    }
    /**
     * @Title getAllOccupyInfosByLabName
     * @Description 根据实验室名称返回占用信息
     * @Author liuchanglin
     * @Param [labName]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response getAllOccupyInfosByLabName(String labName) {
        if (occupyInfoMapper.getLabOccupyRecordByName(labName).size() != 0) {
            return Response.success(occupyInfoMapper.getLabOccupyRecordByName(labName), occupyInfoMapper.getCountOfOccupyInfosByName(labName));
        } else {
            return Response.error(ResultCode.NULL_DATA.getCode(), ResultCode.NULL_DATA.getMsg());
        }
    }
    /**
     * @Title applyForLab
     * @Description 申请占用实验室
     * @Author liuchanglin
     * @Param [labOccupyRecord]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response applyForLab(LabOccupyRecord labOccupyRecord) {
        labOccupyRecord.setState("待审批");
        if (occupyInfoMapper.getCountOfOccupyInfosByTime(labOccupyRecord.getTerm(),
                labOccupyRecord.getLab(),
                labOccupyRecord.getEnd_week(),
                labOccupyRecord.getSpecific_time()) != 0) {
            return Response.error(ResultCode.AREADY_OCCUPIED.getCode(), ResultCode.AREADY_OCCUPIED.getMsg());
        } else {
            return Response.success(occupyInfoMapper.insertNewOccupyRecord(labOccupyRecord));
        }
    }
    /**
     * @Title confirmApply
     * @Description 审核申请
     * @Author liuchanglin
     * @Param [id, result]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response confirmApply(Integer id, String result) {
        LabOccupyRecord occupyRecord = occupyInfoMapper.getOccupyInfosById(id);
        if (occupyRecord.getState().equals(result)) {
            return Response.success(true);
        }
        if (result.equals("准许")) {
            LabLog labLog = new LabLog();
            labLog.setOccupy_id(id);
            labLog.setReason(occupyRecord.getReason());
            labLog.setLab(occupyRecord.getLab());
            labLog.setUser(occupyRecord.getUser());
            labLog.setContact(occupyRecord.getUser_contact());
            labLogMapper.insertNewLabLog(labLog);
        }
        if (result.equals("不准许")) {
            LabLog labLog = labLogMapper.getLabLogByOccupyId(id);
            if (labLog != null) {
                labLogMapper.deleteLabLog(labLog.getId());
            }
        }

        boolean flag = occupyInfoMapper.updateStateById(id, result);
        System.err.println("修改为"+flag);
        return Response.success(flag);
    }

}
