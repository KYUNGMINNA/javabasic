package org.example.java8.stream.practice;

import org.example.java8.anonymous.Calculator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.lang.System.setOut;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        //연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        // List<Transaction>
        List<Transaction> tr2021 = transactions.stream()
                .filter(t -> t.getYear() == 2021)
//                .sorted(comparing(Transaction::getValue).reversed()) // 내림차
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        tr2021.forEach(out::println);


        out.println("=============================================");

        // 연습 2: 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        //List<String >
        // 거래 목록에서 거래자들을 추출한담에 거래자 안에 있는 도시 이름을 추출

        // filter 는  10개중에  조건에 맞는 3개를  필터링  --즉 , 일부만 가져옴
        // map  :: 1o개중에 10개를 가져오는데 조건에 맞게 추출
        List<String> cities = transactions.stream()
                                            .map(d -> d.getTrader().getCity())
                                            .distinct()
                                            .collect(toList());

        out.println("cities = " + cities);

        out.println("=============================================");

        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자 리스트로 이름순으로 오름차정렬.
        //List<Trader>
        List<Trader> cambridge=transactions.stream()
                .map(t->t.getTrader()) // 거래목록에서 거래자만 추출하기 위해  map을 사용
                .filter(d -> d.getCity().equals("Cambridge")) //거래자의 정보에서 도시 이름이 같은것 필터링
                .distinct()
                .sorted(comparing(Trader::getName))
                //.sorted(comparing(td->td.getName()))
                .collect(toList());

        out.println("cambridge = " + cambridge);
        out.println("=============================================");
        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환
        List<String> names=transactions.stream()
                .map(t->t.getTrader().getName())
                .distinct()
                .sorted() // 정렬 대상이 String이나 숫자 타입이면 Comparator를 안써도 정렬
                .collect(toList());
        out.println("names = " + names);
    }
}
