package com.wq.multiuser.service.impl;

import com.wq.multiuser.service.CourseService;
import com.wq.multiuser.service.impl.abstracts.AbstractCourseService;
import org.springframework.stereotype.Service;

@Service
public class JavaCourseServiceImpl extends AbstractCourseService {
    @Override
    public void course() {
        System.out.println(schoolName);
        System.out.println("this is java course");
    }
}
