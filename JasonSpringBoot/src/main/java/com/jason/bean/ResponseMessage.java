package com.jason.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: JasonSpringBoot
 * @description
 * @author: 大龄程序猿
 * @create: 2020-05-17 12:02
 **/
public class ResponseMessage {
    //状态码
    //100--成功  200--失败
    private int code;

    //提示信息
    private String msg;

    //用户返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<>();

    public static ResponseMessage success() {
        ResponseMessage result = new ResponseMessage();
        result.setCode(100);
        result.setMsg("处理成功！");
/*        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1",1);
        result.setExtend(map);*/
        return result;
    }

    public static ResponseMessage fail() {
        ResponseMessage result = new ResponseMessage();
        result.setCode(200);
        result.setMsg("处理失败！");
        return result;
    }

    public ResponseMessage add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
