package xyz.cafeaddy.rest.lcs.service.cafeinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.cafeaddy.rest.lcs.domain.cafeinfo.CafeInfoRepository;
import xyz.cafeaddy.rest.lcs.web.dto.request.cafeinfo.CafeInfoListRequestDto;
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

    @Transactional
    public List<CafeInfoListResponseDto> findAll() {

        return cafeInfoRepository.findAll()
                .stream()
                .map(CafeInfoListResponseDto::new)
                .collect(Collectors.toList());
    }


    public List<CafeInfoListResponseDto> findAllAroundCafe(CafeInfoListRequestDto requestDto) {
        return cafeInfoRepository.findByMBRContains(requestDto)
                .stream()
                .map(CafeInfoListResponseDto::new)
                .collect(Collectors.toList());
    }


}
