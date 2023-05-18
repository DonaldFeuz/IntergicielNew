package com.camfinances.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name="id")
	private Long id;
	
	@NotNull(message = "Le nom ne peut etre null")
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
    
	@Email
    @Column(name="email")
	private String email;

    @Column(name="role")
	private String role;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt; 
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name="mdp")
	private String mdp;

	@Column(name="datnais")
	private String datnais;

	@Column(name="ville")
	private String ville;

	@Column(name="pays")
	private String pays;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getDatenais() {
		return datnais;
	}

	public void setDatenais(String datnais) {
		this.datnais = datnais;
	}

	public String getVile() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
}
