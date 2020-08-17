package xyz.cafeaddy.rest.lcs.web.dto;

import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
}
