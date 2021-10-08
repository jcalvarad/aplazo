package com.aplazo.service.payments;

import java.time.LocalDate;

public class Payment {
    private final Integer payment_number;
    private final Double payment_amount;
    private final Double pending_amount;
	private final LocalDate date;

	public Payment(Integer payment_number, Double payment_amount, Double pending_amount, LocalDate date) {

		this.payment_number = payment_number;
		this.payment_amount = payment_amount;
        this.pending_amount = pending_amount;
        this.date = date;
	}

    public Integer getPayment_number() {
		return payment_number;
	}

	public Double getPayment_amount() {
		return payment_amount;
	}

    public Double getPending_amount() {
		return pending_amount;
	}

    public LocalDate getDate() {
        return date;
    }
}

