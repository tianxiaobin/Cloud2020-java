package com.alone.api;

/**
 * @author alone
 * @date 2020/6/18
 * @desciption 封装API的错误码
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
