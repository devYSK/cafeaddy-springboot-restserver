package xyz.cafeaddy.rest.lcs.web.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Response<T> extends BasicResponse{

    private int count;

    private T data;

    public Response(T data) {
        this.data = data;
        this.count = data instanceof List ? ((List<?>)data).size() : 1;
    }

}
