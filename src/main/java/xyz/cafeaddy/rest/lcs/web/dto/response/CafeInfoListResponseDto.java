package xyz.cafeaddy.rest.lcs.web.dto.response;

import lombok.*;
import lombok.experimental.Accessors;
import org.locationtech.jts.geom.Point;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfo;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Accessors(chain = true)
@ToString
@Builder
public class CafeInfoListResponseDto {

    private Long id;

    private String businessNo;

    private String name;

    private String phone;

    private LocalDateTime openTime;

    private LocalDateTime closeTime;

    private Point location;

    private String parcelAddr;

    private String streetAddr;


    public CafeInfoListResponseDto(CafeInfo entity) {
        this.id = entity.getId();
        this.businessNo = entity.getBusinessNo();
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.openTime = entity.getOpenTime();
        this.closeTime = entity.getCloseTime();
        this.location = entity.getLocation();
        this.parcelAddr = entity.getParcelAddr();
        this.streetAddr = entity.getStreetAddr();
    }

}
