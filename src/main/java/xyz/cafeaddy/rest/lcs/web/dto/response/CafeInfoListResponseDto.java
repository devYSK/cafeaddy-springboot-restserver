package xyz.cafeaddy.rest.lcs.web.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfo;

import java.time.LocalDateTime;

@Getter
@Accessors(chain = true)
@ToString
public class CafeInfoListResponseDto {

    private Long id;

    private String businessNo;

    private String name;

    private String phone;

    private LocalDateTime openTime;

    private LocalDateTime closeTime;

    private Double latitude;

    private Double longitude;

    private String parcelAddr;

    private String streetAddr;


    public CafeInfoListResponseDto(CafeInfo entity) {
        this.id = entity.getId();
        this.businessNo = entity.getBusinessNo();
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.openTime = entity.getOpenTime();
        this.closeTime = entity.getCloseTime();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.parcelAddr = entity.getParcelAddr();
        this.streetAddr = entity.getStreetAddr();
    }

}
