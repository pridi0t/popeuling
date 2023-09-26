package com.popeuling.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Reply {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="bid")
//    private Board board;

    @Column(nullable = false)
    private String content;
}
