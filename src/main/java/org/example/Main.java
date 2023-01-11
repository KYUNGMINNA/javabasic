package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

import java.util.*;

public class Main {
    public static void main(String[] args) {


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


    }
}






