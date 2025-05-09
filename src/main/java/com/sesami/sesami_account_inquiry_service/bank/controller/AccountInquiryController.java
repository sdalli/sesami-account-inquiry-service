package com.sesami.sesami_account_inquiry_service.bank.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-account-service/api/")
public class AccountInquiryController {

	
	

//  @PostMapping("/party-account-relation")
//  public ResponseEntity<String> getPartyAccountRelation(@RequestBody String requestBody,
//                                                        @RequestHeader("x-correlation-id") String correlationId) {
//      return clientService.getPartyAccountRelation(requestBody, correlationId);
//  }
  // TODO ::  OLD CODE
//  @PostMapping("/fetch-account-details-by-account-number")
//  public ResponseEntity<String> getPartyAccountRelation(@RequestParam String accountNumber , @RequestParam String deviceId , @RequestParam String bankCode) {
//      return clientService.getPartyAccountRelation_AccountNumber(accountNumber);
//  }
  
//  @PostMapping("/fetch-account-details-by-account-number")
//  public ResponseEntity<AccountDetailsResponse> getPartyAccountRelation(@RequestBody AccountDetailsRequest request) {
//      ResponseEntity<String> response = clientService.getPartyAccountRelation_AccountNumber_mock(request);
//      return processResponse(response, request);
//  }
//  
//  private ResponseEntity<AccountDetailsResponse> processResponse(ResponseEntity<String> response, AccountDetailsRequest request) {
//      if (response.getStatusCode() == HttpStatus.OK) {
//      	CbdTransactionPostServiceRootResponse rootResponse = SesamiParsingUtil.convertJsonStringResponseToClassObject(response.getBody(), CbdTransactionPostServiceRootResponse.class);
//          return createAccountDetailsResponse(rootResponse, request);
//      } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
//          return createNotFoundResponse(request);
//      } else {
//          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//      }
//  }

  
  
//  @PostMapping("/fetch-account-details-by-account-number")
//  public ResponseEntity<AccountDetailsResponse> getPartyAccountRelation(@RequestBody AccountDetailsRequest request) {
//  	AccountDetailsResponse responseObject =null;
//
//  	// ResponseEntity<String> response = clientService.getPartyAccountRelation_AccountNumber(request);
//  	ResponseEntity<String> response = clientService.getPartyAccountRelation_AccountNumber_mock(request);
//  	if(response!= null && response.getStatusCode() == HttpStatus.OK) {
//
//  		 CbdAccountInquiryServiceRootResponse rootResponse = SesamiParsingUtil.convertJsonStringResponseToClassObject(response.getBody(), CbdAccountInquiryServiceRootResponse.class);
//  		
//  		
//  		responseObject = new AccountDetailsResponse();
//  		responseObject.setRequestUniqueNumber(SesamiParsingUtil.generateUniqueRequestNumber(request.getDeviceId()));
//  		if(rootResponse.getPartyAcctRelInqRs()!=null) {
//  			responseObject.setAccountNumber(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctKeys().getAcctId());
//      		responseObject.setAccountHolderName(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctTitle());
//      		responseObject.setAccountType(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctType().getAcctTypeValue());
//      		responseObject.setDailyDepositLimit(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctBal().getCurAmt().getAmt());
//      		responseObject.setMonthtlyTransactionLimit(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctBal().getCurAmt().getAmt());
//      		responseObject.setCurrencyCode(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctBal().getCurAmt().getCurCode().getCurCodeValue());
//      		responseObject.setAccountStatus(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctRec().getAcctStatus().getAcctStatusCode());
//      		responseObject.setDepositAllowed(Boolean.TRUE);
//	    		responseObject.setBankWebServiceCode(String.valueOf(rootResponse.getPartyAcctRelInqRs().getStatus().getStatusCode()));
//	            responseObject.setBankWebServiceDesc(rootResponse.getPartyAcctRelInqRs().getStatus().getStatusDesc());
//	            responseObject.setCdmApiCode(1);
//	            responseObject.setCdmCustomerErrorMessage("Account is valid");
//  		}else {
//  			 responseObject = SesamiParsingUtil.handleNotFoundResponse(response, request);
//  		}
//  		
//  	}else if(response!= null && response.getStatusCode() == HttpStatus.NOT_FOUND) {
//  		
//           responseObject = SesamiParsingUtil.handleNotFoundResponse(response, request);
//         
//  	}
//      
//      return ResponseEntity.ok(responseObject);
//  }
  
  
  
  
  
  
//  private ResponseEntity<AccountDetailsResponse> createAccountDetailsResponse(CbdTransactionPostServiceRootResponse rootResponse, AccountDetailsRequest request) {
//      AccountDetailsResponse responseObject = new AccountDetailsResponse();
//      responseObject.setRequestUniqueNumber(SesamiParsingUtil.generateUniqueRequestNumber(request.getDeviceId()));
//      responseObject.setAccountNumber(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctKeys().getAcctId());
//      responseObject.setAccountHolderName(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctTitle());
//      responseObject.setAccountType(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctType().getAcctTypeValue());
//      responseObject.setDailyDepositLimit(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctBal().getCurAmt().getAmt());
//      responseObject.setMonthtlyTransactionLimit(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctBal().getCurAmt().getAmt());
//      responseObject.setCurrencyCode(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctInfo().getAcctBal().getCurAmt().getCurCode().getCurCodeValue());
//      responseObject.setAccountStatus(rootResponse.getPartyAcctRelInqRs().getPartyAcctRelRec().getPartyAcctRelInfo().getAcctRef().getAcctRec().getAcctStatus().getAcctStatusCode());
//      responseObject.setDepositAllowed(Boolean.TRUE);
//      responseObject.setBankWebServiceCode(String.valueOf(rootResponse.getPartyAcctRelInqRs().getStatus().getStatusCode()));
//      responseObject.setBankWebServiceDesc(rootResponse.getPartyAcctRelInqRs().getStatus().getStatusDesc());
//      responseObject.setCdmApiCode(1);
//      responseObject.setCdmCustomerErrorMessage("Account is valid");
//      return ResponseEntity.ok(responseObject);
//  }

//  private ResponseEntity<AccountDetailsResponse> createNotFoundResponse(AccountDetailsRequest request) {
//      AccountDetailsResponse responseObject = SesamiParsingUtil.handleNotFoundResponse(ResponseEntity.status(HttpStatus.NOT_FOUND).build(), request);
//      return ResponseEntity.ok(responseObject);
//  }
    
    
}
