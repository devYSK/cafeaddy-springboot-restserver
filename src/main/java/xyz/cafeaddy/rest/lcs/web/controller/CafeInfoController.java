package xyz.cafeaddy.rest.lcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cafeaddy.rest.lcs.service.cafeinfo.CafeInfoService;
import xyz.cafeaddy.rest.lcs.web.dto.response.CafeInfoListResponseDto;
import xyz.cafeaddy.rest.lcs.web.response.ErrorResponse;
import xyz.cafeaddy.rest.lcs.web.response.Response;

import java.util.List;

import static xyz.cafeaddy.rest.lcs.web.response.Response2.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CafeInfoController {

    private final CafeInfoService cafeInfoService;

//    @GetMapping("/cafe-infos")
//    public Response<List<CafeInfoListResponseDto>> findAllCafe() {
//
//
//        return cafeInfoService.findAll();
//
//    }

    @GetMapping("/cafes")
    public ResponseEntity<?> findAllCafe() {

        List<CafeInfoListResponseDto> cafeList =  cafeInfoService.findAll();

        return cafeList.size() != 0 ? Response.ok(cafeList) : Response.notFound();

    }



}
