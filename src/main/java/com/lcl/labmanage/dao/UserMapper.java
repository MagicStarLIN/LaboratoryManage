package com.lcl.labmanage.dao;

import com.lcl.labmanage.entity.User;

public interface UserMapper {
    boolean insertUser(User user);

    User selectUserByName(String name);

}
