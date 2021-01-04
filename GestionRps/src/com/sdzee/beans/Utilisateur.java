package com.sdzee.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UTIL_ID")
	private int idUtilisateur;
	
	private String login;
	private String password;
	private static int nbUti = 0;
	
	@OneToMany
	@JoinColumn(name="CHARAID",referencedColumnName = "UTIL_ID",nullable = false)
	private List<Charactercss>listChara;
	
	
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
