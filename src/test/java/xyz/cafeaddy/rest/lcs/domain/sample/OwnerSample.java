package xyz.cafeaddy.rest.lcs.domain.sample;


import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OwnerSample {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void sampleCreate() {
        Owner owner = Owner.builder()
                .email("kim206@naver.com")
                .password("dudtn")
                .auth("ADMIN")
                .name("김영수")
                .phone("010-7441-4848")
                .build();

        Owner newOwner = ownerRepository.save(owner);

        Assert.assertEquals(owner, newOwner);
    }
}
