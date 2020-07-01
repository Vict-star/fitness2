package com.software.fitness.controller;

import com.software.fitness.domain.Staff;
import com.software.fitness.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/index")
public class LoginController {
    @Autowired
    private StaffService staffService;


    @GetMapping
    public String login(HttpServletRequest request) {
        return "Login";
//        Staff staff = new Staff();
//        staff.setName("zcf");
//        staff.setId(123456);
//        request.getSession().setAttribute("loginUser",staff);
//        return "staff/index";
    }

    /*TODO:登陆功能*/
    @PostMapping("/Login")
    public String login(@RequestParam String id, @RequestParam String password,
                        RedirectAttributes attributes, HttpServletRequest request) {


//        if ( ) {
//
//            return "/staff/index";
//        } else {
//
        return "redirect:/index";
//        }
    }

    /*登出功能*/
    @GetMapping("/Logout")
    public String logout(HttpServletRequest request) {

        return "redirect:/index";
    }
}
