package com.wq.multiuser.controller;


import com.wq.multicommon.dto.Result;
import com.wq.multiuser.domain.entity.User;
import com.wq.multiuser.mapper.OrderPoolMapper;
import com.wq.multiuser.mapper.UserMapper;
import com.wq.multiuser.service.OrderPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
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
    @Value("${test.url}")
    private String testUrl;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderPoolMapper orderPoolMapper;
    @Autowired
    private OrderPoolService orderPoolService;
    @Autowired
    private ApplicationContext applicationContext;


    @PostMapping("/insertInfos")
    @Transactional(rollbackFor = Exception.class)
    public Result insertInfos(){
        User user=new User();
        user.setUserName("test");
        user.setId(1);
        userMapper.updateById(user);
        return Result.success();
    }
    @GetMapping("/testReadProps")
    public  Result testReadProps(){
        return Result.success(testUrl);
    }
    @GetMapping("/testBean")
    public Result testBean(){
        System.out.println(applicationContext.getBean("orderPoolServiceImpl"));
        System.out.println(orderPoolService);
        System.out.println(orderPoolService);
        System.out.println(applicationContext.getBean("orderPoolServiceImpl"));
        return Result.success();
    }
}