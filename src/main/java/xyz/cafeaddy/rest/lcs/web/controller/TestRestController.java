package xyz.cafeaddy.rest.lcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.cafeaddy.rest.lcs.service.test.TestService;
import xyz.cafeaddy.rest.lcs.web.dto.TestDto;
import xyz.cafeaddy.rest.lcs.web.dto.TestDto2;

@RestController
@RequiredArgsConstructor
public class TestRestController {

    private final TestService testService;

    @PostMapping("/api/test")
    public String save(@RequestBody TestDto testDto) {

        System.out.println("\n\n");

        System.out.println(testDto.toString());

        System.out.println("\n\n");
        testService.save(testDto);

        return "ok";
    }

    @PostMapping("/api/name")
    public String name(@RequestParam String name) {

        return name + "hi";
    }

    @PostMapping("/api/datas")
    public String name4(@RequestBody TestDto2 testDto2) {
        System.out.println("메소드 접근");

        System.out.println("메소드 종료 ");
        return testDto2.getSwLatitude() + " 민옥 " + "\n " + testDto2.getSwLongitude() + "하이\n"
                + testDto2.getNeLatitude() + " 오호 \n" + testDto2.getNeLongitude() + "이렇게?";
    }

    @GetMapping("/api/name2")
    public String name2(@RequestParam String name) {
        return name + "hihi2";
    }
}
