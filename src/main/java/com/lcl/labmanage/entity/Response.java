package com.lcl.labmanage.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/**
 * Response data transfer object wrapping
 *
 * @author tianchanglian
 * @date 2019/08/16
 */
public class Response<T> implements Serializable {
    /**
     * Response result
     */
    private Integer result;
    /**
     * Response message
     */
    private String msg;
    /**
     * Response data
     */
    private T data;

    public static <T> Response<T> success(T data){
        Response<T> response = new Response<>();
        response.setResult(0);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success(T data, String msg){
        Response<T> response = new Response<>();
        response.setResult(0);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> error(int result, String msg){
        Response<T> response = new Response<>();
        response.setResult(result);
        response.setMsg(msg);
        return response;
    }
    public static <T> Response<T> error(T data,int result, String msg){
        Response<T> response = new Response<>();
        response.setResult(result);
        response.setMsg(msg);
        return response;
    }



    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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



    public static class Builder<T> {

        private Response<T> response;

        public Builder() {
            this.response = new Response<>();
        }

        public Builder<T> result(int result) {
            this.response.setResult(result);
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
            Objects.requireNonNull(this.response.getResult(), "Result can not be null");
            //       Objects.requireNonNull(this.response.getMsg(), "Msg can not be null");
            return this.response;
        }
    }
}
