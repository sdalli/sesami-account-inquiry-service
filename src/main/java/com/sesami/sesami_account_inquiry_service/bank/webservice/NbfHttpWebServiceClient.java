package com.sesami.sesami_account_inquiry_service.bank.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;

import com.sesami.sesami_account_inquiry_service.bank.service.token.OAuthTokenService;
import com.sesami.sesami_account_inquiry_service.common.config.WebClientConfig;

public class NbfHttpWebServiceClient {
    private static final Logger log = LoggerFactory.getLogger(NbfWebServiceClient.class);


    
  private final WebClientConfig webClient;
  private final OAuthTokenService oAuthTokenService;
  // private final NbfPropertyRepository nbfPropertyRepository; // You must implement this

  @Value("${nbf.agent.code}")
  private String nbfAgentCode;
  
  @Value("${cbd.client.webendpoint.url}")
  private String cbdWebEndPointURL;
  
  private static final long TOKEN_VALIDITY_DURATION = 10 * 60 * 1000; // 10 minutes in milliseconds

  public NbfHttpWebServiceClient(OAuthTokenService oAuthTokenService , WebClientConfig webClient) {
      this.webClient =  webClient;
      this.oAuthTokenService = oAuthTokenService;
      // this.nbfPropertyRepository = nbfPropertyRepository;
  }

//    private String getNBFAuthCodeToken() {
//        log.info("NBFClient method getNBFAuthCodeToken() Start");
//
//        try {
//            // Retrieve token and timestamp from database
//            String storedToken;
//            Date storedTimestamp;
//
//            try {
//                storedToken = oAuthTokenService.getStoredToken(nbfAgentCode);
//                storedTimestamp = oAuthTokenService.getTokenTimestamp(nbfAgentCode);
//            } catch (EmptyResultDataAccessException e) {
//                // Handle the case where no token is found in the database
//                log.warn("No stored OAuth token found. Requesting a new one.");
//                return requestNewOAuthToken();
//            }
//
//            // Check if the token is still valid
//            if (storedToken != null && storedTimestamp != null) {
//                long currentTime = System.currentTimeMillis();
//                long tokenAge = currentTime - storedTimestamp.getTime();
//
//                if (tokenAge < TOKEN_VALIDITY_DURATION) {
//                    log.info("Reusing valid OAuth token.");
//                    return storedToken;
//                }
//            }
//
//            // If no valid token, request a new one
//            log.info("Requesting new OAuth token.");
//            String response = requestNewOAuthToken();
//
//            // Parse and store the new token
//            // NbfOAuthTokenResponse tokenResponse = parseNbfOAuthTokenResponseStringToObject(response);
//            if (response != null && response!=null) {
//                String newToken = response;
//                oAuthTokenService.saveToken(newToken, new Date(), nbfAgentCode);
//                return newToken;
//            } else {
//                throw new Exception("Failed to parse OAuth token response.");
//            }
//        } catch (Exception e) {
//            log.error("Error in getNBFAuthCodeToken(): " + e.getMessage(), e);
//            throw new RuntimeException("Unable to retrieve OAuth token", e);
//        } finally {
//            log.info("NBFClient method getNBFAuthCodeToken() End");
//        }
//    }




//    private String requestNewOAuthToken() throws Exception {
//        String response = fetchOAuthTokenFromServer();
//
//        // Parse and store the new token
//        NbfOAuthTokenResponse tokenResponse = parseNbfOAuthTokenResponseStringToObject(response);
//        if (tokenResponse != null) {
//            String newToken = tokenResponse.getAccessToken();
//            oAuthTokenService.saveToken(newToken, new Date(), nbfAgentCode);
//            return newToken;
//        } else {
//            throw new Exception("Failed to parse OAuth token response.");
//        }
//    }

  String nbfApiClientid="scdmuseruat";
  String nbfApiClientSecret="scdmuseruat123";
    private String fetchOAuthTokenFromServer() throws IOException {
        String tokenUrl = "https://nbfappextwmuat.nbf.ae/gateway/v1/accessToken/getOAuthToken";
        String content = "{\"clientId\":\"" + nbfApiClientid + "\",\"clientSecret\":\"" + nbfApiClientSecret
                + "\",\"grantType\":\"client_credentials\"}";
        HttpsURLConnection connection = null;
        BufferedReader reader = null;

//        System.setProperty("javax.net.ssl.trustStore", keyStoreJksPath.trim());
//        System.setProperty("javax.net.ssl.trustStorePassword", keyStoreJksPassword.trim());
//        System.setProperty("javax.net.ssl.keyStore", keyStoreJksPath.trim());
//        System.setProperty("javax.net.ssl.keyStorePassword", keyStoreJksPassword.trim());

        try {
            URL url = new URL(tokenUrl);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("NBF-APIKey", "387a8061-53e4-4f75-9183-fc07373944ce");

            try (OutputStream os = connection.getOutputStream()) {
                os.write(content.getBytes());
            }

            StringBuilder response = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }




    public static void main(String[] args) throws IOException {
		
    	NbfHttpWebServiceClient client = new NbfHttpWebServiceClient(null, null);
    	
    	System.out.println(client.fetchOAuthTokenFromServer());
    	
    	
	}




}
