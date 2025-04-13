package com.osstem.ow.eci.domain.infobank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private String result_code;
    private String result_msg;
}
