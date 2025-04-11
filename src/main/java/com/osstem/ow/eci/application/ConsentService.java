package com.osstem.ow.eci.application;

import com.osstem.ow.eci.infra.InfoBankApiClient;
import org.springframework.stereotype.Service;

@Service
public class ConsentService {

    private final InfoBankApiClient infoBankApiClient;

    public ConsentService(InfoBankApiClient infoBankApiClient) {
        this.infoBankApiClient = infoBankApiClient;
    }


    public Object getUserInfo(String id, String password) {
        return infoBankApiClient.getUserInfo(id, password);
    }

}
