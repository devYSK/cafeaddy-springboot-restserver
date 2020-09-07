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

    //    @Test
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
                37.5837364);

        List<Double> lonList = Arrays.asList(127.0763713, 127.0739813, 127.0569291, 127.0739813, 127.0569291, 127.0578142,
                127.06044, 127.0612012, 127.0583259, 127.0535683, 127.0535683, 127.0535683, 127.0535683, 127.0555746,
                127.0848235);

        Owner owner = ownerRepository.findById(1L).get();

        int n = 15; // 15개의 더미 데이터

        for (int i = 0; i < n; i++) {
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


    @Test
    public void sampleCreate2() {
//        List<String> nameList = Arrays.asList("단조카페", "카페 오르테", "스타벅스 중랑역점",
//                "투썸플레이스 중랑역점", "이디야 중랑역점", "스타벅스 노원역점", "투썸플레이스 노원 문화의거리점",
//                "할리스커피 노원 문화의거리점", "커피스미스 노원 롯데점", "BROSIS", "이디야 지행역점", "스타벅스 지행역점",
//                "공차 동두천지행점", "브루잉 카페", "카페레블");
//
//        List<String> addList = Arrays.asList("서울특별시 중랑구 면목동 번지 3층 185-1 보은빌딩", "면목동 186-83번지 1층 중랑구 서울특별시 KR", "서울특별시 중랑구 상봉동 130-3",
//                "상봉동 130-166번지 2층 동성빌딩 중랑구 서울특별시 KR", "서울특별시 중랑구 상봉동 130-99", "서울특별시 노원구 상계6.7동 동일로 1413", "서울특별시 노원구 상계2동 상계로 69 투썸플레이스 2층",
//                "서울특별시 노원구 상계6.7동 노해로81길 22-26", "서울특별시 노원구 상계동 동일로 1414", "경기도 동두천시 송내동 평화로2313번길 7-26", "번지, 721 지행동 동두천시 경기도",
//                "경기도 동두천시 지행동 693-6 KR 크라운732, 102호, 103호, 202호", "경기도 동두천시 송내동 지행로 56", "경기도 동두천시 지행동 728-5", "서울특별시 중랑구 면목동 498-4"
//        );

        List<String> nameList = Arrays.asList("감각", "하버드 카페", "투썸플레이스 노원문화의거리점", "스타벅스 상계초교사거리점", "파스쿠찌",
                "라온트리", "카페 에스트로", "투썸플레이스 창동역점", "투썸플레이스 중계은행사거리점", "나무아래", "엉클두", "와겐커피", "카미노 (CAMINO)",
                "카페 오븐", "카페 레블", "라스커피", "아고라 커피", "라라브레드 공릉점", "세컨플로어", "미즐 카페 엠", "카페그레도", "시즌",
                "무드쉐어", "산들제빵소", "시드누아 노원본점", "본쥬르네", "디저트 뒤 쥬르", "룰루카롱", "BAEBAE COFFEE", "도봉관"
                );

        List<String> addList = Arrays.asList("서울 노원구 상계로 77", "서울특별시 노원구 상계2동 상계로 75",  "서울특별시 노원구 상계2동 상계로 69 투썸플레이스 2층",
                "서울특별시 노원구 상계동 372-16", "서울특별시 노원구 상계6.7동 노해로 488", "서울특별시 노원구 중계동 413-8", "서울특별시 도봉구 창동 노해로63가길 31-11층",
                "서울특별시 도봉구 창동 노해로 381", "서울특별시 노원구 중계본동 한글비석로 242", "서울특별시 노원구 중계동 364", "서울특별시 도봉구 창동",
                "서울특별시 도봉구 방학1동 716-14", "서울특별시 도봉구 방학1동 671-18", "서울특별시 도봉구 창동 813", "서울특별시 중랑구 면목동 498-4",
                "서울특별시 도봉구 쌍문3동 103-231", "서울특별시 노원구 공릉동 동일로193길 14", "서울 노원구 공릉로41길 32",
                "서울 노원구 상계로1길 8 대유빌딩 2층 세컨플로어", "서울 강북구 수유동 535-11", "서울 성북구 화랑로 304 1층 카페 그레도제빵사",
                "서울 노원구 상계로3길 38-2 2층", "서울특별시 노원구 공릉동 공릉로 119-23", "경기 남양주시 불암산로59번길 48-31",
                "서울특별시 노원구 상계6.7동 상계로 84", "서울 노원구 동일로217가길 17 승경빌딩 1층", "서울 노원구 동일로 1389 상계주공아파트 302동 1층",
                "서울 도봉구 노해로 384 동아아파트상가2층", "서울 노원구 동일로242가길 31 2층", "서울 도봉구 노해로 261"

                );

        List<Double> latList = Arrays.asList(37.6568948, 37.6565293, 37.6566852, 37.6553034, 37.6559988,
                37.6509814, 37.6544811, 37.6544811, 37.6565293, 37.6538078, 37.65468, 37.6550878, 37.6608195, 37.6587749,
                37.5837364, 37.6579578, 37.6589942, 37.6248229, 37.6435687, 37.6435908, 37.5330506,
                37.6281623, 37.624819, 37.6510882, 37.6562709, 37.6532759, 37.6523009, 37.6511681, 37.6511629, 37.6515757
                );
        List<Double> lonList = Arrays.asList(127.0634978, 127.0632993, 127.06279, 127.0591453, 127.0598395,
                127.065821, 127.0581392, 127.0581392, 127.0632993, 127.065135, 127.0505809, 127.0450448, 127.0450449,
                127.0422724, 127.0848235, 127.0540232, 127.0458525, 127.0756428, 126.9334419, 126.9861865, 126.9511555,
                127.0429305, 127.0601877, 127.0992556, 127.0620462, 127.057179, 127.0584084, 127.048151, 127.0152291, 127.0349624


                );


        String phone = "010-7441-4848";
        LocalDateTime openTime = LocalDateTime.now();
        LocalDateTime closeTime = LocalDateTime.now();

        Long ownerId = 2L;


        Owner owner = ownerRepository.findById(2L).get();

        int n = 15; // 15개의 더미 데이터

        for (int i = 0; i < n; i++) {
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

        phone = "010-7441-4848";
        openTime = LocalDateTime.now();
        closeTime = LocalDateTime.now();

        ownerId = 3L;


        owner = ownerRepository.findById(3L).get();

        n = 15; // 15개의 더미 데이터

        for (int i = 0; i < n; i++) {
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
