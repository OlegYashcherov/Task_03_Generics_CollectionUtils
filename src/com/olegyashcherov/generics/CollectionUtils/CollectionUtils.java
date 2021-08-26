package com.olegyashcherov.generics.CollectionUtils;

import java.util.*;

public final class CollectionUtils<T> {

    private CollectionUtils() {
    }

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }

    public static <T> List <? super T> limit(List<? extends T> source, int size) {
        List<T> dest = new ArrayList<>();
        if (size>= source.size()) {
            Collections.copy(dest, source);
        } else {
            for (int i = 0; i < size; i++) {
                dest.add(source.get(i));
            }
        }
        return dest;
    }

    public static <T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        return c1.stream().anyMatch(item1 -> c2.stream().anyMatch(item1::equals));
//        return c1.stream().anyMatch(c2::contains);
    }

    public static <T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> tList= new ArrayList<>();
        for (T element : list) {
            if (element.compareTo(min)>=0 && element.compareTo(max)<=0) {
                tList.add(element);
            }
        }

        Collections.sort(tList);
        return tList;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> tList= new ArrayList<>();
        for (T element : list) {
            if (comparator.compare(element, min) >= 0 && comparator.compare(max, element) >= 0) {
                    tList.add(element);
            }
        }
        tList.sort(comparator);
        return tList;
    }

}
