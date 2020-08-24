package xyz.cafeaddy.rest.lcs.domain.owner;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xyz.cafeaddy.rest.lcs.domain.BaseTimeEntity;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Getter
@Entity
@Table(name = "cafe_owner")
public class Owner extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;

    private String email;

    private String password;

    private String auth;

    private String name;

    private String phone;


    @Builder
    public Owner(String email, String password, String auth, String name, String phone) {
        this.email = email;
        this.password = password;
        this.auth = auth;
        this.name = name;
        this.phone = phone;
    }



}
