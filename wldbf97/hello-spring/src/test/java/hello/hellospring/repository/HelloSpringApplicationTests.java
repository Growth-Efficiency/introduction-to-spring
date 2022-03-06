package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HelloSpringApplicationTests {

    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
//        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring1").get();

        //then
        Assertions.assertEquals(result, member1);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring3");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring4");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        Assertions.assertEquals(result.size(), 2);
    }
}