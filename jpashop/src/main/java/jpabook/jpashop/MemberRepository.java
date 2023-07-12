package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    //스프링부트가 이 어노테이션이 있으면 em을 주입해준다.
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);

        //굳이 id를 반환하는 이유?
        //보통은 리턴을 안주는데 아이디가 있으면 조회할 수 있어서 아이디정도 줌
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
