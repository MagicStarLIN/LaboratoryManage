package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: NoticeMapper
 * @date 2020/4/17 5:57 下午
 */
public interface NoticeMapper {
    Integer getCountOfNotices();

    List<Notice> getAllNoticesByPage(@Param("page") Integer page, @Param("size") Integer size);
}
