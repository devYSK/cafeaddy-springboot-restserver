package xyz.cafeaddy.rest.lcs.domain.seat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfo;

import javax.persistence.*;



@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cafe_seat")
@Builder
@Accessors(chain = true)
public class Seat {

    @EmbeddedId
    private SeatId id;

    @MapsId("cafeId")
    @ManyToOne
    @JoinColumn(name = "cafe_id", referencedColumnName = "cafe_id")
    private CafeInfo cafeInfo;

    @Column(name = "total_seat_cnt")
    private Integer totalSeatCnt;

    @Column(name = "use_seat_cnt")
    private Integer useSeatCnt;



    @Builder
    public Seat(SeatId id, CafeInfo cafeInfo, Integer totalSeatCnt, Integer useSeatCnt) {
        this.id = id;
        this.cafeInfo = cafeInfo;
        this.totalSeatCnt = totalSeatCnt;
        this.useSeatCnt = useSeatCnt;
    }
}
