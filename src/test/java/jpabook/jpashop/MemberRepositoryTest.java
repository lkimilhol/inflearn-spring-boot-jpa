package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setName("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertEquals(findMember.getId(), member.getId());
        Assertions.assertEquals(findMember.getName(), member.getName());

        //아래가 동일하다.
        /*
        같은 트랜잭션 안에서 영속성 컨텍스트가 같이 때문에 같은 엔티티로 식별자이기 때문에 1차 캐시에서 같은
        데이터로 분류 된다. 때문에 스프링을 실행시켜도 select를 하지 않는다.
         */
        Assertions.assertEquals(findMember, member);
    }
}