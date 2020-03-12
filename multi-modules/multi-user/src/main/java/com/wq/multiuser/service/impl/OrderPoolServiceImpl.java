package com.wq.multiuser.service.impl;

import com.wq.multiuser.domain.entity.OrderPool;
import com.wq.multiuser.mapper.OrderPoolMapper;
import com.wq.multiuser.service.OrderPoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.multiuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
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
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE )
public class OrderPoolServiceImpl extends ServiceImpl<OrderPoolMapper, OrderPool> implements OrderPoolService {

}
