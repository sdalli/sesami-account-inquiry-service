package com.sesami.sesami_account_inquiry_service.bank.module;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "oauth_tokens")
public class OAuthToken {
    

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "token", nullable = false, columnDefinition = "NVARCHAR(MAX)")
        private String token;

        @Column(name = "timestamp", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date timestamp;

        @Column(name = "agentCode", length = 100)
        private String agentCode;

        @Column(name = "expiresIn")
        private Integer expiresIn;

        @Column(name = "refreshToken", columnDefinition = "NVARCHAR(MAX)")
        private String refreshToken;

        @Column(name = "tokenType", length = 50)
        private String tokenType;

        @Column(name = "scope", columnDefinition = "NVARCHAR(255)")
        private String scope;

        @Column(name = "createdBy", length = 100)
        private String createdBy;

        @Column(name = "createdAt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdAt;

        @Column(name = "updatedAt")
        @Temporal(TemporalType.TIMESTAMP)
        private Date updatedAt;

        @Column(name = "status", length = 20)
        private String status;

        @Column(name = "errorDescription", columnDefinition = "NVARCHAR(255)")
        private String errorDescription;

        @Column(name = "clientId", length = 100)
        private String clientId;

        @Column(name = "remarks", columnDefinition = "NVARCHAR(255)")
        private String remarks;

        // Constructors
        public OAuthToken() {}

        // Getters and setters

        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }

        public String getToken() { return token; }
        public void setToken(String token) { this.token = token; }

        public Date getTimestamp() { return timestamp; }
        public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

        public String getAgentCode() { return agentCode; }
        public void setAgentCode(String agentCode) { this.agentCode = agentCode; }

        public Integer getExpiresIn() { return expiresIn; }
        public void setExpiresIn(Integer expiresIn) { this.expiresIn = expiresIn; }

        public String getRefreshToken() { return refreshToken; }
        public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }

        public String getTokenType() { return tokenType; }
        public void setTokenType(String tokenType) { this.tokenType = tokenType; }

        public String getScope() { return scope; }
        public void setScope(String scope) { this.scope = scope; }

        public String getCreatedBy() { return createdBy; }
        public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

        public Date getCreatedAt() { return createdAt; }
        public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

        public Date getUpdatedAt() { return updatedAt; }
        public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getErrorDescription() { return errorDescription; }
        public void setErrorDescription(String errorDescription) { this.errorDescription = errorDescription; }

        public String getClientId() { return clientId; }
        public void setClientId(String clientId) { this.clientId = clientId; }

        public String getRemarks() { return remarks; }
        public void setRemarks(String remarks) { this.remarks = remarks; }
    

}
