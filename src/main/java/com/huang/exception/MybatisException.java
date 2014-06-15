package com.huang.exception;

/**
 * Created by fenfanxiadewunai on 14-6-3.
 */
public class MybatisException extends RuntimeException {

    private static final long serialVersionUID = 3880206998166270511L;

    public MybatisException() {
        super();
    }

    public MybatisException(String message) {
        super(message);
    }

    public MybatisException(String message, Throwable cause) {
        super(message, cause);
    }

    public MybatisException(Throwable cause) {
        super(cause);
    }

}

