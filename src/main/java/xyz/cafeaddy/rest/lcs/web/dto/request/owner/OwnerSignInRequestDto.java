package xyz.cafeaddy.rest.lcs.web.dto.request.owner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OwnerSignInRequestDto {

    private String email;

    private String password;

}
