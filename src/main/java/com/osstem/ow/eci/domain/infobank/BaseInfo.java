package com.osstem.ow.eci.domain.infobank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseInfo extends BaseResponse{
    private UserInfo userInfoVO;
    private List<CallbackPhone> callbackPhones;
}
