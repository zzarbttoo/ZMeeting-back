package com.muck.zmeetingback.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameEntity is a Querydsl query type for GameEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameEntity extends EntityPathBase<GameEntity> {

    private static final long serialVersionUID = -305010472L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameEntity gameEntity = new QGameEntity("gameEntity");

    public final NumberPath<Long> gameId = createNumber("gameId", Long.class);

    public final ListPath<ImageEntity, QImageEntity> imageList = this.<ImageEntity, QImageEntity>createList("imageList", ImageEntity.class, QImageEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> leftUser = createNumber("leftUser", Long.class);

    public final NumberPath<Long> rightUser = createNumber("rightUser", Long.class);

    public final QUserEntity userEntity;

    public QGameEntity(String variable) {
        this(GameEntity.class, forVariable(variable), INITS);
    }

    public QGameEntity(Path<? extends GameEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameEntity(PathMetadata metadata, PathInits inits) {
        this(GameEntity.class, metadata, inits);
    }

    public QGameEntity(Class<? extends GameEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

