package codekat.jjodongSpring.repository;

import codekat.jjodongSpring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoyMemberRepositoryTest {
    MemoyMemberRepository repository = new MemoyMemberRepository();

    //각 테스트 마다 실행되는 초기화
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("홍길동");
        repository.save(member);
        Member result  = repository.findById(member.getId()).get();
        System.out.println("결과는 " + (member == result));
    }

    @Test
    public void findByName(){

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

//        System.out.println("결과는 " + (member1 == result));
        Assertions.assertEquals(member1, result);
        result = repository.findByName("spring2").get();
        Assertions.assertEquals(member2, result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("sp2");
        repository.save(member2);
        Member member = new Member();
        member.setName("홍길동");
        repository.save(member);

        List<Member> memList = repository.findAll();
        int i = 1;
        for (Member m:memList) {
            System.out.println("멤버"+ i++ +"\t"+m.toString());
        }
    }
}
