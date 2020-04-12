package com.lcl.labmanage.service;

import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.entity.User;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: TestService
 * @date 2019/10/25 3:50 下午
 */
public interface PersonService {

    Response personVerify(User user);

    Response register(User user);

}
