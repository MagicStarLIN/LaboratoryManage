package com.lcl.labmanage.controller;

import com.lcl.labmanage.entity.ReportReq;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ReportController
 * @date 2020/4/19 10:30 下午
 */
@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/list")
    @ResponseBody
    public Response getAllReportList(Integer page, Integer limit) {
        return reportService.getAllReportLogByPage(page, limit);
    }

    @PostMapping("/repor")
    @ResponseBody
    public Response handleReport(ReportReq reportReq) {
        return reportService.handleReport(reportReq);
    }

    @GetMapping("/checked")
    @ResponseBody
    public Response checkReport(Integer id) {
        return reportService.checkReport(id);
    }

    @GetMapping("/finish")
    @ResponseBody
    public Response finishReport(Integer id) {
        return reportService.finishReport(id);
    }
}
