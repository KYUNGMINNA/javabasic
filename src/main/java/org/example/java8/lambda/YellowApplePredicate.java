package org.example.java8.lambda;

public class YellowApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor()==Color.YELLOW;
    }
}
