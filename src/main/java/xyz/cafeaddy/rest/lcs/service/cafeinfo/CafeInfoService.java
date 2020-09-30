package xyz.cafeaddy.rest.lcs.service.cafeinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfo;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfoRepository;
import xyz.cafeaddy.rest.lcs.utils.SearchOption;
import xyz.cafeaddy.rest.lcs.web.dto.request.cafeinfo.CafeInfoListRequestDto;
import xyz.cafeaddy.rest.lcs.web.dto.request.cafeinfo.CafeListByKeywordRequestDto;
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

    @Transactional
    public List<CafeInfoListResponseDto> findAll() {

        return cafeInfoRepository.findAll()
                .stream()
                .map(CafeInfoListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public List<CafeInfoListResponseDto> findAllAroundCafe(CafeInfoListRequestDto requestDto) {
        return cafeInfoRepository.findByMBRContains(requestDto)
                .stream()
                .map(CafeInfoListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public List<CafeInfoListResponseDto> findAllCafeByName(String keyword) {

        return cafeInfoRepository.findAllByCafeName(keyword)
                .stream()
                .map(CafeInfoListResponseDto::new)
                .collect(Collectors.toList());

    }

//    @Transactional
//    public List<CafeInfoListResponseDto> findAllCafeByName(CafeListByKeywordRequestDto requestDto) {
//
//        List<CafeInfo> cafeInfoList = null;
//
//        switch (requestDto.getOption()) {
//            case LOCATION:
//                cafeInfoList = cafeInfoRepository.findByAddress(requestDto.getKeyword());
//                break;
//            case NAME:
//                cafeInfoList = cafeInfoRepository.findByName(requestDto.getKeyword());
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + requestDto.getOption());
//        }
//
//        return cafeInfoList.stream()
//                .map(CafeInfoListResponseDto::new)
//                .collect(Collectors.toList());
//
//    }

}
