package com.cignacmb.smart.base.utils.exception;

import com.cignacmb.smart.base.common.ResponseData;

/**
 * 自定义业务异常
 * @author r9wuxx
 */
public class BusinessException extends RuntimeException {

    public BusinessException(){ }

    private String status;
    private String error;

    public BusinessException(String error){
        this.status = ResponseData.RESPONSE_CODE.FAIL_VALUE_9999.getValue();
        this.error = error;
    }

    public BusinessException(String status,String error){
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
