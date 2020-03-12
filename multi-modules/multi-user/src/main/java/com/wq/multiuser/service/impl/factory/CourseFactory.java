package com.wq.multiuser.service.impl.factory;

import com.wq.multiuser.service.CourseService;
import com.wq.multiuser.service.impl.JavaCourseServiceImpl;
import com.wq.multiuser.service.impl.PhpCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseFactory {

    @Autowired
    private JavaCourseServiceImpl javaCourseService;

    @Autowired
    private PhpCourseServiceImpl phpCourseService;

    public  CourseService getInstance(String courseName){
        if (null==courseName || "".equals(courseName)){
            return null;
        }
        if ("java".equals(courseName)){
            return javaCourseService;
        }
        if ("php".equals(courseName)){
            return phpCourseService;
        }
        return null;
    }

    public CourseService getInstance(Class<? extends CourseService> courseClass){
        if (courseClass == null) {
            return null;
        }
        try {
            return courseClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
