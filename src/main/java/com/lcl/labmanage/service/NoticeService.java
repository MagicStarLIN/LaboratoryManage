package com.lcl.labmanage.service;

import com.lcl.labmanage.entity.Notice;
import com.lcl.labmanage.entity.Response;

import java.util.List;
import java.util.ResourceBundle;

public interface NoticeService {
    Response getAllNotices(Integer page, Integer limit);

    Response getNoticeInfos(Integer id);

    Response addNotice(String title, String content,String publisher);

    Response deleteNotice(Integer id);
}
