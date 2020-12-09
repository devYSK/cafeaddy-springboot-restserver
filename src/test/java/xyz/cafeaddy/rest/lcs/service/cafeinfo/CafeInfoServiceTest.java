package xyz.cafeaddy.rest.lcs.service.cafeinfo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CafeInfoServiceTest {

    @Autowired
    CafeInfoService cafeInfoService;

    @Test
    @Transactional
    public void findAll() {
        cafeInfoService.findAll()
                .forEach(cafeInfoListResponseDto -> {
                    System.out.println(cafeInfoListResponseDto.getSeatInfos());
                });
    }

    @Test
    public void findAllByKeyword() {
        String keyword = "투썸플";

        cafeInfoService.findAllCafeByName(keyword)
                .forEach(System.out::println);
    }

    @Test
    public void findAllBrandDistinct() {
        List<String> cafeBrandNames = cafeInfoService.findAllBrandDistinct();

        cafeBrandNames.forEach(System.out::println);

    }


}