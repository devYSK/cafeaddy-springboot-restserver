package xyz.cafeaddy.rest.lcs.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.cafeaddy.rest.lcs.service.cafeinfo.CafeInfoService;
import xyz.cafeaddy.rest.lcs.web.dto.request.cafeinfo.CafeInfoListRequestDto;
import xyz.cafeaddy.rest.lcs.web.dto.response.cafe.CafeInfoListResponseDto;
import xyz.cafeaddy.rest.lcs.web.response.Response;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cafes")
@Slf4j
public class CafeInfoController {

    private final CafeInfoService cafeInfoService;


    @GetMapping("/")
    public ResponseEntity<?> findAllCafe() {

        List<CafeInfoListResponseDto> cafeList =  cafeInfoService.findAll();

        return cafeList.size() != 0 ? Response.ok(cafeList) : Response.notFound();

    }

    @GetMapping("/around")
    public ResponseEntity<?> findAllAroundCafe(CafeInfoListRequestDto requestDto) {

        List<CafeInfoListResponseDto> cafeList = cafeInfoService.findAllAroundCafe(requestDto);

        return cafeList.size() != 0 ? Response.ok(cafeList) : Response.noContent();
    }


    @GetMapping("/name/{cafeName}")
    public ResponseEntity<?> findAllByCafeName(@PathVariable String cafeName) {

        List<CafeInfoListResponseDto> cafeList = cafeInfoService.findAllCafeByName(cafeName);

        return cafeList.size() != 0 ? Response.ok(cafeList) : Response.noContent();
    }


    @GetMapping("/brands")
    public ResponseEntity<?> findAllBrandName() {

        List<String> cafeBrandNames = cafeInfoService.findAllBrandDistinct();

        return cafeBrandNames != null ? Response.ok(cafeBrandNames) : Response.notFound();
    }



//    @GetMapping("/cafes/keyword")
//    public ResponseEntity<?> findAllCafeByKeyword(CafeListByKeywordRequestDto requestDto) {
//
//        List<CafeInfoListResponseDto> cafeList = cafeInfoService.findAllCafeByName(requestDto);
//
//        return cafeList.size() != 0 ? Response.ok(cafeList) : Response.noContent();
//    }

}
