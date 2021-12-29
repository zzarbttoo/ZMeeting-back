package com.muck.zmeeting.jpa;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageEntity {

    @Id
    @GeneratedValue
    @Column(name = "IMAGE_ID")
    private Long imageId;

    @Column(name = "IS_PROFILE_IMAGE")
    private Boolean isProfileImage;

    //TODO : 연관관계 mapping
    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "IMAGE_LOCATION")
    private String imageLocation;

    @Column(name = "GAME_ID")
    private Long gameIndex;


}
