package com.muck.zmeetingback.jpa.repository;

import com.muck.zmeetingback.auth.dto.WholeUserDTO;
import com.muck.zmeetingback.jpa.entity.QUserEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static com.muck.zmeetingback.jpa.entity.QUserEntity.userEntity;

public class UserRepositoryImpl implements UserRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Autowired
    public UserRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public WholeUserDTO selectUserByWholeUserDTO(String loginId) {

        return queryFactory
                .select(Projections.bean(WholeUserDTO.class
                        , userEntity.userId
                        , userEntity.nickName
                        ,userEntity.gender
                        , userEntity.birth
                        , userEntity.country))
                .from(userEntity)
                .where(userEntity.loginId.eq(loginId))
                .fetchOne();


    }
}
