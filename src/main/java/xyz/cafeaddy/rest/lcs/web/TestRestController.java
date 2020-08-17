package xyz.cafeaddy.rest.lcs.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

}
