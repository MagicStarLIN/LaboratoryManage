package com.lcl.labmanage.service;

import com.lcl.labmanage.entity.ReportReq;
import com.lcl.labmanage.entity.Response;

public interface ReportService {

    Response getAllReportLogByPage(Integer page, Integer limit);

    Response handleReport(ReportReq reportReq);
}
