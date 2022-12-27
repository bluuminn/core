package com.bluuminn.core;

import com.bluuminn.core.discount.DiscountPolicy;
import com.bluuminn.core.discount.RateDiscountPolicy;
import com.bluuminn.core.member.MemberService;
import com.bluuminn.core.member.MemberServiceImpl;
import com.bluuminn.core.member.MemoryMemberRepository;
import com.bluuminn.core.order.OrderService;
import com.bluuminn.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() { // 빈의 이름은 기본적으로 메서드명으로 등록된다.
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
