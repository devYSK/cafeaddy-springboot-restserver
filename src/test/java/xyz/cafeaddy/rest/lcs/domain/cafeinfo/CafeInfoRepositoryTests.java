package xyz.cafeaddy.rest.lcs.domain.cafeinfo;


import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;
import xyz.cafeaddy.rest.lcs.utils.PointUtil;
import xyz.cafeaddy.rest.lcs.web.dto.request.cafeinfo.CafeInfoListRequestDto;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CafeInfoRepositoryTests {

    @Autowired
    CafeInfoRepository cafeInfoRepository;

    @Autowired
    OwnerRepository ownerRepository;


//    @After
//    public void clean_up() {
//        cafeInfoRepository.deleteAll();
//        ownerRepository.deleteAll();
//    }


    @Test
    public void save_test() {
        //given

        Owner owner = ownerRepository.getOne(1L);

        CafeInfo cafeInfo = CafeInfo.builder()
                .businessNo("123-456-789")
                .name("스벅")
                .phone("010-7441-4848")
                .location(PointUtil.makePointFromCoords(37.5923780, 127.0763130))
                .owner(owner)
                .build();


        //when


        //then
        CafeInfo savedCafeInfo = cafeInfoRepository.save(cafeInfo);
        log.info("\n" + savedCafeInfo.toString() + "\n");

        Assertions.assertThat(owner.getId()).isEqualTo(cafeInfo.getOwner().getId());
    }

    @Test
    public void readOne() {
        Optional<CafeInfo> savedCafeInfo = cafeInfoRepository.findById(1L);
        log.info(savedCafeInfo.toString());
        log.info("x = " + savedCafeInfo.get().getLocation().getX() + "  y = " + savedCafeInfo.get().getLocation().getY()
                + " type = " + savedCafeInfo.get().getLocation().getClass().getTypeName());


    }


    @Test
    public void readAll() {
        List<CafeInfo> cafeInfoList = cafeInfoRepository.findAll();

        cafeInfoList.forEach(cafeInfo -> {
            System.out.println(cafeInfo + "\n");
        });

    }



    @Test
    public void aroundTest() {
//        Point point = PointUtil.makePointFromCoords(127.04227100, 37.6587700);
//        System.out.println(point.toString());
//        List<CafeInfo> aroundCafe = cafeInfoRepository.findByMBRContains( 127.06513600,37.65380900,  127.06513400, 37.65380700);

        CafeInfoListRequestDto dto = new CafeInfoListRequestDto(127.06513600,37.65380900,  127.05513400, 37.55380700);
        List<CafeInfo> aroundCafe = cafeInfoRepository.findByMBRContains(dto);

        aroundCafe.forEach(System.out::println);
    }

    @Test
    public void findByNameTest() {

        String keyword = "감각";

        List<CafeInfo> list = cafeInfoRepository.findAllByCafeName(keyword);

        System.out.println("keyword = " + keyword);
        System.out.println("size = " + list.size());
        for (CafeInfo cafeInfo : list) {
            System.out.println(cafeInfo.toString());
        }
    }

    @Test
    public void findAllByBrand() {
        String brandKeyword = "투";
        List<CafeBrandMapping> brand = cafeInfoRepository.findByBrandLikes(brandKeyword);
        brand.forEach(cafeBrandMapping -> {
            System.out.println(cafeBrandMapping.getBrand());
        });
    }


    @Test
    public void findAllBrandDistinct() {

        cafeInfoRepository.findAllBrand().forEach(cafeBrandMapping -> {
            System.out.print(cafeBrandMapping.getBrand());
        });

    }
}
