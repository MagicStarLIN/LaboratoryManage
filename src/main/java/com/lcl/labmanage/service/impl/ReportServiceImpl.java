package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.DeviceMapper;
import com.lcl.labmanage.dao.ReportMapper;
import com.lcl.labmanage.entity.*;
import com.lcl.labmanage.service.ReportService;
import com.lcl.labmanage.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ReportServiceImpl
 * @date 2020/4/19 10:31 下午
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Response getAllReportLogByPage(Integer page, Integer limit) {
        return Response.success(reportMapper.getAllRecordByPage((page - 1) * limit, limit), reportMapper.getCountOfRecord());
    }

    @Override
    public Response handleReport(ReportReq reportReq) {
        Device currDevice = deviceMapper.getDeviceById(reportReq.getId());
        ReportRecord reportRecord = new ReportRecord();
        reportRecord.setDevice(currDevice.getEquipment_name());
        reportRecord.setAmount(reportReq.getAmount());
        reportRecord.setCat(reportReq.getCat());
        reportRecord.setLab(currDevice.getLab_name());
        reportRecord.setNote(reportRecord.getNote());
        reportRecord.setReporter(reportReq.getReporter());
        reportRecord.setReporter_contact(reportReq.getReporter_contact());
        reportRecord.setState("未受理");

        reportMapper.insertNewRecord(reportRecord);
        if (currDevice != null) {
            //判断类别
            if ("报修".equals(reportReq.getCat())) {
                //判断数量合法
                if (reportReq.getAmount() > currDevice.getTotal_count() || reportReq.getAmount() > currDevice.getUsable_count()) {
                    return Response.error(ResultCode.ILLEGAL_COUNT.getCode(), ResultCode.ILLEGAL_COUNT.getMsg());
                } else {
                    currDevice.setBroken_count(currDevice.getBroken_count() + reportReq.getAmount());
                    currDevice.setUsable_count(currDevice.getUsable_count() - reportReq.getAmount());
                    currDevice.setUpdatetime(DateUtils.getCurrentTime());
                    return Response.success(deviceMapper.updateDevice(currDevice));
                }
            }
            return Response.success(true);

        }
        return Response.error(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMsg());
    }

    @Override
    public Response checkReport(Integer id) {
        return Response.success(reportMapper.updateStateById("已受理", id));
    }

    @Override
    public Response finishReport(Integer id){
        ReportRecord reportRecord = reportMapper.getRecordById(id);
        Device device = deviceMapper.getDeviceByLabNameAndEquipName(reportRecord.getLab(), reportRecord.getDevice());
        if ("报修".equals(reportRecord.getCat())) {
            if (reportRecord.getAmount() > device.getBroken_count()) {
                return Response.error(ResultCode.ILLEGAL_COUNT.getCode(), ResultCode.ILLEGAL_COUNT.getMsg());
            }
            device.setBroken_count(device.getBroken_count() - reportRecord.getAmount());
            device.setUsable_count(device.getUsable_count() + reportRecord.getAmount());
            reportMapper.updateStateById("已完成", id);
            return Response.success(deviceMapper.updateDevice(device));
        } else if ("添置".equals(reportRecord.getCat())) {
            device.setTotal_count(device.getTotal_count() + reportRecord.getAmount());
            device.setUsable_count(device.getUsable_count() + reportRecord.getAmount());
            reportMapper.updateStateById("已完成", id);
            return Response.success(deviceMapper.updateDevice(device));
        } else {
            reportMapper.updateStateById("已完成", id);
            return Response.success(true);
        }

    }


}
