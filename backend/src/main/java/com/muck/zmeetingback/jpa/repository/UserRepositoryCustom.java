package com.muck.zmeetingback.jpa.repository;

import com.muck.zmeetingback.auth.dto.WholeUserDTO;

public interface UserRepositoryCustom {

    public WholeUserDTO selectUserByWholeUserDTO(String userId);

}
