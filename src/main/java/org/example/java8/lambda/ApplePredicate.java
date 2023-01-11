package org.example.java8.lambda;


@FunctionalInterface  // 람다를 사용할 수 있는 인터페이스인지 검증 =추상 메서드가 1개인지 검증
public interface ApplePredicate {

    //사과를 주고 필터 조건을 오버라이딩하면 참 ,거짓을 반환
    boolean test(Apple apple);


    //인터페이스는  추상 메서드만 추가가 가능했지만
    // 자바1.8에서 default , static  메서드 추가됨
    // default void add() :로 선언하게 되면 메서드 구현 강제 안함


}
