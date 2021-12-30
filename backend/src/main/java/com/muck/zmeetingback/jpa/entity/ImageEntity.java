package com.muck.zmeetingback.jpa.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageEntity {

    @Id
    @GeneratedValue
    @Column(name = "IMAGE_ID")
    private Long imageId;

    @Column(name = "IMAGE_LOCATION")
    private String imageLocation;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "IS_PROFILE_IMAGE")
    private Boolean isProfileImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GAME_ID")
    private GameEntity gameEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserEntity userEntity;


    public ImageEntity(String imageLocation, String imageName
            , Boolean isProfileImage){

        this.imageLocation = imageLocation;
        this.imageName = imageName;
        this.isProfileImage = isProfileImage;
    }

    public void setUserEntity(UserEntity userEntity){
        this.userEntity = userEntity;
    }

    public void setGameEntity(GameEntity gameEntity){
        this.gameEntity = gameEntity;
    }

}
