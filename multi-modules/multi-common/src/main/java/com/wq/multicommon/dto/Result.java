package com.wq.multicommon.dto;

import lombok.Data;

@Data
public class Result<T> {
    private static String SUCCESS="0";
    private static String FAIL="-1";
    private static String ERROR="500";
    public String code;
    public String message;
    public T data;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static Result success(){
        return new Result(SUCCESS,"请求成功",null);
    }
    public static Result success(Object data){
        return new Result(SUCCESS,"请求成功",data);
    }
    public static Result fail(String message){
        return new Result(FAIL,message);
    }
}
