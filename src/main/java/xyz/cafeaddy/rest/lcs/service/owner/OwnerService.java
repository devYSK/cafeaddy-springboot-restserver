package xyz.cafeaddy.rest.lcs.service.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;
import xyz.cafeaddy.rest.lcs.utils.Authority;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerJoinRequestDto;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerSignInRequestDto;
import xyz.cafeaddy.rest.lcs.web.response.Response;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Transactional
    public ResponseEntity<?> duplicateEmailCheck(String email) {

        return ownerRepository.findByEmail(email).isPresent()
                ? ResponseEntity.status(HttpStatus.CONFLICT).build()
                : ResponseEntity.status(HttpStatus.OK).build();

    }


    @Transactional
    public ResponseEntity<?> join(OwnerJoinRequestDto requestDto) {

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Owner owner = requestDto.toEntity();
        owner.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        owner.setAuth(Authority.OWNER);

        Response.ok(ownerRepository.save(owner).getId());

        return Response.ok(ownerRepository.save(owner).getId());
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
