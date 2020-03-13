package com.wq.multicommon.feign;

import com.wq.multicommon.dto.Result;
import org.springframework.web.bind.annotation.PostMapping;

public interface UserFeign {
    public static String profix="/user";

    @PostMapping(profix+"/insertInfos")
    Result insertInfos();
}
