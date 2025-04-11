package com.osstem.ow.eci.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties (
        long accessExpirationTime
){

}
