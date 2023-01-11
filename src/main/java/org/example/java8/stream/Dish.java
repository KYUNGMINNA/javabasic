package org.example.java8.stream;

import lombok.*;

import javax.print.DocFlavor;
import java.util.List;

//@AllArgsConstructor  -- 객체가 final이던 ,아니던 모든 변수 들어간 생성자
@Getter @ToString
@RequiredArgsConstructor  //final 필드만 골라서 초기화  --final 붙은 변수들만  있는 생성자
public class Dish {

    private final String name; //요리 이름
    private final boolean vegeterian; //채식주의자 여부
    private final int calories; //칼로리
    private final Type type; //요리 종류

    public enum Type{
        MEAT,FISH,OTHER
    }
    public static final List<Dish> menu = List.of(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 400, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

}
