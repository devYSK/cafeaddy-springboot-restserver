package xyz.cafeaddy.rest.lcs.web.dto.request.cafeinfo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CafeInfoListRequestDto {

    private Double neLongitude; // 북동쪽 경도 (northEast longitude)

    private Double neLatitude; // 북동쪽 위도 (northEast latitude)

    private Double swLongitude; // 남서쪽 경도 (southWest longitude)

    private Double swLatitude; // 남서쪽 위도 (southWest latitude)

}
