package xyz.cafeaddy.rest.lcs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
