package xyz.cafeaddy.rest.lcs.web.dto.request.owner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerJoinRequestDto {

    private String email;

    private String password;

    private String name;

    private String phone;


    public Owner toEntity() {
        return Owner.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .build();
    }

}

