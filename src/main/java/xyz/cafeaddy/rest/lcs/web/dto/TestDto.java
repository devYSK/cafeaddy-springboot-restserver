package xyz.cafeaddy.rest.lcs.web.dto;

import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;
import xyz.cafeaddy.rest.lcs.domain.test.Test;

@Getter
@NoArgsConstructor
@ToString
public class TestDto {
    private String testName;
    private String title;

    @Builder
    public TestDto(String testName, String title) {
        this.testName = testName;
        this.title = title;
    }

    public Test toEntity() {
        return Test.builder()
                .testName(testName)
                .title(title)
                .build();
    }

    public void test() {
        Coordinate coordinate = new Coordinate();
        coordinate.x = 3.3;
        coordinate.y = 6.6;

    }
}
