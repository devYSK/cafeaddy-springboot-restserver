package xyz.cafeaddy.rest.lcs.domain.cafeinfo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;
//import org.springframework.data.geo.Point;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.seat.Seat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "location")
@ToString(exclude = {"owner", "seatList"})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cafe_info")
@Builder
@Accessors(chain = true)
public class CafeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_id")
    private Long id;

    @Column(name = "business_no")
    private String businessNo;

    private String name;

    private String phone;

    @Column(name = "open_time")
    private LocalDateTime openTime;

    @Column(name = "close_time")
    private LocalDateTime closeTime;

    @Column(name = "location")
    private Point location;

    @Column(name = "parcel_addr")
    private String parcelAddr;

    @Column(name = "street_addr")
    private String streetAddr;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "owner_id")
    private Owner owner;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cafeInfo")
    private List<Seat> seatList;

//    @Builder
//    public CafeInfo(String businessNo, String name, String phone, LocalDateTime openTime, LocalDateTime closeTime, Double latitude, Double longitude, String parcelAddr, String streetAddr, Owner owner) {
//        this.businessNo = businessNo;
//        this.name = name;
//        this.phone = phone;
//        this.openTime = openTime;
//        this.closeTime = closeTime;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.parcelAddr = parcelAddr;
//        this.streetAddr = streetAddr;
//        this.owner = owner;
//    }
    
}
