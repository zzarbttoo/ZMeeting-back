package com.muck.zmeetingback.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestFail {

    private String errorMessage;
}
