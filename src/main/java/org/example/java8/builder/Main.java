package org.example.java8.builder;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        //회원 정보 생성
        Member m = Member.builder()
                .account("abc1234")
                .password("1234")
                .age(22)
                .regDate(LocalDateTime.now())
                .build();

        Board board=Board.builder()
                .content("글내용 블라블라")
                .writer("김똘기")
                .id(100L)
                .title("제목이야")
                .build();


    }
}
