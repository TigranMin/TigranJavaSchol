package lesson4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static <T> List limit(List<? extends T> source, int size) {
        source.removeIf(a -> (source.indexOf(a) >= size));
        return source;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? extends T> removeFrom, List<? extends T> c2) {
        removeFrom.removeIf(c2::contains);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        boolean contains = false;
        for (T e : c2) {
            if (c1.contains(e)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public static<T> List range(List<? extends T> list, T min, Object max) {
        List<? extends T> rangedList = new ArrayList<>(list);
        Comparator<T> comparator = Comparator.comparing(Object::hashCode);
        rangedList.sort(comparator);
        rangedList.removeIf(a -> a.hashCode() <= min.hashCode() && a.hashCode() >= max.hashCode());
        return rangedList;
    }

    public static<T> List range(List<? extends T> list, Object min, Object max, Comparator<T> comparator) {
        List<? extends T> rangedList = new ArrayList<>(list);
        rangedList.sort(comparator);
        rangedList.removeIf(a -> a.hashCode() <= min.hashCode() && a.hashCode() >= max.hashCode());
        return rangedList;
    }

}


