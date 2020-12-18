package com.sdzee.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUtilisateur;
	private String login;
	private String password;
	private static int nbUti = 0;
	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
		nbUti++;
		idUtilisateur = nbUti+1;
		
		
	}
	public Utilisateur(String login, String password) {
		nbUti++;
		idUtilisateur = nbUti+1;
		this.login = login;
		this.password = password;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
