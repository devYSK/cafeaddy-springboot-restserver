package xyz.cafeaddy.rest.lcs.service.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;
import xyz.cafeaddy.rest.lcs.utils.Authority;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerJoinRequestDto;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerSignInRequestDto;
import xyz.cafeaddy.rest.lcs.web.response.Response;

import java.util.Optional;

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

    @Transactional
    public Response<?> signIn(OwnerSignInRequestDto signInRequestDto) {

        Owner findOwner = ownerRepository.findByEmail(signInRequestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("없는 유저 입니다"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!encoder.matches(signInRequestDto.getPassword(), findOwner.getPassword())) // 비밀번호 매칭 체크
            throw new IllegalArgumentException("암호가 일치하지 않습니다.");


        return new Response<>(findOwner);
    }

}
