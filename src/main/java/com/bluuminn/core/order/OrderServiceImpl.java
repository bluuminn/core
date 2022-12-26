package com.bluuminn.core.order;

import com.bluuminn.core.discount.DiscountPolicy;
import com.bluuminn.core.discount.FixDiscountPolicy;
import com.bluuminn.core.member.Member;
import com.bluuminn.core.member.MemberRepository;
import com.bluuminn.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
