package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지않음, 실무에서는 ConCurrentHashMap, AtomicLong 사용 고려
 *
 * 회원 저장소를 싱글톤 패턴을 적용 생성자를 private로 막아둠
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStroe() {
        store.clear();
    }
}
