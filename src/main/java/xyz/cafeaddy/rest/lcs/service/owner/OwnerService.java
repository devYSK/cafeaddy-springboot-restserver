package xyz.cafeaddy.rest.lcs.service.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;
import xyz.cafeaddy.rest.lcs.utils.Authority;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerJoinRequestDto;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Transactional
    public Long join(OwnerJoinRequestDto requestDto) {

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        Owner owner = requestDto.toEntity();
        owner.setAuth(Authority.OWNER);
        return ownerRepository.save(owner).getId();
    }


}
