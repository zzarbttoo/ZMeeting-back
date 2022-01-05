package com.muck.zmeetingback.jpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImageEntity is a Querydsl query type for ImageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImageEntity extends EntityPathBase<ImageEntity> {

    private static final long serialVersionUID = -1665922277L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImageEntity imageEntity = new QImageEntity("imageEntity");

    public final QGameEntity gameEntity;

    public final NumberPath<Long> imageId = createNumber("imageId", Long.class);

    public final StringPath imageLocation = createString("imageLocation");

    public final StringPath imageName = createString("imageName");

    public final BooleanPath isProfileImage = createBoolean("isProfileImage");

    public final QUserEntity userEntity;

    public QImageEntity(String variable) {
        this(ImageEntity.class, forVariable(variable), INITS);
    }

    public QImageEntity(Path<? extends ImageEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QImageEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QImageEntity(PathMetadata metadata, PathInits inits) {
        this(ImageEntity.class, metadata, inits);
    }

    public QImageEntity(Class<? extends ImageEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gameEntity = inits.isInitialized("gameEntity") ? new QGameEntity(forProperty("gameEntity"), inits.get("gameEntity")) : null;
        this.userEntity = inits.isInitialized("userEntity") ? new QUserEntity(forProperty("userEntity")) : null;
    }

}

