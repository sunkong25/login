package com.modakbul.domain.user.entity;

import com.modakbul.domain.user.enums.Gender;
import com.modakbul.domain.user.enums.Provider;
import com.modakbul.domain.user.enums.UserRole;
import com.modakbul.domain.user.enums.UserStatus;
import com.modakbul.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Provider provider; // APPLE, KAKAO

    @Column(nullable = false)
    private String providerId;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 8)
    private String birth;

    @Column(nullable = false, length = 15)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender; // MALE, FEMALE

    @Column(name = "is_gender_visible")
    private Boolean isVisible; // default = true

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column(nullable = false)
    private String refreshToken;

    public User(String provideId, String email, List<Object> objects) {
        super();
    }
}
