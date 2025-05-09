package com.sesami.sesami_account_inquiry_service.bank.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AccountInquiryRequestDTO {

	@NotBlank(message = "Request Transaction Id is required")
	@Size(max = 40, message = "Request Transaction Id  exceed 40 characters")
	private String requestUniqueNumber;
	
	@NotBlank(message = "Account Number/IBAN is required")
	@Size(max = 40, message = "Account Number/IBAN  exceed 40 characters")
    private String accountNumber;
	
	@NotBlank(message = "Device id is required")
	@Size(max = 20, message = "Device Id  exceed 20 characters")
    private String deviceId;
    
	@NotBlank(message = "Bank Code is required")
	@Size(max = 20, message = "Bank Code  exceed 20 characters")
    private String bankCode;
    
	@NotBlank(message = "subBankCode is required")
    private String subBankCode;
    
    @NotBlank(message = "GL Account Number/IBAN is required")
	@Size(max = 40, message = "GL Account Number/IBAN  exceed 40 characters")
    private String glAccountNumber;
    
    @NotBlank(message = "Online Account validation is required - true / false")
    private String onlineRequired;
    
    private String extraField1; // 1: online bank API validation /1: offline Integration validation
    private String extraField2;
    private String extraField3;
    private String extraField4;
    private String extraField5;
	public String getRequestUniqueNumber() {
		return requestUniqueNumber;
	}
	public void setRequestUniqueNumber(String requestUniqueNumber) {
		this.requestUniqueNumber = requestUniqueNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getSubBankCode() {
		return subBankCode;
	}
	public void setSubBankCode(String subBankCode) {
		this.subBankCode = subBankCode;
	}
	public String getGlAccountNumber() {
		return glAccountNumber;
	}
	public void setGlAccountNumber(String glAccountNumber) {
		this.glAccountNumber = glAccountNumber;
	}
	public String getOnlineRequired() {
		return onlineRequired;
	}
	public void setOnlineRequired(String onlineRequired) {
		this.onlineRequired = onlineRequired;
	}
	public String getExtraField1() {
		return extraField1;
	}
	public void setExtraField1(String extraField1) {
		this.extraField1 = extraField1;
	}
	public String getExtraField2() {
		return extraField2;
	}
	public void setExtraField2(String extraField2) {
		this.extraField2 = extraField2;
	}
	public String getExtraField3() {
		return extraField3;
	}
	public void setExtraField3(String extraField3) {
		this.extraField3 = extraField3;
	}
	public String getExtraField4() {
		return extraField4;
	}
	public void setExtraField4(String extraField4) {
		this.extraField4 = extraField4;
	}
	public String getExtraField5() {
		return extraField5;
	}
	public void setExtraField5(String extraField5) {
		this.extraField5 = extraField5;
	}
	    
	    
	    
}
