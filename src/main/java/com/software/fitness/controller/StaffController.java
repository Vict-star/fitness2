package com.software.fitness.controller;

import com.github.pagehelper.PageInfo;
import com.software.fitness.domain.*;
import com.software.fitness.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    /*TODO:会员列表页*/
    @GetMapping("/memberManage")
    public String memberManagePage(HttpServletRequest request, Model model) {

        return "staff/memberManage";
    }

    /*TODO:会员详情页*/
    @GetMapping("/memberManage/{id}")
    public String memberEditPage(@PathVariable("id") int id, HttpServletRequest request, Model model) {

        return "staff/memberEdit";
    }

    /*TODO:会员注销*/
    @PostMapping("/memberManage/{id}/cancel")
    public String cancelMember(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {

        return "redirect:/staff/memberManage/";
    }

    /*TODO:会员激活*/
    @PostMapping("/memberManage/{id}/activate")
    public String activateMember(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {

        return "redirect:/staff/memberManage/";
    }

    /*TODO:会员更新*/
    @PostMapping("/memberManage/{id}/update")
    public String updateMember(@PathVariable("id") int id, Member member, HttpServletRequest request, RedirectAttributes attributes) {

        return "redirect:/staff/memberManage/" + id;
    }

    /*TODO:会员添加*/
    @PostMapping("/memberManage/add")
    public String addMember(Member member, HttpServletRequest request, RedirectAttributes attributes) {

        return "redirect:/staff/memberManage";
    }

    /*TODO:会员编辑*/
    @PostMapping("/memberManage/edit")
    public String editMember(Member member, HttpServletRequest request, RedirectAttributes attributes) {

        return "redirect:/staff/memberManage";
    }
}
