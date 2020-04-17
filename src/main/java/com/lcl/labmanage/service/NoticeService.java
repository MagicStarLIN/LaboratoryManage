package com.lcl.labmanage.service;

import com.lcl.labmanage.entity.Notice;
import com.lcl.labmanage.entity.Response;

import java.util.List;

public interface NoticeService {
    Response getAllNotices(Integer page, Integer limit);
}
