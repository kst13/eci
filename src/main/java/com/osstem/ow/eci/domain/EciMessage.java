package com.osstem.ow.eci.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EciMessage (
        String userId,
        String psPrice,
        @JsonProperty("co_billType")
        String coBillType,
        String consentSign
){
}
