package com.example.jpaMaker.Domain;

import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTest{

    private @Autowired MemberRepository repo;

    @Test
    void test1() {

        Member user1 = new Member();
        user1.setId(UUID.randomUUID());
        user1.setUserName("강민준");
        repo.save(user1);
        log.info("userInfo = " + user1);


    }
    
    @Test
    void test2() {
        String userName = "Update_Name2";
        String id;
        Member findByUserName = repo.findByUserName("강민준");
       
        log.info("findByUserName = " + findByUserName.getUserName());

        Assertions.assertThat(findByUserName.getUserName().equals("강민준"));

        //findByUserName.setId(UUID.randomUUID());
        findByUserName.setUserName(userName);

        Member check = repo.save(findByUserName);
        log.info("check = " + check);

        

    }

    @Test
    void test3(){




    }
}
