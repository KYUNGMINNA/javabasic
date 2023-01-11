package org.example.java8.lambda;

@FunctionalInterface
public interface GenericPredicate<T> {
    boolean test(T t);
}
