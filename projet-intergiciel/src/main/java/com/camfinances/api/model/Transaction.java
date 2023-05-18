package com.camfinances.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name="id")
    private Long id;

    @Column(name = "emetteur")
    private String emetteur;

    @Column(name = "recepteur")
    private String recepteur;

    @Column(name = "montant")
    private Long montant;

    @Column(name = "devise")
    private String devise;

    @Column(name = "question")
    private String question;

    @Column(name = "reponse")
    private String reponse;

    @NotNull(message = "Le transitaire ne peut etre null")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // @CreationTimestamp
	// @Column(name = "created_at", nullable = false, updatable = false)
	// private Date createdAt; 
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;


}
