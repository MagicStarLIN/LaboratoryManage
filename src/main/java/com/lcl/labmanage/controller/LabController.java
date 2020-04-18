package com.lcl.labmanage.controller;

import com.lcl.labmanage.entity.Lab;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: LabController
 * @date 2020/4/18 1:28 上午
 */
@Controller
@RequestMapping("/lab")
public class LabController {
    @Autowired
    private LabService labService;

    @GetMapping("/list")
    @ResponseBody
    public Response getAllLabInfos(Integer page, Integer limit) {
        return labService.getAllLabInfos(page, limit);
    }

    @PostMapping("/add")
    @ResponseBody
    public Response addNewLab(Lab lab) {
        return labService.addLab(lab);
    }
}
