package com.software.fitness.controller;

import com.software.fitness.domain.*;
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
        model.addAttribute("member", staffService.getMemberByID(id));
        return "staff/memberEdit";
    }

    /*TODO:会员注销*/
    @PostMapping("/memberManage/{id}/cancel")
    public String cancelMember(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Member member = new Member();
        member.setId(id);
        member.setState("已注销");
        boolean result = staffService.updateMember(member);
        String message = "";
        if (result) {
            message = "" + id + " 已注销";
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/memberManage/";
    }


    /*TODO:会员激活*/
    @PostMapping("/memberManage/{id}/activate")
    public String activateMember(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Member member = new Member();
        member.setId(id);
        member.setState("有效");
        boolean result = staffService.updateMember(member);
        String message = "";
        if (result) {
            message = "" + id + "已激活";
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/memberManage/";
    }

    /*TODO:会员添加*/
    @PostMapping("/memberManage/add")
    public String addMember(Member member, HttpServletRequest request, RedirectAttributes attributes) {
        boolean result = staffService.addMember(member);
        String message = "";
        if (result) {
            message = "添加成功";
        } else {
            message = "添加失败";
        }
        attributes.addAttribute("message", message);
        return "redirect:/staff/memberManage";
    }

    /*TODO:会员编辑*/

    @PostMapping("/memberManage/edit")
    public String editMember(Member member, HttpServletRequest request, RedirectAttributes attributes, Model model) {

        return "redirect:/staff/memberManage";
    }

    /*TODO:会员更新*/
    @PostMapping("/memberManage/{id}/update")
    public String updateMember(@PathVariable("id") int id, Member member, HttpServletRequest request, RedirectAttributes attributes, Model model) {
        String message = "";
        boolean change = staffService.updateMemberall(member);
        if (change == true) {
            message = "修改成功";
            model.addAttribute("member", staffService.getMemberByID(id));
        } else {
            message = "修改失败";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/memberManage/" + id;
    }

    /*TODO:教练列表页*/
    @GetMapping("/coachManage")
    public String coachManagePage(HttpServletRequest request, Model model) {
        List<Coach> coachList = staffService.listCoach();
        model.addAttribute("coachList", coachList);
        return "staff/coachManage";
    }

    /*TODO:添加教练*/
    @PostMapping("/coachManage/add")
    public String addCoach(Coach coach, HttpServletRequest request, RedirectAttributes attributes) {
        boolean result = staffService.addCoach(coach);
        String message = "";
        if (result) {
            message = "添加成功";
        } else {
            message = "添加失败";
        }
        attributes.addAttribute("message", message);
        return "redirect:/staff/coachManage";
    }

    /*TODO:教练详情页*/
    @GetMapping("/coachManage/{id}")
    public String coachEditPage(@PathVariable("id") int id, HttpServletRequest request, Model model) {
        model.addAttribute("coach", staffService.getCoachByID(id));
        return "staff/coachEdit";
    }


    /*TODO:教练编辑上传*/
    @PostMapping("/coachManage/{id}/update")
    public String updateCoach(@PathVariable("id") int id, Coach coach, HttpServletRequest request, RedirectAttributes attributes) {
        coach.setId(id);
        boolean result = staffService.updateCoach(coach);
        String message = "";
        if (result) {
            message = "更新成功";
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage/" + id;
    }


    /*TODO:离职教练*/
    @PostMapping("/coachManage/{id}/dismiss")
    public String dismissCoach(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Coach coach = new Coach();
        coach.setId(id);
        coach.setState("离职");
        boolean result = staffService.updateCoach(coach);
        String message = "";
        if (result) {
            message = "" + coach.getId() + " 已离职";
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage";
    }


    /*TODO:启用教练*/
    @PostMapping("/coachManage/{id}/employ")
    public String employCoach(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Coach coach = new Coach();
        coach.setId(id);
        coach.setState("在职");
        boolean result = staffService.updateCoach(coach);
        String message = "";
        if (result) {
            message = "" + id + " 已启用";
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage";
    }
}