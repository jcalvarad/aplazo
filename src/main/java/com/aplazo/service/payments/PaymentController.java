package com.aplazo.service.payments;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class PaymentController {
	@Autowired
    PersistService persistService;

	ObjectMapper mapper = new ObjectMapper();
	private static final Logger logger 
      = LoggerFactory.getLogger(PaymentController.class);

	public PaymentController(){
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	@PutMapping("/payments")
	public PaymentsList createPayments(
		@RequestBody Request req ) {
			PaymentsList paymentsList = new PaymentsList(req.getAmount(), req.getTerms(), req.getRate());
			try{
				String reqJson = mapper.writeValueAsString(req);
				String listJson = mapper.writeValueAsString(paymentsList);
				persistService.save(new Persist("Req", reqJson));
				persistService.save(new Persist("Resp", listJson));
			}catch(JsonProcessingException e){
				logger.info(e.getMessage(), PaymentsList.class.getSimpleName());
			}
			return paymentsList;
	}
}
