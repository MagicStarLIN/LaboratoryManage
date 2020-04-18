package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.LabOccupyRecord;
import com.lcl.labmanage.entity.Response;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OccupyInfoMapper {

    List<LabOccupyRecord> getLabOccupyRecordByName(String labName);

    Integer getCountOfOccupyInfosByName(String labName);

    Integer getCountOfOccupyInfosByTime(@Param("labName") String labName, @Param("time") String time);

    Boolean insertNewOccupyRecord(LabOccupyRecord labOccupyRecord);

    Boolean updateStateById(@Param("id") Integer id, @Param("result") String result);
}
