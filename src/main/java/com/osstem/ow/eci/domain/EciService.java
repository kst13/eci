package com.osstem.ow.eci.domain;

import com.osstem.ow.eci.domain.infobank.CallbackPhone;

import java.util.List;

public record EciService(
        String psPrice,
        String _080_service,
        List<CallbackPhone> callbackPhones,
        String senderKey,
        String pf_id
) {
}
