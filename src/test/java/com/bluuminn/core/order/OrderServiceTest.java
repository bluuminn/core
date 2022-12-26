package com.bluuminn.core.order;

import com.bluuminn.core.member.Grade;
import com.bluuminn.core.member.Member;
import com.bluuminn.core.member.MemberService;
import com.bluuminn.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10_000);
        assertThat(order.getDiscountPrice()).isEqualTo(1_000);
    }
}
