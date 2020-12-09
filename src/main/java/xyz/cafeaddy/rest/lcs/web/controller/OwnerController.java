package xyz.cafeaddy.rest.lcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.cafeaddy.rest.lcs.service.owner.OwnerService;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerJoinRequestDto;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerSignInRequestDto;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;


    @GetMapping("/duplicate")
    public ResponseEntity<?> duplicateEmailCheck(String email) {

        //TODO: url 리소스 get 으로 변경해야함(restful 하지 않음)

        return ownerService.duplicateEmailCheck(email);
    }


    @PostMapping("")
    public ResponseEntity<?> join(OwnerJoinRequestDto requestDto) {

        return ownerService.join(requestDto);

    }


}
