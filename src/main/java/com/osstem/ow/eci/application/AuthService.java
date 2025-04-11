package com.osstem.ow.eci.application;

import com.osstem.ow.eci.domain.EciStatus;
import com.osstem.ow.eci.domain.JwtService;
import com.osstem.ow.eci.domain.SessionResponse;
import com.osstem.ow.eci.infra.InfoBankApiClient;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final InfoBankApiClient infoBankApiClient;

    public AuthService(JwtService jwtService, InfoBankApiClient infoBankApiClient) {
        this.jwtService = jwtService;
        this.infoBankApiClient = infoBankApiClient;
    }

    public SessionResponse createSession(String id, String pw) {
        Object response = infoBankApiClient.getStatus(id, pw);
        // create token
        String token = jwtService.issueAccessToken(id, pw);
        return new SessionResponse(EciStatus.SUCCESS, "msg", token);
    }
}
