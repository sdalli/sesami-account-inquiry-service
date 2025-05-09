package com.sesami.sesami_account_inquiry_service.bank.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NbfWebServiceClient {


    private static final Logger log = LoggerFactory.getLogger(NbfWebServiceClient.class);
//
//    private final WebClient webClient;
//    private final OAuthTokenService oAuthTokenService;
//    // private final NbfPropertyRepository nbfPropertyRepository; // You must implement this
//
//    @Value("${nbf.agent.code}")
//    private String nbfAgentCode;
//    
//    @Value("${cbd.client.webendpoint.url}")
//    private String cbdWebEndPointURL;
//
//    public NbfWebServiceClient(OAuthTokenService oAuthTokenService , WebClient.Builder webClientBuilder) {
//        this.webClient =  webClientBuilder.baseUrl(cbdWebEndPointURL).build();
//        this.oAuthTokenService = oAuthTokenService;
//        // this.nbfPropertyRepository = nbfPropertyRepository;
//    }
//
//    // 1. Save the token to database
//    public String getOAuthToken() {
//        String token = oAuthTokenService.getStoredToken(nbfAgentCode);
//        Date tokenTime = oAuthTokenService.getTokenTimestamp(nbfAgentCode);
//        if (token != null && tokenTime != null && Duration.between(tokenTime.toInstant(), new Date().toInstant()).toHours() < 5) {
//            return token;
//        }
//        String newToken = fetchOAuthTokenFromServer();
//        oAuthTokenService.saveToken(newToken, new Date(), nbfAgentCode);
//        return newToken;
//    }
//
//    private String fetchOAuthTokenFromServer() {
//        String url = getProperty("nbfOAuthTokenURL");
//        String apiKey = getProperty("nbfApiKey");
//        String clientId = getProperty("nbfApiClientid");
//        String clientSecret = getProperty("nbfApiClientSecret");
//
//        var request = Map.of(
//                "clientId", clientId,
//                "clientSecret", clientSecret,
//                "grantType", "client_credentials"
//        );
//
//        NbfOAuthTokenResponse response = webClient.post()
//                .uri(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .header("NBF-APIKey", apiKey)
//                .bodyValue(request)
//                .retrieve()
//                .bodyToMono(NbfOAuthTokenResponse.class)
//                .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).maxBackoff(Duration.ofSeconds(10)))
//                .block(Duration.ofSeconds(30));
//
//        return response != null ? response.getAccessToken() : null;
//    }
//
//    // 2. Account inquiry service
//    public DinoPayAccountEnquiryResponseData accountInquiry(Transaction txn) {
//        String url = getProperty("nbfAccountInquiryURL");
//        String token = getOAuthToken();
//
//        DinoPayAccountEnquiryRequestBean req = buildAccountInquiryRequest(txn);
//
//        DinoPayAccountEnquiryResponseData response = webClient.post()
//                .uri(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .headers(headers -> headers.setBearerAuth(token))
//                .bodyValue(req)
//                .retrieve()
//                .bodyToMono(DinoPayAccountEnquiryResponseData.class)
//                .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).maxBackoff(Duration.ofSeconds(10)))
//                .block(Duration.ofSeconds(30));
//
//        return response;
//    }
//
//    // 3. Transaction posting service
//    public DinoPayPaymentResponseData postTransaction(Transaction txn, DinoPayAccountEnquiryResponseData inquiryData) {
//        String url = getProperty("nbfTransactionPostingURL");
//        String token = getOAuthToken();
//
//        DinoPaymentTransferRequestBean req = buildTransactionRequest(txn, inquiryData);
//
//        DinoPayPaymentResponseData response = webClient.post()
//                .uri(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .headers(headers -> headers.setBearerAuth(token))
//                .bodyValue(req)
//                .retrieve()
//                .bodyToMono(DinoPayPaymentResponseData.class)
//                .retryWhen(Retry.backoff(3, Duration.ofSeconds(2)).maxBackoff(Duration.ofSeconds(10)))
//                .block(Duration.ofSeconds(30));
//
//        return response;
//    }

    // 4. Get all property values from DB and cache in session for 5 hours
//    @Cacheable(value = "nbfProperties", key = "'all'")
//    public Map<String, String> getAllProperties() {
//        log.info("Loading NBF properties from DB...");
//        return nbfPropertyRepository.findAllAsMap();
//    }
//
//    // 5. Refresh cache every 5 hours
//    @Scheduled(fixedRate = 5 * 60 * 60 * 1000)
//    @CacheEvict(value = "nbfProperties", key = "'all'")
//    public void refreshPropertiesCache() {
//        log.info("Refreshing NBF properties cache...");
//    }

    // Helper to get property from cache
//    private String getProperty(String key) {
//        return getAllProperties().get(key);
//    }

    // Helper: build account inquiry request
//    private DinoPayAccountEnquiryRequestBean buildAccountInquiryRequest(Transaction txn) {
//        // Build and return request bean as per your DTOs
//        // ...existing code...
//        return new DinoPayAccountEnquiryRequestBean();
//    }
//
//    // Helper: build transaction posting request
//    private DinoPaymentTransferRequestBean buildTransactionRequest(Transaction txn, DinoPayAccountEnquiryResponseData inquiryData) {
//        // Build and return request bean as per your DTOs
//        // ...existing code...
//        return new DinoPaymentTransferRequestBean();
//    }
}
