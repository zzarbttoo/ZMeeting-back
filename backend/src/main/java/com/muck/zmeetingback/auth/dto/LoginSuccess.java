package com.muck.zmeetingback.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginSuccess extends WholeUserDTO {

    private WholeUserDTO userInform;
    private TokenDTO tokenInform;
    private String RequestMessage;

    public LoginSuccess(WholeUserDTO userDTO, TokenDTO tokenDTO) {
        this.userInform = userDTO;
        this.tokenInform = tokenDTO;
    }
}
