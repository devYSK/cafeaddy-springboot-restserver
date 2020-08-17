package xyz.cafeaddy.rest.lcs.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.cafeaddy.rest.lcs.service.test.TestService;
import xyz.cafeaddy.rest.lcs.web.dto.TestDto;

@Controller
public class TestController {



    @GetMapping("test")
    public String test1() {
        return "test";
    }

    @GetMapping("test2")
    public String test2() {
        return "test2";
    }



}
