package com.zhang.model.common.dtos;

import com.zhang.model.common.enums.AppHttpCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 通用的结果返回类
 * @param <T>
 */
@Setter
@Getter
public class Result<T> implements Serializable {

    private String host;

    private Integer code;

    private String message;

    private Object data;

    public Result() {
        this.code = 200;
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static <T> Result<T> success(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> success(Object data) {
        Result<T> result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getErrorMessage());
        if(data != null) {
            result.setData(data);
        }
        return result;
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static <T> Result<T> error(AppHttpCodeEnum enums){
        return setAppHttpCodeEnum(enums,enums.getErrorMessage());
    }

    public static <T> Result<T> error(AppHttpCodeEnum enums, String errorMessage){
        return setAppHttpCodeEnum(enums,errorMessage);
    }

    public static <T> Result<T> setAppHttpCodeEnum(AppHttpCodeEnum enums){
        return success(enums.getCode(),enums.getErrorMessage());
    }

    private static <T> Result<T> setAppHttpCodeEnum(AppHttpCodeEnum enums, String errorMessage){
        return success(enums.getCode(),errorMessage);
    }
}
