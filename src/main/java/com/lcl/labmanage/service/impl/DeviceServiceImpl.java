package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.DeviceMapper;
import com.lcl.labmanage.entity.Device;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: DeviceServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
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
        return null;
    }
}
