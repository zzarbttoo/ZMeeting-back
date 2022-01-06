package com.muck.zmeetingback.jpa.repository;

import com.muck.zmeetingback.jpa.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<RefreshTokenEntity, String> {
    Optional<RefreshTokenEntity> findByUserId(String userId);
}
