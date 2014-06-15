package com.huang.reflection.wrapper;

import com.huang.reflection.MetaObject;
import com.huang.reflection.factory.ObjectFactory;
import com.huang.reflection.property.PropertyTokenizer;

import java.util.List;

/**
 * Created by fenfanxiadewunai on 14-6-3.
 */
public interface ObjectWrapper {

    Object get(PropertyTokenizer prop);

    void set(PropertyTokenizer prop, Object value);

    String findProperty(String name, boolean useCamelCaseMapping);

    String[] getGetterNames();

    String[] getSetterNames();

    Class<?> getSetterType(String name);

    Class<?> getGetterType(String name);

    boolean hasSetter(String name);

    boolean hasGetter(String name);

    MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);

    boolean isCollection();

    public void add(Object element);

    public <E> void addAll(List<E> element);
}
