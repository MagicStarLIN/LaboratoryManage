package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.LabLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabLogMapper {

    List<LabLog> getAllLabLogByPage(@Param("page") Integer page, @Param("size") Integer size);

    Integer getCountOfLabLog();

    Boolean insertNewLabLog(LabLog labLog);

    Boolean deleteLabLog(Integer id);

    LabLog getLabLogByOccupyId(Integer occupyId);

    Boolean updateLabLogById(@Param("id") Integer id, @Param("attendance") String attendance, @Param("device") String device);
}
