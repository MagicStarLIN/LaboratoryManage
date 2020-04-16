package com.lcl.labmanage.controller;

import com.lcl.labmanage.entity.Response;
import com.lcl.labmanage.entity.User;
import com.lcl.labmanage.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ModelController
 * @Description: controller
 * @date 2019/10/31 10:22 上午
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private PersonService personService;



    @PostMapping("/register")
    @ResponseBody
    public Response registerUser(User user) {
        return personService.register(user);
    }

    @PostMapping("/sign/in")
    @ResponseBody
    public Response signIn(User user) {
        return personService.personVerify(user);
    }

    @GetMapping("/list")
    @ResponseBody
    public Response userList() {
        return personService.userList();
    }
}
