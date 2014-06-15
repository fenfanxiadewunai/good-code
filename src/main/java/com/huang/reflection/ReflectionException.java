package com.huang.reflection;

import com.huang.exception.MybatisException;

/**
 * Created by fenfanxiadewunai on 14-6-3.
 */
public class ReflectionException extends MybatisException {
    private static final long serialVersionUID = 7642570221267566591L;

    public ReflectionException() {
        super();
    }

    public ReflectionException(String message) {
        super(message);
    }

    public ReflectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectionException(Throwable cause) {
        super(cause);
    }
}
