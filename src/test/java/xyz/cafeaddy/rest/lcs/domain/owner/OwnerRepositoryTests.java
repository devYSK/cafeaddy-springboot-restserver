package xyz.cafeaddy.rest.lcs.domain.owner;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OwnerRepositoryTests {

    @Autowired
    OwnerRepository ownerRepository;

    @After
    public void cleanUp() {
        ownerRepository.deleteAll();
    }

    @Test
    public void save_test() {

        //given
        ownerRepository.save(Owner.builder()
                .email("kim206gh@naver.com")
                .name("영수")
                .password("303")
                .phone("010-7441-4848")
                .build());

        //when
        List<Owner> ownerList = ownerRepository.findAll();

        //then
        Owner owner = ownerList.get(0);

        System.out.println("\n\n");
        log.info(owner.toString());
    }

}