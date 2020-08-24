package xyz.cafeaddy.rest.lcs.domain.cafeinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cafe_info")
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

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "lon")
    private Double longitude;

    @Column(name = "parcel_addr")
    private String parcelAddr;

    @Column(name = "street_addr")
    private String streetAddr;


    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "owner_id")
    private Owner owner;

    @Builder
    public CafeInfo(String businessNo, String name, String phone, LocalDateTime openTime, LocalDateTime closeTime, Double latitude, Double longitude, String parcelAddr, String streetAddr, Owner owner) {
        this.businessNo = businessNo;
        this.name = name;
        this.phone = phone;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.parcelAddr = parcelAddr;
        this.streetAddr = streetAddr;
        this.owner = owner;
    }
    
}
