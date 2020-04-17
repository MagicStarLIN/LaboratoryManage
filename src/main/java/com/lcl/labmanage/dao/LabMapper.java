package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.Lab;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabMapper {

    Integer getCountOfLab();

    List<Lab> getAllLabsByPage(@Param("page") Integer page, @Param("size") Integer size);

    Lab getLabById(Integer id);

    Boolean addLab(Lab lab);
}
