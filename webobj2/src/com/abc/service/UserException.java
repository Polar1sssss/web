package com.abc.service;

/**
 * �Զ����쳣�ֻ࣬�������๹�������ɣ����㹹�����
 * @author hujtb
 * @create on 2018-08-20-14:03
 */
public class UserException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
