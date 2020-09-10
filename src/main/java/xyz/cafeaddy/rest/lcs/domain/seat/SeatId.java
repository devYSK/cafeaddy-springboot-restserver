package xyz.cafeaddy.rest.lcs.domain.seat;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@ToString
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SeatId implements Serializable {

    @Column(name = "cafe_id")
    private Long cafeId;

    @Column(name = "floor_no")
    private Integer floorNo;

}
