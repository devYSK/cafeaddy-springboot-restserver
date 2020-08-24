package xyz.cafeaddy.rest.lcs.domain.cafeinfo;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CafeInfoRepositoryTests {

    @Autowired
    CafeInfoRepository cafeInfoRepository;

    @Autowired
    OwnerRepository ownerRepository;


    @After
    public void clean_up() {
        cafeInfoRepository.deleteAll();
        ownerRepository.deleteAll();
    }


    @Test
    public void save_test() {
        //given

        Owner owner = Owner.builder()
                .email("kim206gh@naver.com")
                .name("영수")
                .password("303")
                .phone("010-7441-4848")
                .build();

        ownerRepository.save(owner);


        cafeInfoRepository.save(CafeInfo.builder()
                .businessNo("123-456-789")
                .name("스벅")
                .phone("010-7441-4848")
                .latitude(36.5)
                .longitude(36.5)
                .owner(owner)
                .build());

        //when
        List<CafeInfo> cafeInfoList  = cafeInfoRepository.findAll();

        //then
        CafeInfo cafeInfo = cafeInfoList.get(0);
        log.info(cafeInfo.toString());
        log.debug(owner.toString());

        Assertions.assertThat(owner.getId()).isEqualTo(cafeInfo.getOwner().getId());
    }
}