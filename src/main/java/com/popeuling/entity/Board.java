package com.popeuling.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gitUrl;

    @Column(nullable = false)
    private String serviceUrl;

    @Column(nullable = false)
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;

    @Column(nullable = false)
    private String title;

    private String thumbnail;

    @Lob
    private String Content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Member member;
}