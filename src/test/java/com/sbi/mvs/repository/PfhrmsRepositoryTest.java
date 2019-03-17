package com.sbi.mvs.repository;

import com.sbi.mvs.entity.Pfhrms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ActiveProfiles("dev")
@Profile("dev")
@SpringBootTest
@RunWith(SpringRunner.class)
public class PfhrmsRepositoryTest {

    @Autowired
    private PfhrmsRepository pfhrmsRepository;

    @Test
    public void findAllByIdLike() {
        List<Pfhrms> usrs = pfhrmsRepository.findAllByPfIdStartingWith("1");
//        List<Pfhrms> usrs = pfhrmsRepository.findAll();
        System.out.println(usrs);
    }
}