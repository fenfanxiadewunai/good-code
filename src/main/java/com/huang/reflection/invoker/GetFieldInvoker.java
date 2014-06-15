package com.huang.reflection.invoker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by fenfanxiadewunai on 14-5-26.
 */
public class GetFieldInvoker implements Invoker{


    private Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
        return field.get(target);
    }

    public Class<?> getType() {
        return field.getType();
    }


}

