package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    // 아래 코드는 기능을 확장해서 변경하면, 클라이언트 코드에 영향을 주기 때문에 OCP를 위반
    // 인터페이스가 아닌 구현 클래스를 의존하고 있기 때문에 DIP도 위반
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
