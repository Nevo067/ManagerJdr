package com.sdzee.beans;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Characterc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCharacterc;
	
	private String nom;
	private String mana;
	private String stress;
	//Characteristique
	private Integer forTce;
	

	private Integer constitution;
	private Integer dexterite;
	private Integer perception;
	private Integer courage;
	//Foreign Key
	
	@Column(name="CHARAID")
	private int idUtilisateur;
	
	public Characterc() {
		super();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMana() {
		return mana;
	}
	public void setMana(String mana) {
		this.mana = mana;
	}
	public String getStress() {
		return stress;
	}
	public void setStress(String stress) {
		this.stress = stress;
	}
	public int getForce() {
		return forTce;
	}
	public void setForce(int force) {
		this.forTce = force;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getDexterite() {
		return dexterite;
	}
	public void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}
	public int getPerception() {
		return perception;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public void setPerception(int perception) {
		this.perception = perception;
	}
	public int getCourage() {
		return courage;
	}
	public void setCourage(int courage) {
		this.courage = courage;
	}
	public Integer getIdCharacterc() {
		return idCharacterc;
	}
	public void setIdCharacterc(Integer idCharacterc) {
		this.idCharacterc = idCharacterc;
	}
	public Integer getForTce() {
		return forTce;
	}
	public void setForTce(Integer forTce) {
		this.forTce = forTce;
	}
	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}
	public void setDexterite(Integer dexterite) {
		this.dexterite = dexterite;
	}
	public void setPerception(Integer perception) {
		this.perception = perception;
	}
	public void setCourage(Integer courage) {
		this.courage = courage;
	}
	
	@Override
	public String toString() {
		return "Character [id=" + idCharacterc + ", nom=" + nom + ", mana=" + mana + ", stress=" + stress + ", force=" + forTce
				+ ", constitution=" + constitution + ", dexterite=" + dexterite + ", perception=" + perception
				+ ", courage=" + courage +  "]";
	}
	
	
	
}
