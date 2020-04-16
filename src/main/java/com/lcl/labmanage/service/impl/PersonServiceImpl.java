package com.lcl.labmanage.service.impl;

import com.lcl.labmanage.dao.UserMapper;
import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.entity.ResultCode;
import com.lcl.labmanage.entity.User;
import com.lcl.labmanage.service.PersonService;
import com.lcl.labmanage.utils.MD5Utils;
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

    /**
     * @Title personVerify
     * @Description 登陆验证
     * @Author liuchanglin
     * @Date 2020/4/12 11:40 下午
     * @Param [user]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response personVerify(User user) {
        User currentUser = userMapper.selectUserByNameAndPassword(user.getUserName(),
                MD5Utils.encrypt(user.getPassword()));
        if (currentUser != null) {
            return Response.success(currentUser);
        }
        return Response.error(ResultCode.USER_ABSENCE.getCode(), ResultCode.USER_ABSENCE.getMsg());
    }
    /**
     * @Title register
     * @Description 注册
     * @Author liuchanglin
     * @Date 2020/4/12 11:40 下午
     * @Param [user]
     * @return com.lcl.labmanage.entity.Response
     **/
    @Override
    public Response register(User user) {
        if (userMapper.selectUserByName(user.getUserName()) != null) {
            return Response.error(false,ResultCode.REPEAT_NAME.getCode(), ResultCode.REPEAT_NAME.getMsg());
        }
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        return Response.success(userMapper.insertUser(user),"注册成功");
    }

    @Override
    public Response userList() {
        return Response.success(userMapper.selectAllUser(),userMapper.selectAllUser().size());
    }


}
