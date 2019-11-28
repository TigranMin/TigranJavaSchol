package com.sbt.javaschool.lesson8;

import com.sbt.javaschool.lesson8.annotations.Cache;
import com.sbt.javaschool.lesson8.annotations.CacheType;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CachedProxy implements InvocationHandler {

    private static Map<String, Object> cache = new HashMap<>();
    private final Object object;
    private SerializerDeserializer ser;


    CachedProxy(Object object) throws FileNotFoundException {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnno = null;
        if (method.isAnnotationPresent(Cache.class)) {
            cacheAnno = method.getAnnotation(Cache.class);
            if (cacheAnno.cacheType() == CacheType.IN_MEMORY) {
                String key = object.getClass().getName() + method.getName() + Arrays.toString(args);
                if (cache.containsKey(key)) {
                    System.out.print("Returned from cache: ");
                    return cache.get(key);
                }
                Object result = method.invoke(object, args);
                cache.put(key, result);
                return result;
            } else if (cacheAnno.cacheType() == CacheType.FILE) {
                Object deserialize = ser.deserialize(cacheAnno.fileName());
                if (deserialize != null) {
                    return deserialize;
                } else {
                    Object result = method.invoke(object, args);
                    ser.serialize(cacheAnno.fileName(), result);
                    return result;
                }

            } else {
                throw new RuntimeException("No cache type was chosen");
            }
        }
        return method.invoke(object, args);
    }
}
