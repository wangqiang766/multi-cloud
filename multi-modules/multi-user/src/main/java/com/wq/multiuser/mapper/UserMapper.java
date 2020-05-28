package com.wq.multiuser.mapper;

import com.wq.multiuser.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangqiang766
 * @since 2019-12-30
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUserLists(String status);

}
