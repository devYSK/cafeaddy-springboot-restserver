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
    private String testName;

    @Column
    private String title;


    @Builder
    public Test(String testName, String title) {
        this.testName = testName;
        this.title = title;
    }

}
