package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.LabOccupyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OccupyInfoMapper {

    List<LabOccupyRecord> getLabOccupyRecordByPage(@Param("page") Integer page, @Param("size") Integer size);

    Integer getCountOfOccupyRecord();

    List<LabOccupyRecord> getLabOccupyRecordByName(String labName);

    Integer getCountOfOccupyInfosByName(String labName);

    LabOccupyRecord getOccupyInfosById(Integer id);

    Integer getCountOfOccupyInfosByTime(@Param("term") String term, @Param("labName") String labName, @Param("time") Integer time,@Param("specific_time")String specific_time);

    Boolean insertNewOccupyRecord(LabOccupyRecord labOccupyRecord);

    Boolean updateStateById(@Param("id") Integer id, @Param("result") String result);

    Boolean deleteRecordByLabName(String lab);
}
