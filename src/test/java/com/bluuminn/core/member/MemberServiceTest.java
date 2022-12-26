package com.bluuminn.core.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        // given 이런게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when 이렇게 하면
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then 이렇게 된다
        assertThat(member).isEqualTo(findMember);
    }
}