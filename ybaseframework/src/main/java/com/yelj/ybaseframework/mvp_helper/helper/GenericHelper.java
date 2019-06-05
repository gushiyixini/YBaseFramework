package com.yelj.ybaseframework.mvp_helper.helper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Author: Alex.ylj
 * 2019-06-04 17:06 Tuesday
 */
public class GenericHelper {

    public static <T> Class<T> getViewClass(Class<?> klass) {
        Type type = klass.getGenericSuperclass();
        if(!(type instanceof ParameterizedType)) return null;
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        if(types.length == 0) return null;
        return (Class<T>) types[0];
    }
}
