package xyz.cafeaddy.rest.lcs.service.cafeinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeBrandMapping;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfoRepository;
import xyz.cafeaddy.rest.lcs.web.dto.request.cafeinfo.CafeInfoListRequestDto;
import xyz.cafeaddy.rest.lcs.web.dto.response.cafe.CafeInfoListResponseDto;

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

    @Transactional
    public List<String> findAllBrandDistinct() {

        return cafeInfoRepository.findAllBrand()
                .stream()
                .filter(cafeBrandMapping -> !cafeBrandMapping.getBrand().equals("기타"))
                .map(CafeBrandMapping::getBrand)
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
    }



//    @Transactional
//    public List<CafeBrandNameResponseDto> findBrandByKeyword() {
//
//    }

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
