package com.wq.multicommon.feign;

import com.wq.multicommon.dto.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserFeign {
    String profix="/user";

    @PostMapping(profix+"/queryUserAge")
    String queryUserAge(@RequestParam("userName") String userName);
}
