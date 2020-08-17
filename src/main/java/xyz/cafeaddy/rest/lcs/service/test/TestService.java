package xyz.cafeaddy.rest.lcs.service.test;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.cafeaddy.rest.lcs.domain.test.TestRepository;
import xyz.cafeaddy.rest.lcs.web.dto.TestDto;

@RequiredArgsConstructor
@Service
public class TestService {

    private final TestRepository testRepository;


    @Transactional
    public Long save(TestDto testDto) {
        return testRepository.save(testDto.toEntity()).getId();
    }
}
