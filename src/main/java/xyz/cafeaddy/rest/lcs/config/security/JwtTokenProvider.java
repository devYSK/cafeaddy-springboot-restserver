package xyz.cafeaddy.rest.lcs.config.security;

import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
@Getter
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.secret}")
    private String realKey;

    private final long tokenValidMilliSecond = 1000L * 60 * 30; // 30분 유효

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    //Jwt 토큰 생성
    public String createToken(String userPk, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userPk);

        claims.put("roles", roles);
        Date nowDate = new Date();
        return Jwts.builder()
                .setClaims(claims) // 데이터
                .setIssuedAt(nowDate) // 토큰 발행 일자
                .setExpiration(new Date(nowDate.getTime() + tokenValidMilliSecond)) // 토큰 만료 시간
                .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret 값 세팅
                .compact();
    }


    // Jwt 토큰에서 회원 구별 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }


    // Jwt 토큰의 유효성 + 만료일자 확인
    public Boolean validateToken(String jwtToken) {
        Jws<Claims> claimsJwt = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwtToken);

        return !claimsJwt.getBody().getExpiration().before(new Date());
    }

}
