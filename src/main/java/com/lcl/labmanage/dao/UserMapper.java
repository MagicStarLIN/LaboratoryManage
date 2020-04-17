package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    boolean insertUser(User user);

    User selectUserByName(String name);

    User selectUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

    Integer selectAllUser();

    List<User> selectAllUserByPage(@Param("page") Integer page,@Param("size") Integer size);

    int updateUserRole(@Param("id") Integer id, @Param("role") Integer role);

    boolean deleteUser(@Param("id") Integer id);

}
