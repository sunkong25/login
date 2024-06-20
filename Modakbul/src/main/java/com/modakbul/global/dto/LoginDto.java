package com.modakbul.global.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class socialLoginRequest {
        private String email;
        private String password;
        private String provider;
        private String name;
        private String gender;
        private Boolean isGenderVisible;
        private String birth;
        private String nickname;
        private String categoryName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class socialLoginResponse {
        private String message;
        private Long id;
        private String email;
        private String nickname;
    }
}

