package com.sdzee.beans;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Character {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String mana;
	private String stress;
	//Characteristique
	private int force;
	private int constitution;
	private int dexterite;
	private int perception;
	private int courage;
	//Foreign Key
	private Collection<Competence>competences;
	public Character() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return force;
	}
	public void setForce(int force) {
		this.force = force;
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
	public void setPerception(int perception) {
		this.perception = perception;
	}
	public int getCourage() {
		return courage;
	}
	public void setCourage(int courage) {
		this.courage = courage;
	}
	public Collection<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(Collection<Competence> competences) {
		this.competences = competences;
	}
	
	
	
}
