package com.sbt.javaschool.lesson6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CachedProxy implements InvocationHandler {

    private static Map<String, Object> cache = new HashMap<>();

    private final Object object;

    CachedProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String key = object.getClass().getName() + method.getName() + Arrays.toString(args);
        if (cache.containsKey(key)) {
            System.out.print("Returned from cache: ");
            return cache.get(key);
        }
        Object result = method.invoke(object, args);
        cache.put(key, result);
        return result;
    }
}
