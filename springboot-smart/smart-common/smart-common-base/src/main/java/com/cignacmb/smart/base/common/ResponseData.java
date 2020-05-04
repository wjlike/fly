package com.cignacmb.smart.base.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResponseData extends HashMap<String, Object> {

    /**
     * response相关的code
     */
    public enum RESPONSE_CODE {

        //通用code值
        BASE_CODE("code"),
        //消息code值
        MESSAGE_CODE("msg"),
        //数据code值
        DATA_CODE("data"),
        //成功标志的值
        SUCCESS_VALUE_0("0"),
        //业务异常的值
        FAIL_VALUE_9999("9999"),
        //上传成功的值
        SUCCESS_IMPORT_VALUE("1");

        private String value;

        private RESPONSE_CODE(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

    }

    public ResponseData addData(String key, Object value) {
        this.put(key, value);

        return this;
    }

    public ResponseData success() {
        return successWithMsg("success");
    }

    public ResponseData successWithMsg(Object msg) {
        this.put(RESPONSE_CODE.BASE_CODE.value, RESPONSE_CODE.SUCCESS_VALUE_0.value);
        this.put(RESPONSE_CODE.MESSAGE_CODE.value, msg);

        return this;
    }

    public ResponseData successWithData(Object data) {
        return this.addData(RESPONSE_CODE.DATA_CODE.value, data).success();
    }

    public ResponseData fail() {
        return failWithMsg("fail");
    }

    public ResponseData fail(Object message) {
        this.put(ReturnFormat.RESPONSE_CODE, ReturnFormat.RESPONSE_FAIL_CODE_9999);
        this.put(ReturnFormat.RESPONSE_MESSAGE_CODE, message);

        return this;
    }

    public ResponseData failWithMsg(Object msg) {
        this.put(RESPONSE_CODE.BASE_CODE.value, RESPONSE_CODE.FAIL_VALUE_9999.value);
        this.put(RESPONSE_CODE.MESSAGE_CODE.value, msg);

        return this;
    }

    public ResponseData successWithListMsg(List<String> list) {
        if (list == null) {
            list = new ArrayList<String>();
        }
        if (list.size() == 0) {
            list.add("保存成功");
        }

        this.put(RESPONSE_CODE.BASE_CODE.value, RESPONSE_CODE.SUCCESS_IMPORT_VALUE.value);
        this.put(RESPONSE_CODE.DATA_CODE.value, list);

        return this;
    }

}