package com.modakbul.domain.user.repository;

import com.modakbul.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByEmail(String email);

    User findByRefreshToken(String refreshToken);
}
