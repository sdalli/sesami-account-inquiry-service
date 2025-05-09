package com.sesami.sesami_account_inquiry_service.bank.webservice;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sesami.sesami_account_inquiry_service.bank.controller.dto.AccountInquiryRequestDTO;

import reactor.core.publisher.Mono;


@Service
public class CbdWebServiceClient {

    private final Logger LOGGER = LoggerFactory.getLogger(CbdWebServiceClient.class);

    @Value("${server.ssl.keyStoreJksPath}")
    private String keyStoreJksPath;

    @Value("${server.ssl.keyStoreJksPassword}")
    private String keyStoreJksPassword;

    @Value("${cbd.client.webendpoint.url}")
    private String cbdWebEndPointURL;

    @Value("${cbd.client.service.account.inquiry.url}")
    private String accountInquiryUrl;

    @Value("${cbd.client.service.transaction.posting.url}")
    private String transactionPostingUrl;

    @Value("${cbd.client.service.clientId}")
    private String clientId;

    @Value("${cbd.client.service.clientSecret}")
    private String clientSecret;

    @Value("${cbd.client.service.SvcProviderName}")
    private String svcProviderName;

    @Value("${cbd.client.service.SvcProviderId}")
    private String svcProviderId;

    @Value("${cbd.client.service.SvcName.PartyAcctRelInqSCDMAcctVal}")
    private String partyAcctRelInqSCDMAcctVal;

    @Value("${cbd.client.service.SvcName.PartyAcctRelInqSCDMAcctInq}")
    private String partyAcctRelInqSCDMAcctInq;

    private final WebClient webClient;

    public CbdWebServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(cbdWebEndPointURL).build();
    }

    public Mono<String> getPartyAccountRelation(String requestBody, String correlationId) {
        LOGGER.debug("Calling getPartyAccountRelation with payload: {}", requestBody);

        return webClient.post()
                .uri(accountInquiryUrl)
                .header("Content-Type", "application/json")
                .header("x-correlation-id", correlationId)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(response -> LOGGER.debug("Response: {}", response))
                .doOnError(error -> LOGGER.error("Error during getPartyAccountRelation: ", error));
    }

    public Mono<String> getPartyAccountRelation_AccountNumber(AccountInquiryRequestDTO accountDetailsRequest) {
        String requestPayload;
        if (accountDetailsRequest.getAccountNumber().startsWith("1")) {
            requestPayload = "{\"PartyAcctRelInqRq\":{\"RqUID\":\"" + UUID.randomUUID()
                    + "\",\"MsgRqHdr\":{\"SvcIdent\":{\"SvcProviderName\":\"" + svcProviderName
                    + "\",\"SvcProviderId\":\"" + svcProviderId
                    + "\",\"SvcName\":\"" + partyAcctRelInqSCDMAcctVal
                    + "\"}},\"PartyAcctRelSel\":[{\"AcctKeys\":{\"AcctId\":\""
                    + accountDetailsRequest.getAccountNumber().trim() + "\"}}]}}";
        } else {
            requestPayload = "{\"PartyAcctRelInqRq\":{\"RqUID\":\"" + UUID.randomUUID()
                    + "\",\"MsgRqHdr\":{\"SvcIdent\":{\"SvcProviderName\":\"" + svcProviderName
                    + "\",\"SvcProviderId\":\"" + svcProviderId
                    + "\",\"SvcName\":\"" + partyAcctRelInqSCDMAcctInq
                    + "\"}},\"PartyAcctRelSel\":[{\"AcctKeys\":{\"VirAcctId\":\""
                    + accountDetailsRequest.getAccountNumber().trim() + "\"}}]}}";
        }

        LOGGER.debug("Calling getPartyAccountRelation_AccountNumber with payload: {}", requestPayload);

        return webClient.post()
                .uri(accountInquiryUrl)
                .header("Content-Type", "application/json")
                .header("client-id", clientId)
                .header("client-secret", clientSecret)
                .header("x-correlation-id", UUID.randomUUID().toString())
                .bodyValue(requestPayload)
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(response -> LOGGER.debug("Response: {}", response))
                .doOnError(error -> LOGGER.error("Error during getPartyAccountRelation_AccountNumber: ", error));
    }

    // Other methods can be similarly refactored to use WebClient
}
