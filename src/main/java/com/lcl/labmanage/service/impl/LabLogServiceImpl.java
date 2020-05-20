package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.LabLogMapper;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.LabLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: LabLogServiceImpl
 * @date 2020/4/19 8:58 下午
 */
@Service
public class LabLogServiceImpl implements LabLogService {
    @Autowired
    private LabLogMapper labLogMapper;

    @Override
    public Response getAllLabLog(Integer page, Integer limit) {
        return Response.success(labLogMapper.getAllLabLogByPage((page - 1) * limit, limit), labLogMapper.getCountOfLabLog());
    }
    /**
     * @Title deleteLabLog
     * @Description 删除日志
     * @Author liuchanglin
     * @Date 2020/5/3 3:36 上午
     * @Param [id]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response deleteLabLog(Integer id) {
        return Response.success(labLogMapper.deleteLabLog(id));
    }
    /**
     * @Title editLabLog
     * @Description 填写日志
     * @Author liuchanglin
     * @Date 2020/5/3 3:27 上午
     * @Param [id, attendance, device]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response editLabLog(Integer id, String attendance, String device) {
        return Response.success(labLogMapper.updateLabLogById(id, attendance, device));
    }

    @Override
    public Response getAllLabLogByUserName(String name, Integer page, Integer limit) {
        return Response.success(labLogMapper.getAllLabLogByPageAndUser(name,(page - 1) * limit, limit), labLogMapper.getCountOfLabLogAndUser(name));

    }

}
