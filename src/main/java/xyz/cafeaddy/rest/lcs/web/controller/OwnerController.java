package xyz.cafeaddy.rest.lcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cafeaddy.rest.lcs.service.owner.OwnerService;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;


    @GetMapping("/emailCheck/{email}")
    public ResponseEntity<?> duplicateEmailCheck(@PathVariable("email") String email) {

        return ownerService.duplicateEmailCheck(email);
    }




}
