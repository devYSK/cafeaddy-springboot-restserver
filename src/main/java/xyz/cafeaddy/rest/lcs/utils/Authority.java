package xyz.cafeaddy.rest.lcs.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Authority {
    ADMIN("AUTH_ADMIN"),
    OWNER("AUTH_OWNER");



    private final String Auth;
}
