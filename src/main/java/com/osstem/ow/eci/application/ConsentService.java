package com.osstem.ow.eci.application;

import com.osstem.ow.eci.domain.ConsentResponse;
import com.osstem.ow.eci.domain.EciMember;
import com.osstem.ow.eci.domain.EciService;
import com.osstem.ow.eci.domain.EciStatus;
import com.osstem.ow.eci.domain.infobank.BaseInfo;
import com.osstem.ow.eci.domain.infobank.UserInfo;
import com.osstem.ow.eci.infra.InfoBankApiClient;
import org.springframework.stereotype.Service;

@Service
public class ConsentService {

    private final InfoBankApiClient infoBankApiClient;

    public ConsentService(InfoBankApiClient infoBankApiClient) {
        this.infoBankApiClient = infoBankApiClient;
    }


    public ConsentResponse getUserInfo(String id, String password) {
        BaseInfo baseInfo =  infoBankApiClient.getUserInfo(id, password);
        EciService eciService = new EciService(
                baseInfo.getUserInfoVO().getPsPrice(),
                baseInfo.getUserInfoVO().get_080_service(),
                baseInfo.getCallbackPhones(),
                null,
                null);
        EciMember eciMember = new EciMember(baseInfo.getUserInfoVO());
        return ConsentResponse.data(EciStatus.SUCCESS, eciMember, eciService);
    }

    public Object callback(String id, String password) {
        return infoBankApiClient.getRegInfo(id, password);
    }

}
