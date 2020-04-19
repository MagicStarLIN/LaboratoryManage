package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.NoticeMapper;
import com.lcl.labmanage.entity.Notice;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.entity.ResultCode;
import com.lcl.labmanage.service.NoticeService;
import com.lcl.labmanage.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: NoticeServiceImpl
 * @date 2020/4/17 5:43 下午
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public Response getAllNotices(Integer page, Integer limit) {
        return Response.success(noticeMapper.getAllNoticesByPage((page - 1) * limit, limit),
                noticeMapper.getCountOfNotices());
    }

    @Override
    public Response getNoticeInfos(Integer id) {
        return Response.success(noticeMapper.getNoticesById(id));
    }

    @Override
    public Response addNotice(String title, String content, String publisher) {
        Notice notice = new Notice();
        notice.setNoticeinfos(content);
        notice.setTitle(title);
        notice.setPublisher(publisher);
        notice.setUpdatetime(DateUtils.getCurrentTime());
        if (noticeMapper.addNotice(notice)) {
            return Response.success(true);
        } else {
            return Response.error(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMsg());
        }
    }

    @Override
    public Response deleteNotice(Integer id) {
        return Response.success(noticeMapper.deleteNotice(id));
    }

}
