package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.Device;
import com.lcl.labmanage.entity.Lab;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: DeviceMapper
 * @date 2020/4/18 9:13 下午
 */
public interface DeviceMapper {

    Integer getCountOfDevice();

    List<Device> getAllDeviceByPage(@Param("page") Integer page, @Param("size") Integer size);

    Device getDeviceById(Integer id);

    Boolean addDevice(Device device);
}
