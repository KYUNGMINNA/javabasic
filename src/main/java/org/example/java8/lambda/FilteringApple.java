package org.example.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class FilteringApple {

    /**
     * @Solution - try1 : 녹색사과를 필터링하는 메서드를 만들어야 함 .
     * @Problem
     * -만약 다른 색깔 사과를 피터링해야되는 경우?
     * -새로운 메서드를 또 만들어야 한다.
     */

    public  static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result=new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.getColor()==Color.GREEN){
                result.add(apple);
            }
        }

        return  result;
    }


    /**
     * @Solution - try 2 : 색상을 파라미터화 한다.
     * @Problem
     * - 만약에 필터기준이 색상이 아니라 무게였다면?
     * - 두번째 파라미터로 무게기준을 받아내는 메서드를 또 만들어야 한다.
     */
     public static List<Apple> filterApplesByColor(List<Apple> inventory,
                                                   Color color) {
         List<Apple> result=new ArrayList<>();
         for (Apple apple : inventory) {
             if(apple.getColor()==color){
                 result.add(apple);
             }
         }
         return  result;
     }


    public static List<Apple> filterApplesByWeightLessThan(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() <= weight) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * @Solution - try 3 : 동작을 파라미터화 한다. - 추상적 조건으로 필터링
     * @Problem
     * -과일이 사과가 아니라 오렌지면?
     * -과일이 아니라 가전제품이면 ?
     * - 새로운 필터 메서드와 인터페이스를  제작해야 된다.
     */
     public static  List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
         List<Apple> result = new ArrayList<>();
         for (Apple apple : inventory) {
             if (p.test(apple)) {
                 result.add(apple);
             }
         }
         return result;
     }


    /**
     * @Solution - try 4 : 제네릭 필터 메서드 생성
     *
     */

    public static <T> List<T> filter(List<T> inventory, GenericPredicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : inventory) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


    /**
     * 리스트와 변경 조건을 전달하면 리스트 내부의 값을 변경ㅈ건에 따라
     * 변환한 뒤 반환하는 map 이라는 메서드를 구현해 보세요
     * ex) map(appleList,apple -> apple.setColor(RED))
     *
     * ==>리스트 안의 모든 사과가 빨강색으로 변해야 한다.
     *
     * map(applyList,apple->apple.getColor())
     * =>리스트 안의 모든 사과의 색깔만 뽑앗 색깔만 담긴리스트 반환
     */


    //파라미터로 들어가는 타입과 ,나오는 타입이 다를 수 있어 T,R로 작성
    public static <T, R> List<R> map(List<T> list, GenericFunction<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            R r = mapper.apply(t);
            result.add(r);
        }
        return result;
    }


}
