package com.wq.multiuser.controller;


import com.wq.multicommon.dto.Result;
import com.wq.multiuser.mapper.UserMapper;
import com.wq.multiuser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "用户接口",description = "用户接口")
public class UserController {
    @Value("${test.url}")
    private String testUrl;
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserMapper userMapper;


    @PostMapping("/queryUserInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",dataType = "String",required = true,paramType = "query")
    })
    @ApiOperation(value = "查询用户信息接口",notes = "查询用户信息接口",response = Result.class)
    public Result queryUserInfo(HttpServletRequest request){
        return Result.success(userMapper.selectUserLists("1"));
    }

}