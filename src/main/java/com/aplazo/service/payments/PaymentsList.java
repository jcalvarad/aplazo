package com.aplazo.service.payments;
import java.time.LocalDate;
import java.util.ArrayList;

public class PaymentsList {
	private final ArrayList<Payment> paymentList;

	public PaymentsList(Double amount, Integer terms, Double rate) {
		int i;
		Double weeklyRate = rate/52;
		Double finalAmount = amount*(weeklyRate*terms/100+1);
		Double weeklyAmount = finalAmount/terms;
		ArrayList<Payment> payments = new ArrayList<Payment>();
		LocalDate currDate = LocalDate.now();

		for(i=1; i <= terms; i++ ){
			payments.add(new Payment(i, weeklyAmount, finalAmount-(weeklyAmount*i), currDate));
			currDate = currDate.plusWeeks(1);
		}
		this.paymentList = payments;

	}

	public ArrayList<Payment> getPaymentList() {
		return paymentList;
	}
}
