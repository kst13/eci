package com.osstem.ow.eci.infra;

import com.osstem.ow.eci.domain.infobank.BaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class InfoBankApiClient {
    private WebClient webClient;

    public InfoBankApiClient() {
        this.webClient = WebClient.builder()
                .baseUrl("https://test.infobank.net:7000")
                .build();
    }

    public Object getStatus(String id, String pw) {
        return webClient.get()
                .uri("/info/v1/default")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header("OST-ID", id)
                .header("OST-PWD", pw)
                .exchangeToMono(response -> {
                    log.info("Response Code : {}", response.statusCode());
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(Object.class);
                    } else {
                        return response.bodyToMono(Object.class);
                    }
                })
                .block();
    }

    public BaseInfo getUserInfo(String id, String pw) {
        return webClient.get()
                .uri("/api/v1/userinfo")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header("OST-ID", id)
                .header("OST-PWD", pw)
                .exchangeToMono(response -> {
                    log.info("Response Code : {}", response.statusCode());
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(BaseInfo.class);
                    } else {
                        return response.bodyToMono(BaseInfo.class);
                    }
                })
                .block();
    }

    public Object getRegInfo(String id, String pw) {
        return webClient.get()
                .uri("/api/v1/reg")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header("OST-ID", id)
                .header("OST-PWD", pw)
                .exchangeToMono(response -> {
                    log.info("Response Code : {}", response.statusCode());
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(Object.class);
                    } else {
                        return response.bodyToMono(Object.class);
                    }
                })
                .block();
    }


}
