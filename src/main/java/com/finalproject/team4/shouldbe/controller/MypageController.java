package com.finalproject.team4.shouldbe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.team4.shouldbe.service.MypageService;
import com.finalproject.team4.shouldbe.vo.MypageVO;

@Controller
public class MypageController {
    @Autowired
    MypageService service;

    @GetMapping("/mypage/change_user")
    public ModelAndView mypage_change_user(@SessionAttribute(name="logId") String userid) {
        ModelAndView mav = new ModelAndView();

        MypageVO myvo = service.mypage_info(userid);
        System.out.println(myvo.toString());
        mav.addObject("myvo", myvo);
        mav.setViewName("mypage/change_user");
        return mav;
    }
    
    @PostMapping("/mypage/editProfileOk")
    public ModelAndView mypageEidt(MypageVO vo){
        ModelAndView mav = new ModelAndView();
        System.out.println(vo.toString());

        int result = service.mypage_edit(vo);

        if(result>0) {
            mav.setViewName("mypage/change_user");
        }else{
            mav.setViewName("mypage/mypage_editResult");
        }
        return mav;
    }

    @GetMapping("/mypage/friend_user")
    public String mypage_friend_user() {
        return "mypage/friend_user";
    }

    @GetMapping("/mypage/post_user")
    public String mypage_post_user() {
        return "mypage/post_user";
    }

    @GetMapping("/mypage/save_user")
    public String mypage_save_user() {
        return "mypage/save_user";
    }

    @GetMapping("/mypage/withdraw_user")
    public String mypage_withdraw_user() {
        return "mypage/withdraw_user";
    }
}