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

    @GetMapping("/cafe-infos")
    public ResponseEntity<?> findAllCafe() {

        List<CafeInfoListResponseDto> cafeList =  cafeInfoService.findAll();

        return cafeList.size() != 0 ? ResponseEntity.ok(cafeList)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse());

    }

//    @GetMapping("/cafe-infos2")
//    public ResponseEntity<List<CafeInfoListResponseDto>> findAllCafe2() {
//
//        HttpHeaders headers = new HttpHeaders();
//
//
//        ResponseEntity.ok().header().body();
//
//        return ResponseEntity.ok(cafeInfoService.findAll());
//    }


//    @GetMapping("/cafe-infos")
//    public List<CafeInfoListResponseDto> findAllCafe() {
//        ResponseEntity<List<CafeInfo>> entity = new ResponseEntity<List<CafeInfo>>(HttpStatus.OK);
//
//        List<CafeInfoListResponseDto> list = cafeInfoService.findAll();
//
//        return Response<>
//
////        return cafeInfoService.findAll();
//    }

}
