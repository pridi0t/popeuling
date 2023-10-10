package com.popeuling.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 2083)
    private String gitUrl;

    @Column(nullable = false, length = 2083)
    private String serviceUrl;

    @Column(nullable = false)
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;

    @Column(nullable = false)
    private String title;

    private String thumbnail;

    @Lob
    private String Content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}