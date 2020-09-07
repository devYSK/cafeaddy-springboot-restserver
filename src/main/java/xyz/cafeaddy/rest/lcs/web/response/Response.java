package xyz.cafeaddy.rest.lcs.web.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Response<T> extends BasicResponse {

    private LocalDateTime transactionTime;

    private int count;

    private T data;

    public Response(T data) {
        this.data = data;
        this.count = data instanceof List ? ((List<?>) data).size() : 1;
        this.transactionTime = LocalDateTime.now();
    }


    public static <T> ResponseEntity<?> ok(T data) {
        return ResponseEntity.ok().body(new Response<T>(data));
    }

    public static ResponseEntity<?> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse());
    }

}
