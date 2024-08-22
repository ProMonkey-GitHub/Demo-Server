package com.example.demo.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Result {

    // 结果数据
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
//
//    @Override
//    public String toString() {
//        return "Result{" +
//                "code=" + this.code +
//                ", msg='" + this.msg + '\'' +
//                ", data=" + this.data +
//                '}';
//    }
}