package xyz.cafeaddy.rest.lcs.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestDto2 {

    private Double swLatitude;

    private Double swLongitude;

    private Double neLatitude;

    private Double neLongitude;
}
