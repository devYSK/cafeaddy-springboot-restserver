package xyz.cafeaddy.rest.lcs.domain.seat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@ToString
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SeatId implements Serializable {

    @Column(name = "cafe_id")
    private Long cafeId;

    @Column(name = "floor_no")
    private Integer floorNo;

}
