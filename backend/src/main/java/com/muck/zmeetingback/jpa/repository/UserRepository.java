package com.muck.zmeetingback.jpa.repository;

import com.muck.zmeetingback.auth.dto.WholeUserDTO;
import com.muck.zmeetingback.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<WholeUserDTO> findUserEntityByLoginId(String loginId);

}
