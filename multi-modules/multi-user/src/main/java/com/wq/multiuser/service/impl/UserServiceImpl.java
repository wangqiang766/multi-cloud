package com.wq.multiuser.service.impl;

import com.wq.multiuser.domain.entity.User;
import com.wq.multiuser.mapper.UserMapper;
import com.wq.multiuser.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangqiang766
 * @since 2019-12-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
