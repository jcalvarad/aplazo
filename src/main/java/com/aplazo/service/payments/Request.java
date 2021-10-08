package com.aplazo.service.payments;

public class Request {

    private Double amount;
    private Integer terms;
    private Double rate;

    public Request(Double amount, Integer terms, Double rate) {
		this.amount = amount;
		this.terms = terms;
		this.rate = rate;
	}

    public Double getAmount() {
		return amount;
	}

    public Integer getTerms() {
		return terms;
	}

    public Double getRate() {
		return rate;
	}
}
