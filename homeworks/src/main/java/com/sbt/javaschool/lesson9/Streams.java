package com.sbt.javaschool.lesson9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {

    private List<T> list;

    public static <T> Streams<T> of(List<T> list) {
        Streams<T> streams = new Streams<>();
        streams.list = list;
        return streams;
    }


    public Streams<T> filter(Predicate<? super T> filter) {

        for (T element : this.list) {
            if (!filter.test(element)) {
                list.remove(element);
            }
        }
        return this;
    }

    public <E> Streams<E> transform(Function<T, E> transformingFunction) {
        List<E> list = new ArrayList<>();
        for (T elem : this.list) {
            list.add(transformingFunction.apply(elem));
        }
        Streams<E> streams = new Streams<>();
        streams.list = list;

        return streams;
    }

    public <K, U> Map<K, U> toMap(Function<T, K> keyFunction,
                                  Function<T, U> valueFunction,
                                  BinaryOperator<U> mergeFunction) {
        Map<K, U> map = new HashMap<>();
        for (T elem : this.list) {
            K key = keyFunction.apply(elem);
            if (map.containsKey(key)) {
                map.put(key, mergeFunction.apply(map.get(key), valueFunction.apply(elem)));
            } else {
                map.put(key, valueFunction.apply(elem));
            }
        }
        return map;
    }
}

