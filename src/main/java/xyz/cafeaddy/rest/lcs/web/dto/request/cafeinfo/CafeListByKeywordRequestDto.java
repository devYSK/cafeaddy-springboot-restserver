package xyz.cafeaddy.rest.lcs.web.dto.request.cafeinfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.cafeaddy.rest.lcs.utils.SearchOption;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CafeListByKeywordRequestDto {

    private String keyword;
    private SearchOption option;

}
