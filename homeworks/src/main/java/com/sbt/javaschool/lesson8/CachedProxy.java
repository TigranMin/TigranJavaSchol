package com.sbt.javaschool.lesson8;

import com.sbt.javaschool.lesson8.annotations.Cache;
import com.sbt.javaschool.lesson8.annotations.CacheType;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachedProxy implements InvocationHandler {

    private static Map<String, Object> cache = new HashMap<>();
    private final Object object;
    private SerializerDeserializer ser;


    CachedProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnno;
        if (method.isAnnotationPresent(Cache.class)) {
            cacheAnno = method.getAnnotation(Cache.class);
            if (cacheAnno.cacheType() == CacheType.IN_MEMORY) {
                String key = object.getClass().getName() + method.getName() + Arrays.toString(args);
                if (cache.containsKey(key)) {
                    System.out.print("Returned from memory cache: ");
                    return cache.get(key);
                }
                Object result = method.invoke(object, args);
                if (result instanceof List) {
                    cache.put(key, ((List) result).subList(0, cacheAnno.listList()));
                } else {
                    cache.put(key, result);
                }
                return result;
            } else if (cacheAnno.cacheType() == CacheType.FILE) {
                Object result = ser.deserialize(cacheAnno.fileName());
                if (result != null) {
                    System.out.println("Returned from file cache: ");
                    return result;
                } else {
                    result = method.invoke(object, args);
                    ser.serialize(cacheAnno.fileName(), result, cacheAnno.listList());
                    return result;
                }
            }
        }
        return method.invoke(object, args);
    }
}
