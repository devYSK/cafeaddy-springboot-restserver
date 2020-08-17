package xyz.cafeaddy.rest.lcs.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xyz.cafeaddy.rest.lcs.domain.test.Test;

@Getter
@NoArgsConstructor
public class TestDto {
    private String name;
    private String title;

    @Builder
    public TestDto(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public Test toEntity() {
        return Test.builder()
                .name(name)
                .title(title)
                .build();
    }
}
