package com.modakbul.global.controller;

import com.modakbul.global.dto.LoginDto;
import com.modakbul.global.jwt.JwtTokenProvider;
import com.modakbul.global.oauth.OAuthAttributes;
import com.modakbul.global.service.SocialLoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/social")
public class SocialLoginController {

    /*private final SocialLoginService socialLoginService;

    //소셜 로그인 RequestParam으로 AccessToken을 넣는다.
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam(value = "token") String token) {
        return ResponseEntity.ok(socialLoginService.login(token));
    }

    //회원가입 Body에 정의된 유저 회원정보를 넣는다.
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody LoginDto.socialLoginRequest request) {
        return ResponseEntity.ok(socialLoginService.signUp(request));
    }*/



    /*private final SocialLoginService socialLoginService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody LoginDto.socialLoginRequest request) {//회원정보 추가 입력받을 정보를 dto 받기
        socialLoginService.join(request);
        return ResponseEntity.ok("회원가입이 성공적으로 완료됐습니다!");
    }

    @PostMapping("/socialLogin")
    public ResponseEntity<String> socialLogin(@RequestBody LoginDto.socialLoginRequest socialLoginRequest) {
        socialLoginService.socialLogin(socialLoginRequest);
        return ResponseEntity.ok("추가 정보 입력을 완료했습니다.");
    }


    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        Optional<String> accessToken = jwtTokenProvider.extractAccessToken(request);
        Optional<String> email = jwtTokenProvider.extractEmail(accessToken.get());
        jwtTokenProvider.updateRefreshToken(email.get(), "none");
        return "로그아웃이 완료되었습니다.";
    }*/
}
