package org.sparta.mytaek1.domain.user.repository;

import org.sparta.mytaek1.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String userEmail);

    Boolean existsByStreamKey(String streamKey);

    Optional<User> findByRefreshToken(String refreshToken);
}
