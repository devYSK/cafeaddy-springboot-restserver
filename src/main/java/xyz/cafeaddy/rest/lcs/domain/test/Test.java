package xyz.cafeaddy.rest.lcs.domain.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Builder
    public Test(String name, String title) {
        this.name = name;
        this.title = title;
    }
}
