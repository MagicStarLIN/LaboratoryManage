package com.lcl.labmanage.service;

import com.lcl.labmanage.entity.Device;
import com.lcl.labmanage.entity.Response;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: DeviceService
 * @date 2020/4/18 9:09 下午
 */
public interface DeviceService {
    Response getAllDevices(Integer page, Integer limit);

    Response addDevice(Device device);

    Response getLabDevice(String name, Integer page, Integer limit);
}
