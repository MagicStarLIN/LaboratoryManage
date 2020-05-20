package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.DeviceMapper;
import com.lcl.labmanage.entity.Device;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.entity.ResultCode;
import com.lcl.labmanage.service.DeviceService;
import com.lcl.labmanage.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
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
    /**
     * @Title addDevice
     * @Description 新增设备
     * @Author liuchanglin
     * @Param [device]
     * @return com.lcl.labmanage.entity.Response
     **/
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
    /**
     * @Title getLabDevice
     * @Description 返回对应实验室下设备信息
     * @Author liuchanglin
     * @Date 2020/5/3 1:47 上午
     * @Param [name, page, limit]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response getLabDevice(String name, Integer page, Integer limit) {
        return Response.success(
                deviceMapper.getAllDeviceByPageAndLab(name,
                        (page - 1) * limit, limit),
                deviceMapper.getCountOfDeviceByLab(name));
    }
    /**
     * @Title getAllDevicesByParams
     * @Description 根据日期或设备名称查询
     * @Author liuchanglin
     * @Param [purchase_date, equipment_name]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response getAllDevicesByParams(String purchase_date, String equipment_name) {
        System.err.println(purchase_date + equipment_name);
        if ("".equals(purchase_date)) {
            purchase_date = null;
        }
        if ("".equals(equipment_name)) {
            equipment_name = null;
        }
        return Response.success(deviceMapper.getDevicesByParams(purchase_date,equipment_name),
                deviceMapper.getCountOfDeviceByParams(purchase_date,equipment_name));
    }

}
