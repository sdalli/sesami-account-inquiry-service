package com.sesami.sesami_account_inquiry_service.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sesami.sesami_account_inquiry_service.bank.module.OAuthToken;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OAuthTokenRepository extends JpaRepository<OAuthToken, Integer> {

    // Find the latest token for an agentCode
    Optional<OAuthToken> findTopByAgentCodeOrderByTimestampDesc(String agentCode);

    // Find all tokens for an agentCode
    List<OAuthToken> findByAgentCode(String agentCode);

    // Find tokens by status
    List<OAuthToken> findByStatus(String status);

    // Find tokens that are expired (example: timestamp + expiresIn < now)
    @Query("SELECT t FROM OAuthToken t WHERE (t.timestamp IS NOT NULL AND t.expiresIn IS NOT NULL) AND (t.timestamp + (t.expiresIn * 1000)) < CURRENT_TIMESTAMP")
    List<OAuthToken> findExpiredTokens();

    // Find tokens created after a certain date
    List<OAuthToken> findByCreatedAtAfter(Date date);

    // Find tokens by clientId
    List<OAuthToken> findByClientId(String clientId);

    // Delete all tokens for an agentCode
    void deleteByAgentCode(String agentCode);

    // Count tokens for an agentCode
    long countByAgentCode(String agentCode);

    // Find all tokens with a specific error description
    List<OAuthToken> findByErrorDescription(String errorDescription);

    // Find all tokens with a specific remarks
    List<OAuthToken> findByRemarks(String remarks);

    // Find all tokens by tokenType
    List<OAuthToken> findByTokenType(String tokenType);

    // Find all tokens by scope
    List<OAuthToken> findByScope(String scope);

    // Find all tokens by status and agentCode
    List<OAuthToken> findByStatusAndAgentCode(String status, String agentCode);

    // Custom query to get the latest valid token for an agentCode
    @Query("SELECT t FROM OAuthToken t WHERE t.agentCode = :agentCode AND t.status = 'active' ORDER BY t.timestamp DESC")
    List<OAuthToken> findLatestActiveTokenByAgentCode(String agentCode);

}