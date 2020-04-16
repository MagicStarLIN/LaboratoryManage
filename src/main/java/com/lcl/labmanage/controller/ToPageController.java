package com.lcl.labmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ToPageController
 * @date 2020/4/12 6:20 下午
 */
@Controller
@RequestMapping("start")
public class ToPageController {
    @RequestMapping(name = "/toPage",method = RequestMethod.GET)
    public String toPage(HttpServletRequest request){
        String url = request.getParameter("url");
        return url;
    }
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/jump/register")
    public String jumpToRegister() {
        return "register";
    }
    @GetMapping("/index/admin")
    public String jumpToIndexAdmin() {
        return "page/indexAdmin";
    }

    @GetMapping("/user/manage")
    public String jumpToUserManage() {

        return "page/UserManage";
    }
}
