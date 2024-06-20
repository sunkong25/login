package com.modakbul.global.oauth;

import com.modakbul.domain.user.entity.User;
import com.modakbul.domain.user.enums.UserRole;
import com.modakbul.domain.user.repository.UserRepository;
import com.modakbul.global.jwt.JwtTokenProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional
public class OAuth2LoginSuccessHandler{// implements AuthenticationSuccessHandler {
    /*private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        try {
            CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

            if (oAuth2User.getRole() == UserRole.GUEST) {
                String accessToken = jwtTokenProvider.createAccessToken(oAuth2User.getEmail());
                //String redirectUrl = "http://localhost:3000/auth/socialJoin?accessToken=" + accessToken;
                String redirectUrl = "************" + accessToken;
                response.sendRedirect(redirectUrl); // 프론트의 회원가입 추가 정보 입력 폼으로 리다이렉트

                jwtTokenProvider.sendAccessAndRefreshToken(response, accessToken, null);
                User findUser = Optional.ofNullable(userRepository.findByEmail(oAuth2User.getEmail()).get(0))
                        .orElseThrow(() -> new IllegalArgumentException("이메일에 해당하는 유저가 없습니다."));
                findUser.setUserRole(UserRole.NORMAL); // GUEST -> NORMAL
            } else {
                loginSuccess(response, oAuth2User); // 로그인에 성공한 경우 access, refresh 토큰 생성
            }
        } catch (Exception e) {
            throw e;
        }
    }
    private void loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException {
        String accessToken = jwtTokenProvider.createAccessToken(oAuth2User.getEmail());
        String refreshToken = jwtTokenProvider.createRefreshToken(oAuth2User.getEmail());
        //String redirectUrl = "http://localhost:3000/some/path?accessToken=" + accessToken + "&refreshToken=" + refreshToken;
        String redirectUrl = "*****************" + accessToken + "&refreshToken=" + refreshToken;
        response.sendRedirect(redirectUrl);

        jwtTokenProvider.updateRefreshToken(oAuth2User.getEmail(), refreshToken);
    }*/
}

