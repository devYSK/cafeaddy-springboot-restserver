package xyz.cafeaddy.rest.lcs.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response2<T> {

    // api 통신시간
    private LocalDateTime transactionTime;


    // api 응답 코드
    private String resultCode;


    // api 부가 설명
    private String description;


    private T data;
//
//    // OK
//    public static <T> Response2<T> OK(){
//        return (Response2<T>) Response2.builder()
//                .transactionTime(LocalDateTime.now())
//                .resultCode("OK")
//                .description("OK")
//                .build();
//    }
//
//
//    // DATA OK
//    public static <T> Response2<T> OK(T data){
//        return (Response2<T>) Response2.builder()
//                .transactionTime(LocalDateTime.now())
//                .resultCode("OK")
//                .description("OK")
//                .data(data)
//                .build();
//    }
//
//
//    // ERROR
//    public static <T> Response2<T> ERROR(String description){
//        return (Response2<T>) Response2.builder()
//                .transactionTime(LocalDateTime.now())
//                .resultCode("ERROR")
//                .description(description)
//                .build();
//    }
}
