package xyz.cafeaddy.rest.lcs.web.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.cafeaddy.rest.lcs.domain.seat.Seat;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatInfoResponseDto {

    private Long cafeId;

    private Integer floorNumber;

    private Integer useSeatCnt;

    private Integer totalSeatCnt;

    public SeatInfoResponseDto(Seat entity) {
        this.cafeId = entity.getId().getCafeId();
        this.floorNumber = entity.getId().getFloorNo();
        this.useSeatCnt = entity.getUseSeatCnt();
        this.totalSeatCnt = entity.getTotalSeatCnt();
    }
}
