package com.udemy.mvc.controller;

import com.udemy.mvc.domain.User;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class UserController {

    @RequestMapping("/user")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView("register"); // register.html 파일로 연결해라.
        mav.addObject("user", new User());
        return mav; // mav라는 ModelAndView에 "register"페이지와 Object인 User을 "user"로 묶어 전달함.
    }

    @PostMapping("submitUser")
    public ModelAndView submitUser(HttpServletRequest req){
        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");
        String rank = req.getParameter("rank");

        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setRank(rank);
        user.setRegistrationDate(LocalDate.now());
        user.setUpdateDate(LocalDate.now());

        ModelAndView mav = new ModelAndView("userDetails");
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping("submitUserReqParam")
    public String submitUser(
            @RequestParam("userId") String userId,
            @RequestParam("userName") String userName,
            @RequestParam("rank") String rank,
            Model model) {

        // User 객체 생성 및 값 설정
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setRank(rank);
        user.setRegistrationDate(LocalDate.now());
        user.setUpdateDate(LocalDate.now());

        // 모델에 데이터 담기
        model.addAttribute("user", user);

        // userDetails.html (뷰)로 이동
        return "userDetails";
    }
}
