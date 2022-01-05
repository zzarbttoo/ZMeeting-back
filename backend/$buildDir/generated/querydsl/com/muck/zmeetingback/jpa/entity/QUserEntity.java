package com.muck.zmeetingback.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = 659390961L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final StringPath age = createString("age");

    public final DateTimePath<java.util.Date> birth = createDateTime("birth", java.util.Date.class);

    public final StringPath country = createString("country");

    public final ListPath<GameEntity, QGameEntity> gamePlayList = this.<GameEntity, QGameEntity>createList("gamePlayList", GameEntity.class, QGameEntity.class, PathInits.DIRECT2);

    public final StringPath gender = createString("gender");

    public final ListPath<ImageEntity, QImageEntity> imageList = this.<ImageEntity, QImageEntity>createList("imageList", ImageEntity.class, QImageEntity.class, PathInits.DIRECT2);

    public final StringPath loginId = createString("loginId");

    public final StringPath loginKind = createString("loginKind");

    public final StringPath name = createString("name");

    public final StringPath nickName = createString("nickName");

    public final StringPath password = createString("password");

    public final StringPath refreshToken = createString("refreshToken");

    public final StringPath scope = createString("scope");

    public final StringPath thirdPartyKeyId = createString("thirdPartyKeyId");

    public final DateTimePath<java.util.Date> tokenIssuedTime = createDateTime("tokenIssuedTime", java.util.Date.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

