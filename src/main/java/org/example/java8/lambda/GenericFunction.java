package org.example.java8.lambda;


/**
 *
 * @param <T> -소비될 객체의 타입 :데이터 추출 대상 ex)사과 ,세탁기 ...
 * @param <R> -소비객체에서 추출한 값의 타입 : ex)사과의 색상, 세탁기의 제조사 이름
 */
@FunctionalInterface
public interface GenericFunction<T,R> {
    /**
     *
     * @param t - 데이터 추출 대상 객체
     * @return R - 추출된 데이터
     */
    R apply(T t);

}
