package com.software.fitness.controller;

import com.software.fitness.domain.*;
import com.software.fitness.service.RecordService;
import com.software.fitness.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    /*TODO:会员列表页*/
    @GetMapping("/memberManage")
    public String memberManagePage(HttpServletRequest request, Model model) {
        List<Member> memberList = staffService.listMember();
        model.addAttribute("memberList", memberList);
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
        Member member = new Member();
        member.setId(id);
        member.setState("已注销");
        Integer er = staffService.updateMember(member);
        String message = "";
        if (er != null && er > 0) {
            message = "" + id + " 已注销";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
//            RecordService.staffInsertRecord(genRecord(sid, "注销会员：" + member.toString()));
//           不明白上面这个genRecord是什么意思
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
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
