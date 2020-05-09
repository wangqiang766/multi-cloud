package com.wq.multiuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wq.multicommon.utils.ObjectUtil;
import com.wq.multiuser.domain.entity.User;
import com.wq.multiuser.mapper.UserMapper;
import com.wq.multiuser.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangqiang01
 * @since 2019-12-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional
    public User queryUserInfo(String userName) {
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq(User.USER_NAME,userName);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public String queryUserAge(String userName) {
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq(User.USER_NAME,userName);
        User user=userMapper.selectOne(queryWrapper);
        String userAge= ObjectUtil.isNotNull(user) ? user.getUserName() : "";
        return userAge;
    }
}
