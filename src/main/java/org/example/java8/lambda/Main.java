package org.example.java8.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import static org.example.java8.lambda.Color.*;
import static org.example.java8.lambda.FilteringApple.*;

public class Main {
    //람다 기초 2

    //무게가 100 그램 이하인 사과 필터 조건 클래스 : 내부 클래스
    public static class LightApplePredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight()<=100;
        }
    }










    public static void main(String[] args) {







        //사과 바구니 생성
        List<Apple> appleList= List.of(
                new Apple(80,GREEN)
                ,new Apple(155, GREEN)
                ,new Apple(120, RED)
                ,new Apple(97, RED)
                ,new Apple(200, GREEN)
                ,new Apple(50, RED)
                ,new Apple(85, YELLOW)
                ,new Apple(75, YELLOW)


        );


        //람다 기초 1

        List<Apple> greenAPples=
                filterGreenApples(appleList);

        System.out.println("녹색 사과 필터링");
        for (Apple greenAPple : greenAPples) {
            System.out.println(greenAPple);
        }
        System.out.println("------------------------------------");




        System.out.println("원하는 색 사과 필터링");
        List<Apple> wantedColorApples=filterApplesByColor(appleList,YELLOW);
        for (Apple wantedColorApple : wantedColorApples) {
            System.out.println(wantedColorApple);
        }
        System.out.println("------------------------------------");

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //람다 기초 2

        System.out.println("원하는 조건으로 필터링");
        //노랑 사과만 필터링
        List<Apple> yellowApples=filterApples(appleList,new YellowApplePredicate());
        for (Apple yellowApple : yellowApples) {
            System.out.println(yellowApple);
        }
        //동작을 추상적으로 만들어서 ,이를 구현한 클래스를 만들어야 함 ->매번 새 클래스 파일을 만들어야함
        System.out.println(":::::::::::::::::::::::::::::::::::");


        //무게가 100그램 이하인 사과만 필터링(내부 클래스) -> 새 클래스 파일 생성의 번거로움을 줄이고자 내부 클래스로 제작
        List<Apple> lightApples=filterApples(appleList,new LightApplePredicate());
        for (Apple lightApple : lightApples) {
            System.out.println(lightApple);
        }
        System.out.println(":::::::::::::::::::::::::::::::::::");

        //무게가 100그램 보다  큰 사과만 필터링(익명 클래스) ->내부 클래스의 번잡함을 줄이고자 익명 클래스 제작
        List<Apple> heavypples=filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>100;
            }
        });

        for (Apple heavypple : heavypples) {
            System.out.println(heavypple);
        }
        System.out.println(":::::::::::::::::::::::::::::::::::");

        //녹색 사과만 필터링 - 람다 사용  ->익명 클래스를 없애려고 람다를 사용
        //람다 사용 전제 조건 : 인터페이스의 추상메서드가 단 하나일 것 !
        //람다가 오버라이딩하는 메서드가 단 한줄일 경우 중괄호 생략 가능
        //그 한줄이 리턴문이라면 return 키워드 생략 가능
        //파라미터가 단 한개라면 소괄호 생략 가능 :파라미터 이름은 자유롭게 작성
        List<Apple> greenAppleList=filterApples(appleList,a->
             a.getColor()==GREEN
        );

        //빨간색 사과면서 100그램 이상인 사과만 필터링
        // 람다 메서드가 두줄 이상이면 { } 생략 불가
        filterApples(appleList,
           apple-> {
               System.out.println("사과 필터링 한다 !!!");
               return apple.getColor() == RED && apple.getWeight() >= 100;
           });

        //람다식 만들 때 new 인터페이스() { @Override  } 이런 상태로 만들어둔 후
        // 람다식에서 쓸 코드를 제외하고 지우는게 좋다

        // 사과를 필터랑 할 때 동작을 추상화하여 색상, 무게 ,당도 이런 기준으로 바뀌어도 유연하게 대응이 가능
        //그러나 사과가 아닌 가전제품 , 아니면 오렌지 와 같이 새로운 상품이면
        // 새 인터페이스와 , 해당 상품을 필터링 하는 메서드를 또 제작해야 함
        // --> 이를 해결 한게 제네릭 필터 메서드

        //////////////////////////////////////////////////////////////////////////////////////


        System.out.println("제네릭 필터 메서드 ");
        List<Apple> appleFilter=filter(appleList,a -> a.getColor()==RED);
        System.out.println(appleFilter);



        List<Integer> numbers=List.of(
                1,2,3,4,5,6,7,8,9,10
        );

        //짝수만 필터링
        List<Integer> evenNumbers=filter(numbers,n->n%2==0);
        System.out.println(evenNumbers);





        //사과 리스트에서 사과의 색상만 추출하여 새로운 색상 리스트를 반환
        /*

         map(appleList, new GenericFunction<Apple, Object>() {
            @Override
            public Object apply(Apple apple) {
                return apple.getColor()
            }
        });

         List<Color> colors=map(appleList, new GenericFunction<Apple, Color>() {
            @Override
            public Color apply(Apple apple) {
                return apple.getColor();
            }
        });
        */
        //람다식 위에 ctrl enter 눌러서 람다를 메서드 참조로 바꾸기와 클릭
        List<Color> colors=map(appleList,  apple -> apple.getColor());
        System.out.println("colors = " + colors);
        //Readme 메서드 참조
        List<Color> colors2=map(appleList,  Apple::getColor);


        List<Integer> weightList=map(appleList,a->a.getWeight());
        System.out.println("weightList = " + weightList);


        //DB의 여러 컬럼중 특정 몇개만 보여주는 DTO 객체 
        List<AppleInfo> appleInfos=map(appleList,a->new AppleInfo(a.getColor(),a.getWeight()));
        System.out.println("appleInfos = " + appleInfos);

        //Readme 생성자 참조
        List<AppleInfo> appleInfos2=map(appleList,AppleInfo::new);


        //전체 사과색 변경
        List<Apple> yellows=map(appleList,a->{
            a.setColor(YELLOW);
            return a;
        });
        for (Apple yellow : yellows) {
            System.out.println("yellow = " + yellow);
        }
    }
    
    //사과에서 필요한 데이터 몇개만 추출  --DTO객체
    @Getter @ToString 
    @AllArgsConstructor @NoArgsConstructor
    public static class AppleInfo{
         private Color color;
         private int weight;

        public AppleInfo(Apple a) {
            this.color=a.getColor();
            this.weight=a.getWeight();
        }
    }


}
