package com.wq.multiuser.controller;

import com.wq.multicommon.dto.Result;
import com.wq.multiuser.service.CourseService;
import com.wq.multiuser.service.impl.PhpCourseServiceImpl;
import com.wq.multiuser.service.impl.factory.CourseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private CourseFactory courseFactory;

    @PostMapping("/applyCourse")
    public Result applyCourse(@RequestParam(value = "courseName") String courseName){
        CourseService courseService=courseFactory.getInstance(courseName);
        courseService.course();
        CourseService courseService1=courseFactory.getInstance(PhpCourseServiceImpl.class);
        courseService1.course();
        return Result.success();
    }
}
