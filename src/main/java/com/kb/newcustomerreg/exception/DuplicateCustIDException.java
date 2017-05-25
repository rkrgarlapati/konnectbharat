package com.kb.newcustomerreg.exception;

/**
 * Created by garlapati on 10/30/2016.
 */
public class DuplicateCustIDException extends RuntimeException {

    public DuplicateCustIDException(String exceptionMsg) {
        super(exceptionMsg);
        this.exceptionMsg = exceptionMsg;
    }

    private String exceptionMsg;

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
