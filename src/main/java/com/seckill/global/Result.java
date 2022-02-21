package com.seckill.global;

import java.io.Serializable;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-21 17:34
 * @Version 1.0
 **/
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5620986329043107368L;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息描述
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 无返回内容成功
     *
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setCode("200");
        result.setSuccess(true);
        result.setMessage("操作成功");
        return result;
    }

    /**
     * 有返回内容成功
     *
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode("200");
        result.setMessage("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 无返回内容报错
     *
     * @return
     */
    public static Result error(String code, String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        result.setData("");
        return result;
    }

    /**
     * 无返回内容报错
     *
     * @return
     */
    public static Result error(CommonErrorCode errorCode) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getMessage());
        result.setData("");
        return result;
    }

    public Result() {
    }

    public Result(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Result(boolean success, String code) {
        this.success = success;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
