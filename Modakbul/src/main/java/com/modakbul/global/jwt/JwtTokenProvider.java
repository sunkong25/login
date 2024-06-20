package com.modakbul.global.jwt;

import com.modakbul.domain.user.entity.User;
import com.modakbul.domain.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.access.expiration}")
    private Long accessTokenExpireTime;
    @Value("${jwt.refresh.expiration}")
    private Long refreshTokenExpireTime;
    @Value("${jwt.access.header}")
    private String accessHeader;
    @Value("${jwt.refresh.header}")
    private String refreshHeader;

    private static final String BEARER = "Bearer ";

    private final UserRepository userRepository;

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String getProvideId(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String createAccessToken(String provideId) {
        return createJwt(provideId,Duration.ofDays(10000).toMillis());
    }


    public String createRefreshToken(String provideId){
        return createJwt(provideId, Duration.ofDays(7).toMillis());
    }

    public String createJwt(String provideId, Long tokenValidTime) {
        Claims claims = Jwts.claims().setSubject(provideId);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean isExpired(String token){
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return claims.getBody().getExpiration().before(new Date()); // Token 만료 날짜가 지금보다 이전이면 만료
    }

    public Authentication getAuthentication(String token){
        User user = new User(getProvideId(token), "", Collections.emptyList());
        return new UsernamePasswordAuthenticationToken(user, token, Collections.emptyList());
    }
}
