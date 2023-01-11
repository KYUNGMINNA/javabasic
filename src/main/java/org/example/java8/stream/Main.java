package org.example.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main {

    /*
        요리 목록에서 칼로리가 400 칼로리 보다 작은 요리들만 추출해서
        칼로리가 낮은 순서대로 오름차 정렬한 후
        그 요리의 이름들만 추출해서 리스트로 만들고 싶어요
    */

    //스트림을 사용하지 않은 코드
    public static List<String> getHealthyDishName1(List<Dish> menu){
        //400 칼로리 미만 요리만 담을것임
        List<Dish> lowCalroricDishes=new ArrayList<>();
        for (Dish dish : menu) {
            if(dish.getCalories()<400){
                lowCalroricDishes.add(dish);
            }
        }

        //카롤리 낮은 순으로 오름 차순 정렬
        lowCalroricDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories()-o2.getCalories();
            }
        });


        //요리의 이름을 담을 리스트
        List<String> dishNames=new ArrayList<>();
        for (Dish dish : lowCalroricDishes) {
                dishNames.add(dish.getName());

        }

        return dishNames;
    }

    //comparator ::비교기

    //스트림을 사용한 코드
    public static List<String> getHealthyDishName2(List<Dish> menu) {

        return menu.stream()
                .filter(d->d.getCalories()<400)
                .sorted(comparing(d->d.getCalories()))
                .map(Dish::getName)
                .collect(toList());
    }



    public static void main(String[] args) {
        List<String> dishName1=getHealthyDishName1(Dish.menu);
        System.out.println("dishName1 = " + dishName1);

        List<String> dishName2=getHealthyDishName2(Dish.menu);
        System.out.println("dishName2 = " + dishName2);

    }
}
