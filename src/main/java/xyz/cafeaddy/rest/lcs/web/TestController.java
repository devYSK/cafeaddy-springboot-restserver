package xyz.cafeaddy.rest.lcs.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.cafeaddy.rest.lcs.service.test.TestService;
import xyz.cafeaddy.rest.lcs.web.dto.TestDto;

@Controller
@RequiredArgsConstructor
public class TestController {


    private final TestService testService;


    @GetMapping("test")
    public String test1() {
        return "test";
    }

    @GetMapping("test2")
    public String test2() {
        return "test2";
    }

    @PostMapping("/api/test")
    public String save(@RequestBody TestDto testDto) {

        System.out.println("\n\n");

        System.out.println(testDto.toString());

        System.out.println("\n\n");
        testService.save(testDto);

        return "ok";
    }

}
