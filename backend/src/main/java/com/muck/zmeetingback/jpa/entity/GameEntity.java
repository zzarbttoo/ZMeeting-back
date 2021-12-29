package com.muck.zmeetingback.jpa.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameEntity {

    @Id
    @GeneratedValue
    @Column(name = "GAME_ID")
    private Long gameId;

    @Column(name = "LEFT_USER")
    private Long leftUser;

    @Column(name = "RIGHT_USER")
    private Long rightUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_Id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "gameEntity")
    private List<ImageEntity> imageList = new ArrayList<>();


}
