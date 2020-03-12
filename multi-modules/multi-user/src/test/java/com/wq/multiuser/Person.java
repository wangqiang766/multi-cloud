package com.wq.multiuser;

import cn.hutool.core.clone.CloneSupport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class Person implements Serializable {
    private String firstName;

    private String lastName;
    @NonNull
    private Integer age;
}
