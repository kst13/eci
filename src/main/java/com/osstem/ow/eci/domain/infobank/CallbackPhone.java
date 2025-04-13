package com.osstem.ow.eci.domain.infobank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CallbackPhone {
    private String ca_idx;
    private String cb_idx;
    private String auth_type;
    private String callback_num;
}
