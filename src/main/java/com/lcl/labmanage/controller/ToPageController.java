package com.lcl.labmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuchanglin
 * @version 1.0
 * @ClassName: ToPageController
 * @date 2020/4/12 6:20 下午
 */
@Controller
@RequestMapping("start")
public class ToPageController {

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

    @GetMapping("/notice/add")
    public String jumToNoticeAdd() {
        return "page/NoticeAdd";
    }

    @GetMapping("/lab/info")
    public String jumpToLabInfos() {
        return "page/labInfos";
    }

    @GetMapping("/lab/add")
    public String jumpToLabAdd() {
        return "page/labAdd";
    }

    @GetMapping("/lab/occupy/infos")
    public String jumpToLabOccupyInfos() {
        return "page/labOccupyInfos";
    }

    @GetMapping("/lab/equip")
    public String jumpToLabEquip() {
        return "page/labEquipment";
    }

    @GetMapping("/lab/equip/lab")
    public String jumpToLabEquipByLab() {
        return "page/labEquipmentByLab";
    }

    @GetMapping("/exper/log")
    public String jumpToLabLog() {
        return "page/labLog";
    }

    @GetMapping("/require/manage")
    public String jumpToRequireManage() {
        return "page/reportManage";
    }

    @GetMapping("/exper/occupy")
    public String jumpToExperOccupy() {
        return "page/ALLlabOccupyInfos";
    }

    @GetMapping("/index/user")
    public String jumpToIndexUser() {
        return "userPage/indexUser";
    }

    @GetMapping("/lab/user/info")
    public String jumpToLabInfoUser() {
        return "userPage/labInfoUser";
    }

    @GetMapping("/lab/user/equip")
    public String jumpToLabEquipUser() {
        return "userPage/labEquipUser";
    }

    @GetMapping("/exper/occupy/user")
    public String jumpToOccupyUser() {
        return "userPage/labOccupyUser";
    }

    @GetMapping("/exper/log/user")
    public String jumpToLabLogUser() {
        return "userPage/labLogUser";
    }

    @GetMapping("/lab/occupy/user/infos")
    public String jumpToLabOccupyInfosByLab() {
        return "userPage/labOccupyInfoUser";
    }

    @GetMapping("/lab/user/equip/lab")
    public String jumpToLabEquipUserByLab() {
        return "userPage/labEquipUserByLab";
    }
}
