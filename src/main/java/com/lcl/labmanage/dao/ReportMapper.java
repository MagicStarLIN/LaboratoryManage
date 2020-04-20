package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.ReportRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ReportMapper
 * @date 2020/4/19 10:26 下午
 */
public interface ReportMapper {
    List<ReportRecord> getAllRecordByPage(@Param("page") Integer page, @Param("size") Integer size);

    Integer getCountOfRecord();

    Boolean insertNewRecord(ReportRecord reportRecord);

    Boolean updateStateById(@Param("state") String state,@Param("id") Integer id);

    ReportRecord getRecordById(Integer id);
}
