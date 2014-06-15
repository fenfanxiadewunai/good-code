package com.huang.exception;


import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

import static org.junit.Assert.assertEquals;

/**
 * Created by fenfanxiadewunai on 14-5-26.
 */

public class ExceptionUtilTest {

    @Test
    public void shouldUnwrapThrowable(){
        Exception exception = new Exception();
        assertEquals(exception, ExceptionUtil.unwrapThrowable(exception));
        assertEquals(exception, ExceptionUtil.unwrapThrowable(new InvocationTargetException(exception, "test")));
        assertEquals(exception, ExceptionUtil.unwrapThrowable(new UndeclaredThrowableException(exception, "test")));
        assertEquals(exception, ExceptionUtil.unwrapThrowable(new InvocationTargetException(new InvocationTargetException(exception, "test"), "test")));
        assertEquals(exception, ExceptionUtil.unwrapThrowable(new InvocationTargetException(new UndeclaredThrowableException(exception, "test"), "test")));

    }
}
