package xyz.cafeaddy.rest.lcs.domain.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfo;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfoRepository;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CafeInfoSample {

    @Autowired
    private CafeInfoRepository cafeInfoRepository;


    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void sampleCreate() {
        List<String> nameList = Arrays.asList("단조카페", "카페 오르테", "스타벅스 중랑역점",
                "투썸플레이스 중랑역점", "이디야 중랑역점", "스타벅스 노원역점", "투썸플레이스 노원 문화의거리점",
                "할리스커피 노원 문화의거리점", "커피스미스 노원 롯데점", "BROSIS", "이디야 지행역점", "스타벅스 지행역점",
                "공차 동두천지행점", "브루잉 카페", "카페레블");

        List<String> addList = Arrays.asList("서울특별시 중랑구 면목동 번지 3층 185-1 보은빌딩", "면목동 186-83번지 1층 중랑구 서울특별시 KR", "서울특별시 중랑구 상봉동 130-3",
                "상봉동 130-166번지 2층 동성빌딩 중랑구 서울특별시 KR", "서울특별시 중랑구 상봉동 130-99", "서울특별시 노원구 상계6.7동 동일로 1413", "서울특별시 노원구 상계2동 상계로 69 투썸플레이스 2층",
                "서울특별시 노원구 상계6.7동 노해로81길 22-26", "서울특별시 노원구 상계동 동일로 1414", "경기도 동두천시 송내동 평화로2313번길 7-26", "번지, 721 지행동 동두천시 경기도",
                "경기도 동두천시 지행동 693-6 KR 크라운732, 102호, 103호, 202호", "경기도 동두천시 송내동 지행로 56", "경기도 동두천시 지행동 728-5", "서울특별시 중랑구 면목동 498-4"
                );


        String phone = "070-7441-4848";
        LocalDateTime openTime = LocalDateTime.now();
        LocalDateTime closeTime = LocalDateTime.now();

        Long ownerId = 1L;


        List<Double> latList = Arrays.asList(37.5922378, 37.5906981, 37.5907351, 37.594956, 37.5908659, 37.654734,
                37.6563701, 37.6556467, 37.6532258, 37.8923816, 37.8923816, 37.8923816, 37.8923816, 37.8942528,
                37.5837364 );

        List<Double> lonList = Arrays.asList(127.0763713, 127.0739813, 127.0569291, 127.0739813, 127.0569291, 127.0578142,
                127.06044, 127.0612012, 127.0583259, 127.0535683, 127.0535683, 127.0535683, 127.0535683, 127.0555746,
                127.0848235);

        Owner owner = ownerRepository.findById(1L).get();

        int n = 15; // 15개의 더미 데이터

        for (int i = 0 ; i < n; i++) {
            CafeInfo cafeInfo = CafeInfo.builder()
                    .owner(owner)
                    .businessNo(businessBuilder())
                    .name(nameList.get(i))
                    .phone(phone)
                    .openTime(openTime)
                    .closeTime(closeTime)
                    .latitude(latList.get(i))
                    .longitude(lonList.get(i))
                    .parcelAddr(addList.get(i))
                    .streetAddr(addList.get(i))
                    .build();
            CafeInfo savedCafeInfo = cafeInfoRepository.save(cafeInfo);

            System.out.println(savedCafeInfo);
        }



    }

    private static String businessBuilder() {
        StringBuilder sb = new StringBuilder();


        sb.append((int) (Math.random() * 6) + 1);
        for (int i = 1; i < 12; i++) {
            if (i == 3 || i == 6) {
                sb.append("-");
            } else {
                sb.append(new Random().nextInt(9));
            }
        }

        return sb.toString();
    }
}
