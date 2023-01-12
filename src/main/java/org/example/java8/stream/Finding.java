package org.example.java8.stream;

import static org.example.java8.stream.Dish.menu;

public class Finding {

    public static void main(String[] args) {

        //anyMatch : 주어진 스트림에서 적어도 한 요소와 일치하는게 있는지 확인용 (T/F)
        //요리목록중에 채식주의가 먹을수 있는 요리가 하나라도 있는가?
        boolean flag1 = menu.stream()
                .anyMatch(Dish::isVegeterian);
                //.anyMatch(d -> d.isVegeterian());
                //anyMatch의 함수형 인터페이스가 Predicate라서 T/F로 나옴
        System.out.println("flag1 = " + flag1);

        System.out.println("========================================================================");
        //anyMatch는 단순히 T,F알려주는 용도
        boolean flag2 = menu.stream()
                .anyMatch(d -> d.getCalories() < 100);
        System.out.println("flag2 = " + flag2);

        System.out.println("========================================================================");

        //allMatch: 모든 요소가 조건에 일치하는지 확인
        //요리 목록의 모든 요리가 1000칼로리 미만인가?
        boolean flag3 = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println("flag3 = " + flag3);

        System.out.println("========================================================================");

        //nonMatch : allMatch의 반대 연산

        //stream의  filter() 메서드와 함께 사용할 수 있다.
    }
}
