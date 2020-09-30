package xyz.cafeaddy.rest.lcs.web.dto.response;

import lombok.*;
import lombok.experimental.Accessors;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    private Double latitude;

    private Double longitude;

    private String parcelAddr;

    private String streetAddr;

    private String brand;

    private List<SeatInfoResponseDto> seatInfos;

    public CafeInfoListResponseDto(CafeInfo entity) {
        this.id = entity.getId();
        this.businessNo = entity.getBusinessNo();
        this.name = entity.getName();
        this.phone = entity.getPhone();
        this.openTime = entity.getOpenTime();
        this.closeTime = entity.getCloseTime();
        this.longitude = entity.getLocation().getX();
        this.latitude = entity.getLocation().getY();
        this.parcelAddr = entity.getParcelAddr();
        this.streetAddr = entity.getStreetAddr();
        this.brand = entity.getBrand();

        this.seatInfos = entity.getSeatList()
                .stream()
                .map(SeatInfoResponseDto::new)
                .collect(Collectors.toList());

    }

}
