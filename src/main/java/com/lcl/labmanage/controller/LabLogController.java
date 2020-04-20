package com.lcl.labmanage.controller;

import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.LabLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: LabLogController
 * @date 2020/4/19 9:00 下午
 */
@Controller
@RequestMapping("/lab/log")
public class LabLogController {
    @Autowired
    private LabLogService labLogService;

    @GetMapping("/list")
    @ResponseBody
    public Response getAllLabLog(Integer page, Integer limit) {
        return labLogService.getAllLabLog(page, limit);
    }


    @PostMapping("/delete")
    @ResponseBody
    public Response deleteLabLog(Integer id) {
        return labLogService.deleteLabLog(id);
    }
}
