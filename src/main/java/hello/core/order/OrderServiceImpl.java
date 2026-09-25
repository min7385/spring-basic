package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    /*
    * 인터페이스와 구현체 모두 의존하고 있다.
    * 이후 할인정책을 FixDiscountPolicy에서 RateDiscountPolicy로 변경할 때,
    * OrderServiceImpl를 수정해야 된다.
    * => DIP 위반
    * */
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;  // Interface에만 의존하도록 변경

    // 생성자를 통해 어떤 구현 객체가 주입될지 알 수 없다. 오직 외부 AppConfig에서 결정한다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // discountPolicy가 null이 되어 nullPointException

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
