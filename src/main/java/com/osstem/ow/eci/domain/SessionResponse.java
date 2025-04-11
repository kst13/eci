package com.osstem.ow.eci.domain;

public record SessionResponse(
        EciStatus code,
        String message,
        String token
) {
}
