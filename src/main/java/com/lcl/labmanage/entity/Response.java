package com.lcl.labmanage.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/**
 * Response data transfer object wrapping
 *
 */
public class Response<T> implements Serializable {
    /**
     * Response result
     */
    private Integer code;
    /**
     * Response message
     */
    private String msg;

    private Integer count;
    /**
     * Response data
     */
    private T data;

    public static <T> Response<T> success(T data){
        Response<T> response = new Response<>();
        response.setCode(0);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success(T data, String msg){
        Response<T> response = new Response<>();
        response.setCode(0);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }
    public static <T> Response<T> success(T data,Integer count){
        Response<T> response = new Response<>();
        response.setCode(0);
        response.setData(data);
        response.setCount(count);
        return response;
    }


    public static <T> Response<T> error(int result, String msg){
        Response<T> response = new Response<>();
        response.setCode(result);
        response.setMsg(msg);
        return response;
    }
    public static <T> Response<T> error(T data,int result, String msg){
        Response<T> response = new Response<>();
        response.setCode(result);
        response.setMsg(msg);
        return response;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Optional<T> getData() {
        return Optional.ofNullable(data);
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static class Builder<T> {

        private Response<T> response;

        public Builder() {
            this.response = new Response<>();
        }

        public Builder<T> result(int result) {
            this.response.setCode(result);
            return this;
        }

        public Builder<T> msg(String msg) {
            this.response.setMsg(msg);
            return this;
        }

        public Builder<T> data(T data) {
            this.response.setData(data);
            return this;
        }

        public Response<T> build() {
            Objects.requireNonNull(this.response.getCode(), "Result can not be null");
            //       Objects.requireNonNull(this.response.getMsg(), "Msg can not be null");
            return this.response;
        }
    }
}
