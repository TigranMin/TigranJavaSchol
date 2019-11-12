package lesson4;

import java.util.HashMap;
import java.util.Map;

public class CountMapIml<T> implements CountMap<T> {

    private Map<T, Integer> mapCounter = new HashMap<>();

    @Override
    public void add(T o) {
        mapCounter.computeIfPresent(o, (key, val) -> val + 1);
        mapCounter.putIfAbsent(o, 1);
    }

    @Override
    public int getCount(T o) {
        return mapCounter.getOrDefault(o, 0);
    }

    @Override
    public int remove(T o) {
        int count = mapCounter.get(o);
        mapCounter.remove(o);
        return count;
    }

    @Override
    public int size() {
        return mapCounter.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        source.toMap().forEach((key, val) -> mapCounter.merge(key, val, Integer::sum));
    }

    @Override
    public Map<T, Integer> toMap() {
        return mapCounter;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        mapCounter.forEach(destination::put);
    }

}
