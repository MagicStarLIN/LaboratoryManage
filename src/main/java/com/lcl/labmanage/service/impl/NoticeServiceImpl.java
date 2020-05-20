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
    /**
     * @Title getNoticeInfos
     * @Description 返回公告详情
     * @Author liuchanglin
     * @Date 2020/5/3 1:12 上午
     * @Param [id]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response getNoticeInfos(Integer id) {
        return Response.success(noticeMapper.getNoticesById(id));
    }

    /**
     * @Title addNotice
     * @Description 公告添加
     * @Author liuchanglin
     * @Param [title, content, publisher]
     * @return com.lcl.labmanage.entity.Response
     **/
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
    /**
     * @Title deleteNotice
     * @Description 删除公告
     * @Author liuchanglin
     * @Param [id]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response deleteNotice(Integer id) {
        return Response.success(noticeMapper.deleteNotice(id));
    }

}
