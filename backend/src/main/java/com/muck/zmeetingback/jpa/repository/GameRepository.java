package com.muck.zmeetingback.jpa.repository;

import com.muck.zmeetingback.jpa.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameEntity, Long> {
}
