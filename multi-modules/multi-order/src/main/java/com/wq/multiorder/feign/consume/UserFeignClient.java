package com.wq.multiorder.feign.consume;

import com.wq.multicommon.feign.UserFeign;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "multi-user-server",contextId = "userFeignClient")
public interface UserFeignClient extends UserFeign {
}
