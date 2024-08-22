package com.example.demo.result;

import lombok.ToString;

@ToString
public class Result {
    private Object data;

    public Result() {
        super();
    }

    public Result(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}