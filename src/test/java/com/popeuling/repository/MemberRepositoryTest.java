package com.popeuling.repository;

import com.popeuling.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeAll
    static void memberCreateTest(@Autowired MemberRepository memberRepository) {
        Member member = new Member();
        member.setUsername("test@naver.com");
        member.setPassword("12312312311");
        member.setNickname("test");
        memberRepository.save(member);
    }

    @Test
    void memberReadTest() {
        Optional<Member> findMember = memberRepository.findById(1L);
        Member member = findMember.get();
        Assertions.assertThat(member.getUsername()).isEqualTo("test@naver.com");
    }

    @Test
    @Transactional
    void memberUpdateTest() {
        Optional<Member> findMember = memberRepository.findById(1L);
        Member member = findMember.get();
        member.setNickname("test2");
        memberRepository.save(member);

        Member member2 = memberRepository.findById(1L).get();
        Assertions.assertThat(member2.getNickname()).isEqualTo("test2");
    }
}