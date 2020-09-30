package xyz.cafeaddy.rest.lcs.utils;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SearchOption {

    NAME("이름"),
    LOCATION("위치");

    private final String option;
}
