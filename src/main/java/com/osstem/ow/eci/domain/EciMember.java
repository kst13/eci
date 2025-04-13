package com.osstem.ow.eci.domain;

import com.osstem.ow.eci.domain.infobank.UserInfo;

public record EciMember(
        String userId,
        String userno,
        String co_name,
        String co_businumber,
        String co_representative,
        String co_conditions,
        String co_category,
        String co_phone,
        String co_fax,
        String co_post,
        String co_address,
        String co_address2,
        String em_name,
        String em_mobile,
        String em_phone

) {
    public EciMember(UserInfo userInfoVO) {
        this(
                userInfoVO.getUserId(),
                userInfoVO.getUserno(),
                userInfoVO.getCo_name(),
                userInfoVO.getCo_businumber(),
                userInfoVO.getCo_representative(),
                userInfoVO.getCo_conditions(),
                userInfoVO.getCo_category(),
                userInfoVO.getCo_phone(),
                userInfoVO.getCo_fax(),
                userInfoVO.getCo_post(),
                userInfoVO.getCo_address(),
                userInfoVO.getCo_address2(),
                userInfoVO.getEm_name(),
                userInfoVO.getEm_mobile(),
                userInfoVO.getEm_phone()
        );
    }

}
