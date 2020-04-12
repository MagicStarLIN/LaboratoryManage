package com.lcl.labmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ToPageController
 * @date 2020/4/12 6:20 下午
 */
@Controller
public class ToPageController {
    @RequestMapping(name = "/toPage",method = RequestMethod.GET)
    public String toPage(HttpServletRequest request){
        String url = request.getParameter("url");
        return url;
    }
}
