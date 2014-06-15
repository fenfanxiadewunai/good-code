package com.huang.reflection.invoker;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by fenfanxiadewunai on 14-5-26.
 */
public interface Invoker {
    Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

    Class<?> getType();
}
