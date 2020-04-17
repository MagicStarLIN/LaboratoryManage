package com.lcl.labmanage.controller;

import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: NoticeController
 * @date 2020/4/17 6:08 下午
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    @ResponseBody
    public Response getAllNotices(Integer page, Integer limit) {
        return noticeService.getAllNotices(page, limit);
    }

    @GetMapping("/infos")
    @ResponseBody
    public Response getNoticeInfo(Integer id) {
        return noticeService.getNoticeInfos(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public Response addNotice(String title, String content, String publisher) {
        return noticeService.addNotice(title, content, publisher);
    }

}
