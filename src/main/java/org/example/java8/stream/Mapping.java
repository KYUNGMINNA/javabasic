package org.example.java8.stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.example.java8.stream.Dish.menu;

public class Mapping {

    public static void main(String[] args) {
        //stream은 Collection에서 사용

        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        //.map(dish -> dish.getName())
        //.collect(Collectors.toList());
        //  collect 글씨 위에가서 ctrl+alt+v 하면 변수 만들어 줌

        System.out.println("dishNames.size() = " + dishNames.size());
        System.out.println("dishNames = " + dishNames);

        System.out.println("=====================================================");

        List<String> words = List.of(
                "safari", "chrome", "ms edge", "opera", "firefox"
        );

        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        //.map(str -> str.length()) -- str라는 T , Integer 라는 R이 나감  : T와 R이  같아도되고 ,달라도 된다.
        //.collect(toList());

        System.out.println("wordLengths = " + wordLengths);


        System.out.println("=====================================================");

        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        //nums의 값들ㅇ르 각각 제곱해서 새로운 리스트를 얻어내고 싶다
        List<Integer> squares = nums.stream()
                .map(n -> n * n)
                .collect(toList());
        //map에서는 T와 R의 타입이 동일할 수 있다.

        System.out.println("squares = " + squares);

        System.out.println("=====================================================");

        //요리 목록의 총 칼로리 수 구하기                  --범용적인것이 map이고   ,  추출하는게  int면 mapToInt  이렇게 사용가능 한데 - 여러 메서드 제공함 sum,average  등등..
        int totalCalories = menu.stream()
                .mapToInt(d -> d.getCalories())
                .sum();

        System.out.println("totalCalories = " + totalCalories);


        System.out.println("=====================================================");

        //육류요리의 평균 칼로리
        OptionalDouble meatAverageCalories = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .mapToInt(d -> d.getCalories())
                .average();


        System.out.println("meatAverageCalories = " + meatAverageCalories);

        //Optional은 자동 널 체크를 지원 : ifPresent (null이 아니면 괄호 안에 작업을 해라)
        meatAverageCalories.ifPresent(cal -> System.out.println("cal = " + cal));


        //만약 DB에서 게시물의 정보를 조회했는데  게시물이 없으면 null 반환 됨
        //Article article=repository.findByArticle(330)
        //if(article !=null) article.getTItle(); --이렇게 null체크를 반복해야 함 ..


        Double meatAverageCalories2 = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .mapToInt(d -> d.getCalories())
                .average()
                .getAsDouble();

        //getAsDouble로   그냥 Double 타입으로 사용 가능
        System.out.println("meatAverageCalories2 = " + meatAverageCalories2);
    }
}
