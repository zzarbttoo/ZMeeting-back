package com.muck.zmeeting.auth.jpa.repository;

import com.muck.zmeeting.auth.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
