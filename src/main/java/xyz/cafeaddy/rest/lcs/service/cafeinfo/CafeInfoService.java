package xyz.cafeaddy.rest.lcs.service.cafeinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfoRepository;
import xyz.cafeaddy.rest.lcs.web.dto.response.CafeInfoListResponseDto;
import xyz.cafeaddy.rest.lcs.web.response.BasicResponse;
import xyz.cafeaddy.rest.lcs.web.response.ErrorResponse;
import xyz.cafeaddy.rest.lcs.web.response.Response;
import xyz.cafeaddy.rest.lcs.web.response.Response2;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CafeInfoService {

    private final CafeInfoRepository cafeInfoRepository;

//    public List<CafeInfo> findAllAroundCafe(CafeInfoListRequestDto requestDto) {
//        return null;
//    }

    public List<CafeInfoListResponseDto> findAll() {

        return cafeInfoRepository.findAll()
                .stream()
                .map(CafeInfoListResponseDto::new)
                .collect(Collectors.toList());
    }

//    public BasicResponse findAll() {
//        List<CafeInfoListResponseDto> dataList = cafeInfoRepository.findAll().stream()
//                .map(CafeInfoListResponseDto::new)
//                .collect(Collectors.toList());
//
//        return dataList.size() != 0 ? new Response<>(dataList) : new ErrorResponse();
//
//    }

}