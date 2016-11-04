package com.wolf.auth.controller;

import com.wolf.auth.service.UserService;
import com.wolf.auth.vo.UserVo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sdyang on 2016/10/29.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test", method = { RequestMethod.GET })
    public String test(Model model) throws NotFoundException {
        List<UserVo> userList = userService.findAll();
        model.addAttribute("users",userList);
        return "index";
    }
}
