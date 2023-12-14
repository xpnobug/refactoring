package com.kdg.refactoring.kdgcommon.baseresult;

import lombok.Data;

/**
 * 统一返回格式类
 *
 * @Author 86136
 * @create 2023/11/30 16:53
 */
@Data
public class JsonObjectResult<T> {

    private int code;
    private String message;
    private T data;
    private long timestamp;


    public static <T> JsonObjectResult<T> success(T data) {
        JsonObjectResult<T> jsonObjectResult = new JsonObjectResult<>();
        jsonObjectResult.setCode(ReturnCode.RC200.getCode());
        jsonObjectResult.setMessage(ReturnCode.RC200.getMessage());
        jsonObjectResult.setData(data);
        return jsonObjectResult;
    }

    public static <T> JsonObjectResult<T> fail(int code, String message) {
        JsonObjectResult<T> jsonObjectResult = new JsonObjectResult<>();
        jsonObjectResult.setCode(code);
        jsonObjectResult.setMessage(message);
        return jsonObjectResult;
    }
}

