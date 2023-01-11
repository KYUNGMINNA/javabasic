package org.example.java8.compare;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode             //객체를 비교 할 수 있게 하는 방법
public class Person  implements Comparable<Person>{
    private String name;
    private int age;


    //public int compareTo(Person this,Person o)  ::모든 메서드에 다 숨겨져 있음
    @Override  //정렬 기준을 만듦
    public int compareTo(Person o) {
        /*
            비교 대상 객체 2개를 전달 받아서
           (this , o )

           비교 대상(o)이  더 크면 음수,
           같으면 0
           작으면 양수 리턴
        * */
        return this.age-o.getAge();
    }
}
