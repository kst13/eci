package com.osstem.ow.eci.domain;

public record ConsentResponse(
        EciStatus code,
        EciData data,
        EciMessage message

) {

    public static ConsentResponse data(EciStatus code, EciMember member, EciService service) {
        return new ConsentResponse(code, new EciData(member,service), null);
    }
    public static ConsentResponse message(EciStatus code, EciMessage message) {
        return new ConsentResponse(code, null, message);
    }

}
