package com.gy.ice.common.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gaoye
 * @date 2021/12/27 9:44
 * @desc 执行结果
 */
@Data
@Accessors(chain = true)
public class R<T> {
    private boolean state;
    private String msg;
    private T data;

    public boolean getState(){
        return state;
    }

    public static <T> R<T> success(){
        return success(null);
    }

    public static <T> R<T> success(T data){
       return success("执行成功!",data);
    }

    public static <T> R<T> success(String msg,T data){
        return buildResult(true,msg,data);
    }

    public static <T> R<T> failed(){
        return failed(null);
    }

    public static <T> R<T> failed(String msg){
        return failed(msg,null);
    }

    public static <T> R<T> failed(String msg,T data){
        return buildResult(false,msg,data);
    }

    private static <T> R<T> buildResult(boolean state, String msg, T data) {
        return new R<T>().setState(state).setMsg(msg).setData(data);
    }
}
