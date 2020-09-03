package xyz.cafeaddy.rest.lcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.cafeaddy.rest.lcs.service.test.TestService;
import xyz.cafeaddy.rest.lcs.web.dto.TestDto;

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

    @PostMapping("/api/name")
    public String name4(@RequestParam Double ne, @RequestParam Double sw) {

        return "ne = " + ne + ", sw = " + sw + " wow";
    }

    @GetMapping("/api/name2")
    public String name2(@RequestParam String name) {
        return name + "hihi2";
    }
}
