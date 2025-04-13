package com.osstem.ow.eci.domain;

public record EciPayment(
        boolean cms_agree,
        String co_billType,
        String co_depositor,
        String co_businumber,
        String co_bank,
        String co_accountNumber,
        String coApplyName,
        String coApplyRel,
        String coApplyTel,
        String coApplyPhone

) {
}
