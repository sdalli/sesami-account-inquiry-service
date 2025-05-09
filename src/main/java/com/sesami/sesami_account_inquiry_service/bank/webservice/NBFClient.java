package com.sesami.sesami_account_inquiry_service.bank.webservice;

import org.springframework.stereotype.Service;

@Service
public class NBFClient {

//	 	private static final Logger log = LoggerFactory.getLogger(NBFClient.class);
//
//	    private final WebClient webClient;
//	    private final OAuthTokenService oAuthTokenService;
//
//	    @Value("${nbfAgentCode}")
//	    private String nbfAgentCode;
//	    @Value("${nbfAccountInquiryURL}")
//	    private String nbfAccountInquiryURL;
//	    @Value("${nbfTransactionPostingURL}")
//	    private String nbfTransactionPostingURL;
//	    @Value("${nbfServiceType}")
//	    private String nbfServiceType;
//	    @Value("${nbfAcMessageType}")
//	    private String nbfAcMessageType;
//	    @Value("${nbfMsgFormat}")
//	    private String nbfMsgFormat;
//	    @Value("${nbfRequestUserId}")
//	    private String nbfRequestUserId;
//	    @Value("${nbfRequestorChannelId}")
//	    private String nbfRequestorChannelId;
//	    @Value("${nbfTransactionType}")
//	    private String nbfTransactionType;
//	    @Value("${nbfAcInqAccReqType}")
//	    private String nbfAcInqAccReqType;
//	    @Value("${nbfMessageType}")
//	    private String nbfMessageType;
//	    @Value("${nbfDestinationChannelId}")
//	    private String nbfDestinationChannelId;
//
//	    public NBFClient(WebClient.Builder webClientBuilder, OAuthTokenService oAuthTokenService) {
//	        this.webClient = webClientBuilder.build();
//	        this.oAuthTokenService = oAuthTokenService;
//	    }
//
//	    // 1. Account Inquiry Service
//	    public DinoPayAccountEnquiryResponseData accountInquiry(Transaction txn) {
//	        String token = oAuthTokenService.getStoredToken(nbfAgentCode);
//	        DinoPayAccountEnquiryRequestBean request = buildAccountInquiryRequest(txn);
//
//	        return webClient.post()
//	                .uri(nbfAccountInquiryURL)
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .accept(MediaType.APPLICATION_JSON)
//	                .header("Authorization", "Bearer " + token)
//	                .bodyValue(request)
//	                .retrieve()
//	                .bodyToMono(DinoPayAccountEnquiryResponseData.class)
//	                .block(Duration.ofSeconds(30));
//	    }
//
//	    // 2. OAuthToken Calls (delegated to OAuthTokenService)
//	    public String getOAuthToken() {
//	        return oAuthTokenService.getStoredToken(nbfAgentCode);
//	    }
//
//	    // 3. Transaction Posting Service
//	    public DinoPayPaymentResponseData postTransaction(Transaction txn, DinoPayAccountEnquiryResponseData inquiryData) {
//	        String token = getOAuthToken();
//	        DinoPaymentTransferRequestBean request = buildTransactionRequest(txn, inquiryData);
//
//	        return webClient.post()
//	                .uri(nbfTransactionPostingURL)
//	                .contentType(MediaType.APPLICATION_JSON)
//	                .accept(MediaType.APPLICATION_JSON)
//	                .header("Authorization", "Bearer " + token)
//	                .bodyValue(request)
//	                .retrieve()
//	                .bodyToMono(DinoPayPaymentResponseData.class)
//	                .block(Duration.ofSeconds(30));
//	    }
//
//	    // Helper: Build Account Inquiry Request
//	    private DinoPayAccountEnquiryRequestBean buildAccountInquiryRequest(Transaction txn) {
//	        DinoPayAccountEnquiryRequest body = new DinoPayAccountEnquiryRequest();
//	        body.setServiceType(nbfServiceType);
//	        body.setMessageType(nbfAcMessageType);
//	        body.setMsgFormat(nbfMsgFormat);
//	        body.setRequestorId(nbfRequestUserId);
//	        body.setTimeStamp(String.valueOf(System.currentTimeMillis()));
//	        body.setRequestorChannelId(nbfRequestorChannelId);
//	        body.setTransactionType(nbfTransactionType);
//	        body.setTerminalID(txn.getGlDebitAccount());
//	        body.setTransactionID(txn.getTransactionId());
//	        body.setCardNo("");
//	        body.setAccountNo(txn.getAccountNumber());
//	        body.setAccReqType(nbfAcInqAccReqType);
//
//	        DinoPayAccountEnquiryRequestBean bean = new DinoPayAccountEnquiryRequestBean();
//	        bean.setHeader(setDinoPaymentHeader(txn));
//	        bean.setBody(body);
//	        return bean;
//	    }
//
//	    // Helper: Build Transaction Posting Request
//	    private DinoPaymentTransferRequestBean buildTransactionRequest(Transaction txn, DinoPayAccountEnquiryResponseData inquiryData) {
//	        DinoPayPaymentRequest body = new DinoPayPaymentRequest();
//	        // Set all required fields from txn and inquiryData
//	        // ...existing code to populate body...
//
//	        DinoPaymentTransferRequestBean bean = new DinoPaymentTransferRequestBean();
//	        bean.setHeader(setDinoPaymentHeader(txn));
//	        bean.setBody(body);
//	        return bean;
//	    }
//
//	    // Helper: Build Payment Header
//	    private DinoPayPaymentHeader setDinoPaymentHeader(Transaction txn) {
//	        DinoPayPaymentHeader header = new DinoPayPaymentHeader();
//	        header.setMsgFormat("JSON");
//	        header.setMsgVersion("1.0");
//	        header.setRequestorId(nbfRequestUserId);
//	        header.setRequestorChannelId(nbfRequestorChannelId);
//	        header.setDestinationChannelId(nbfDestinationChannelId);
//	        header.setRequestorUserId(nbfRequestUserId);
//	        header.setRequestorLanguage("EN");
//	        header.setRequestorSecurityInfo("");
//	        header.setCreatedTimeStamp(new Date().toString());
//	        header.setEaiReference(txn.getTransactionId());
//	        header.setReturnCode("");
//	        return header;
//	    }
	    
	    
}
