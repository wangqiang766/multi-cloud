package com.wq.multiuser.controller;


import com.wq.multicommon.dto.Result;
import com.wq.multiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangqiang01
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${test.url}")
    private String testUrl;
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationContext applicationContext;


    @PostMapping("/queryUserInfo")
    public Result queryUserInfo(HttpServletRequest request){
        String userName=request.getParameter("userName");
        return Result.success(userService.queryUserInfo(userName));
    }

}