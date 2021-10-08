package com.aplazo.service.payments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persist {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String type;
    @Column(columnDefinition = "LONGTEXT")
    private String body;

    public Persist(String type, String body){
        this.type = type;
        this.body = body;
    }
}
