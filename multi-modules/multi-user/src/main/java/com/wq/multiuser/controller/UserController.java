package com.wq.multiuser.controller;


import com.wq.multicommon.dto.Result;
import com.wq.multiuser.domain.entity.User;
import com.wq.multiuser.mapper.OrderPoolMapper;
import com.wq.multiuser.mapper.UserMapper;
import com.wq.multiuser.service.OrderPoolService;
import com.wq.multiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangqiang766
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderPoolMapper orderPoolMapper;

    @PostMapping("/insertInfos")
    @Transactional(rollbackFor = Exception.class)
    public Result insertInfos(){
        User user=new User();
        user.setUserName("test");
        user.setId(1);
        userMapper.updateById(user);
        String str=null;
        str.length();
        return Result.success();
    }
}