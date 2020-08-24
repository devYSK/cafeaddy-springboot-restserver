package xyz.cafeaddy.rest.lcs.domain.seat;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfo;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfoRepository;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SeatRepositoryTests {


    @Autowired
    CafeInfoRepository cafeInfoRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    SeatRepository seatRepository;


    // 제약조건 때문에 삭제 순서가 중요하다
    @After
    public void clean_up() {
        cafeInfoRepository.deleteAll();
        seatRepository.deleteAll();
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

        CafeInfo cafeInfo = CafeInfo.builder()
                .businessNo("123-456-789")
                .name("스벅")
                .phone("010-7441-4848")
                .latitude(36.5)
                .longitude(36.5)
                .owner(owner)
                .build();

        cafeInfoRepository.save(cafeInfo);

        SeatId seatId = new SeatId(cafeInfo.getId(), 1);

        Seat seat = Seat.builder()
                .id(seatId)
                .cafeInfo(cafeInfo)
                .totalSeatCnt(20)
                .useSeatCnt(10)
                .build();

        seatRepository.save(seat);



        //when
        List<CafeInfo> cafeInfoList  = cafeInfoRepository.findAll();
        List<Seat> seatList = seatRepository.findAll();
        Seat savedSeat = seatList.get(0);

        //then
        CafeInfo savedCafeInfo = cafeInfoList.get(0);
        log.info(savedCafeInfo.toString() + " \n");

        log.debug(owner.toString() + "\n");
        log.info(seat.toString() + "\n");

//        Assertions.assertThat(savedCafeInfo.getId()).isEqualTo(seat.getCafeInfo().getId());
        Assertions.assertThat(savedSeat.getId()).isEqualTo(seatId);
        log.info(seatId.toString());
    }


}