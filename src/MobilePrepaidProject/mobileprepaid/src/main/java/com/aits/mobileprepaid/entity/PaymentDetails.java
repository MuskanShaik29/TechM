package com.aits.mobileprepaid.entity;

import lombok.Data;

@Data
public class PaymentDetails {
    private String method;
    private String upiId;
    private String cardNumber;
    private String bankAccount;
	public PaymentDetails(String method, String upiId, String cardNumber, String bankAccount) {
		super();
		this.method = method;
		this.upiId = upiId;
		this.cardNumber = cardNumber;
		this.bankAccount = bankAccount;
	}
    
}