package com.sesami.sesami_account_inquiry_service.bank.service.token;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sesami.sesami_account_inquiry_service.bank.module.OAuthToken;
import com.sesami.sesami_account_inquiry_service.bank.repository.OAuthTokenRepository;

@Service
public class OAuthTokenService {

//    @Autowired
//    private OAuthTokenRepository oAuthTokenRepository;
//
//    public String getStoredToken(String agentCode) {
//        return oAuthTokenRepository.getStoredToken(agentCode);
//    }
//
//    public Date getTokenTimestamp(String agentCode) {
//        return oAuthTokenRepository.getTokenTimestamp(agentCode);
//    }
//
//    public String getAgentCode() {
//        return oAuthTokenRepository.getAgentCode();
//    }
//
//    public void saveToken(String token, Date timestamp, String agentCode) {
//        tokenDAO.storeTokenDetails(token, timestamp, agentCode);
//    }
	
	

    @Autowired
    private OAuthTokenRepository tokenRepository;

    // Get the latest valid token for an agentCode, with caching
    @Cacheable(value = "oauthTokenCache", key = "#agentCode")
    public String getStoredToken(String agentCode) {
        Optional<OAuthToken> tokenOpt = tokenRepository.findTopByAgentCodeOrderByTimestampDesc(agentCode);
        if (tokenOpt.isPresent() && !isExpired(tokenOpt.get())) {
            return tokenOpt.get().getToken();
        }
        return null; // Or trigger token refresh logic here
    }

    public Date getTokenTimestamp(String agentCode) {
        Optional<OAuthToken> tokenOpt = tokenRepository.findTopByAgentCodeOrderByTimestampDesc(agentCode);
        return tokenOpt.map(OAuthToken::getTimestamp).orElse(null);
    }

    public void saveToken(String token, Date timestamp, String agentCode) {
        OAuthToken oAuthToken = new OAuthToken();
        oAuthToken.setToken(token);
        oAuthToken.setTimestamp(timestamp);
        oAuthToken.setAgentCode(agentCode);
        oAuthToken.setCreatedAt(new Date());
        oAuthToken.setStatus("active");
        tokenRepository.save(oAuthToken);
    }

    // Helper to check if token is expired
    private boolean isExpired(OAuthToken token) {
        if (token.getExpiresIn() == null) return false;
        long expiryTime = token.getTimestamp().getTime() + token.getExpiresIn() * 1000L;
        return System.currentTimeMillis() > expiryTime;
    }
}
