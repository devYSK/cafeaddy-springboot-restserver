package xyz.cafeaddy.rest.lcs.service.owner;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONStringer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.cafeaddy.rest.lcs.domain.owner.Owner;
import xyz.cafeaddy.rest.lcs.domain.owner.OwnerRepository;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerJoinRequestDto;
import xyz.cafeaddy.rest.lcs.web.dto.request.owner.OwnerSignInRequestDto;
import xyz.cafeaddy.rest.lcs.web.response.Response;

import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OwnerServiceTest {


    @Autowired
    OwnerService ownerService;

    @Autowired
    OwnerRepository ownerRepository;


    @Test
//    @Transactional
    public void saveOwner() {

        String name = "영수";
        String phone = "010-7441-4848";
        String password = "dudtn223";
        String email = "kim20@naver.com";

        OwnerJoinRequestDto requestDto = OwnerJoinRequestDto.builder()
                .email(email)
                .name(name)
                .password(password)
                .phone(phone)
                .build();

//        Long ownerId = ownerService.join(requestDto);

//        Optional<Owner> savedOwner = ownerRepository.findById(ownerId);

//
//        savedOwner.ifPresent(owner -> {
//            log.info("name = " + owner.getName() + "\n");
//            log.info("passwd = " + owner.getPassword() + "\n");
//            log.info("email = " + owner.getEmail() + "\n");
//            log.info("phone = " + owner.getPhone() + "\n");
//        });


    }
    @Test
    public void signInTest() {
        String email = "kim20@naver.com";
        String password = "dudtn223";

        OwnerSignInRequestDto requestDto = OwnerSignInRequestDto.builder()
                .email(email)
                .password(password)
                .build();

        Response<?> response = ownerService.signIn(requestDto);

        log.info(String.valueOf(response.getData()));

        log.info(response.toString());
    }

    @Test
    public void duplicatedEmail() {
        String email = "kim20@naver.com";

        ResponseEntity<?> responseEntity = ownerService.duplicateEmailCheck(email);

        log.info(responseEntity.getStatusCode().toString());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    public void notDuplicatedEmail() {
        String email = "1_1yeoung@naver.com";

        ResponseEntity<?> responseEntity = ownerService.duplicateEmailCheck(email);

        log.info(responseEntity.getStatusCode().toString());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}