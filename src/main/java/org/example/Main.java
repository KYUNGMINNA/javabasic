package org.example;

import org.example.basic.Dancer;
import org.example.beans.Goods;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

import java.util.*;

public class Main {
    public static void main(String[] args) {


       /*
        2023-01-10
        IdolDancer idolDancer1 = new IdolDancer("아이돌팀1", "아이돌1");
        Dancer idolDancer2 = new IdolDancer("아이돌팀2", "아이돌2");
        Dancer idolDancer3 = new IdolDancer("아이돌팀3", "아이돌3");

        StreetDancer streetDancer1 = new StreetDancer("스트릿팀1", "스트릿댄서1");
        Dancer streetDancer2 = new StreetDancer("스트릿팀2", "스트릿댄서2");
        Dancer streetDancer3 = new StreetDancer("스트릿팀3", "스트릿댄서3");

        PerformanceTeam team = new PerformanceTeam();

        team.joinDancer(idolDancer1);
        team.joinDancer(streetDancer3);
        team.joinDancer(streetDancer2);
        team.joinDancer(idolDancer3);

        System.out.println();

        team.groupDance();


        List<Object> list = new ArrayList<>();
        Set<Object> set = new HashSet<>();
        Map<String, Object> map = new HashMap<>();

        for (Object o : list) {

        }

        idolDancer1.rap();
        idolDancer1.dance();
        idolDancer1.sing();

        streetDancer1.rap();
        streetDancer1.dance();

        */


        //2023-01-11
        //오전
        Goods goods1=new Goods("세탁기",300000);

        Goods goods2=new Goods("세탁기",300000);

        System.out.println("goods1="+goods1.toString());
        System.out.println(Integer.toHexString(goods1.hashCode()));
        //위의 2개 값 같음
        System.out.println(goods1.hashCode());

        System.out.println("-----------------------");
        System.out.println("goods2"+goods2);

        System.out.println("-----------------------");

        System.out.println("(goods1 == goods2) = " + (goods1 == goods2));
        System.out.println("(goods1 equals goods2) = " + (goods1.equals(goods2)));


        Set<String> set1=new HashSet<>();
        set1.add("짜장면");
        set1.add("짬뽕");
        set1.add("짜장면");
        System.out.println("set1="+set1);
        System.out.println("set1.size()="+set1.size());


        Set<Goods> set2=new HashSet<>();
        set2.add(goods1);
        set2.add(goods2);
        System.out.println("set2="+set2);
        System.out.println("set2.size()="+set2.size());


        System.out.println(goods1.hashCode());
        System.out.println(goods2.hashCode());

    }
}






