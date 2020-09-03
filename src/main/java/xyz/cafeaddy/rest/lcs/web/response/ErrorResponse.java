package xyz.cafeaddy.rest.lcs.web.response;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse extends BasicResponse {

    private String errorMessage;

    private Integer errorCode;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = 404;
    }


}
