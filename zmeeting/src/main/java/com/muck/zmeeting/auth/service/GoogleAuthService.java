package com.muck.zmeeting.auth.service;

import com.muck.zmeeting.auth.dto.GoogleLoginInformDTO;
import com.muck.zmeeting.auth.dto.NormalUserDTO;
import com.muck.zmeeting.auth.dto.ThirdPartyUserDTO;
import com.muck.zmeeting.auth.dto.WholeUserDTO;

//public interface AuthService extends UserDetailsService {
public interface AuthService{


    WholeUserDTO createUser(ThirdPartyUserDTO thirdPartyUserDTO);
    WholeUserDTO createUser(NormalUserDTO normalUserDTO);
    Boolean isMemberThirdParty(ThirdPartyUserDTO userDTO);
    boolean isMemberGoogle(GoogleLoginInformDTO userDTO);
    //TODO : kakao
    // boolean isMemberKakao();
    Boolean isMemberNormal(NormalUserDTO userDTO);
    WholeUserDTO signInByThirdParty();
    WholeUserDTO signInByGoogle(GoogleLoginInformDTO loginInform);
    WholeUserDTO signInByKakao();
    WholeUserDTO signInByNormal();



}
