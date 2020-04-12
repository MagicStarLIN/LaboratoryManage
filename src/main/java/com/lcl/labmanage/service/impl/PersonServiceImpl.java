package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.UserMapper;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.entity.ResultCode;
import com.lcl.labmanage.entity.User;
import com.lcl.labmanage.service.PersonService;
import com.lcl.labmanage.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: PersonServiceImpl
 * @Description:
 * @date 2020/4/12 4:00 下午
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Response personVerify(User user) {
        return null;
    }

    @Override
    public Response register(User user) {
        if (userMapper.selectUserByName(user.getUserName()) != null) {
            return Response.error(false,ResultCode.REPEAT_NAME.getCode(), ResultCode.REPEAT_NAME.getMsg());
        }
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        return Response.success(userMapper.insertUser(user),"注册成功");
    }


}
