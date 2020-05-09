package com.wq.multiuser.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Student implements Cloneable, Serializable {
    private Person person;

    private String schoolName;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
