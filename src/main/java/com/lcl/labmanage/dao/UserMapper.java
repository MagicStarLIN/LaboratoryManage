package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    boolean insertUser(User user);

    User selectUserByName(String name);

    User selectUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

    List<User> selectAllUser();

}
