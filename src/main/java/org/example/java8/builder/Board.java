package org.example.java8.builder;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Board {
    private Long id;
    private String title;

    private String content;
    private String writer;
}
