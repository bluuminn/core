package com.bluuminn.core;

import com.bluuminn.core.discount.FixDiscountPolicy;
import com.bluuminn.core.member.MemberService;
import com.bluuminn.core.member.MemberServiceImpl;
import com.bluuminn.core.member.MemoryMemberRepository;
import com.bluuminn.core.order.OrderService;
import com.bluuminn.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
