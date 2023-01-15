package org.example.java8.compare;

import java.util.*;

import static java.util.Comparator.comparing;

public class Main {



    public static void main(String[] args) {


        List<Integer> nums = List.of(9, 4, 3, 2, 3, 6, 7);
        List<String> strs = new ArrayList<>();
        strs.add("홍길동");
        strs.add("banana");
        strs.add("apple");



        List<Person> pList =new ArrayList<>(List.of(
                                new Person("김철수", 33)
                                , new Person("홍길동", 16)
                                , new Person("박영희", 44)
                                , new Person("김희수", 22)
                                ));
        // ctrl p  :파라미터 정보
   /*     pList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });*/

        System.out.println("pList = " + pList);
        Collections.sort(pList);
        System.out.println("pList = " + pList);


        System.out.println("==========================================");
        pList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("pList = " + pList);



        //compareto를 오버라이딩 하지 않아도 , 오름차 정렬 할 수 있음
        pList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println("pList = " + pList);


        //이름 오름차 정렬
/*        pList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o1.getName());
            }
        });
        System.out.println("pList = " + pList);*/

        //사람 이름 오름차 정렬
        pList.sort((o1,  o2)-> o1.getAge()-o2.getAge());
        pList.sort(comparing(person -> person.getAge()));
        pList.sort(comparing(Person::getName));

        //sort 를 하면 내부 구조가 바뀌기 때문에 , 복사본을 만들어서 사용한다 .


        //내림차 정렬
        pList.sort(comparing(Person::getName).reversed());

        System.out.println("----------------------------------");

        System.out.println("strs = " + strs);
        strs.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("strs = " + strs);
    }
}
