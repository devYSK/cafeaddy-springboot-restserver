package xyz.cafeaddy.rest.lcs.domain.owner;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.Accessors;
import xyz.cafeaddy.rest.lcs.domain.BaseTimeEntity;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfo;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "cafe_owner")
@Builder
@Accessors(chain = true)
@ToString(exclude = {"cafeInfoList"})
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

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<CafeInfo> cafeInfoList;

//    @Builder
//    public Owner(String email, String password, String auth, String name, String phone) {
//        this.email = email;
//        this.password = password;
//        this.auth = auth;
//        this.name = name;
//        this.phone = phone;
//    }



}
