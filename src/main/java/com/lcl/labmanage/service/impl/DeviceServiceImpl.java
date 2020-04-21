package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.DeviceMapper;
import com.lcl.labmanage.entity.Device;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.entity.ResultCode;
import com.lcl.labmanage.service.DeviceService;
import com.lcl.labmanage.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: DeviceServiceImpl
 * @date 2020/4/18 9:11 下午
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Override
    public Response getAllDevices(Integer page, Integer limit) {

        return Response.success(deviceMapper.getAllDeviceByPage((page - 1) * limit, limit), deviceMapper.getCountOfDevice());
    }

    @Override
    public Response addDevice(Device device) {
        device.setUpdatetime(DateUtils.getCurrentTime());
        device.setUsable_count(device.getTotal_count());
        device.setBroken_count(0);
        System.err.println(device.getLab_name());
        System.err.println(device.getEquipment_name());
        if (deviceMapper.getDeviceByLabNameAndEquipName(device.getLab_name(), device.getEquipment_name()) != null) {
            return Response.error(ResultCode.REPEAT_DEVICE.getCode(), ResultCode.REPEAT_DEVICE.getMsg());
        }
        return Response.success(deviceMapper.addDevice(device));
    }

    @Override
    public Response getLabDevice(String name, Integer page, Integer limit) {

        return Response.success(deviceMapper.getAllDeviceByPageAndLab(name,(page - 1) * limit, limit),deviceMapper.getCountOfDeviceByLab(name));
    }

}
