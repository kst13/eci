package com.osstem.ow.eci.domain;

import lombok.Getter;

@Getter
public enum EciStatus {
    SUCCESS("공통", "A200", "success", "성공");

    private final String type;
    private final String code;
    private final String message;
    private final String description;

    EciStatus(String type, String code, String message, String description) {
        this.type = type;
        this.code = code;
        this.message = message;
        this.description = description;
    }
}
