package com.lcl.labmanage.controller;

import com.lcl.labmanage.entity.LabOccupyRecord;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.OccupyLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: OccupyController
 * @date 2020/4/18 11:49 下午
 */
@Controller
@RequestMapping("/occupy")
public class OccupyController {
    @Autowired
    private OccupyLabService occupyLabService;

    @GetMapping("/infos")
    @ResponseBody
    public Response getOccupyInfos(String labName) {
        return occupyLabService.getAllOccupyInfosByLabName(labName);
    }

    @PostMapping("apply/for")
    @ResponseBody
    public Response applyForLab(LabOccupyRecord labOccupyRecord) {
        return occupyLabService.applyForLab(labOccupyRecord);
    }

    @PostMapping("/confirm")
    @ResponseBody
    public Response confirmApply(Integer id, String result) {
        return occupyLabService.confirmApply(id, result);
    }
}
