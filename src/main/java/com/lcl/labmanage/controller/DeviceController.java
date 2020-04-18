package com.lcl.labmanage.controller;

import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: DeviceController
 * @date 2020/4/18 10:21 下午
 */
@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @GetMapping("/list")
    @ResponseBody
    public Response getAllDevice(Integer page, Integer limit) {
        return deviceService.getAllDevices(page, limit);
    }
}
