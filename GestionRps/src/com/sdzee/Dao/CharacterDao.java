package com.sdzee.Dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.sdzee.beans.Characterc;
import com.sdzee.beans.Utilisateur;
@Stateless
public class CharacterDao {

	//Requette
	private static final String SelectAll="SELECT * from CHARACTER";
	private static final String Select ="SELECT * from CHARACTER where Nom =:nom";
	private static final String SelectByEdit ="SELECT * from CHARACTER where CHARAID = :CHARAID";
	//Param
	private static final String NOM = "nom";
	private static final String CHARAID = "CHARAID";
	
	//Entity manager
	@PersistenceUnit( unitName = "bdd_sdzee_PU" )
    private EntityManagerFactory emf;
	
	public void CreateCharacter(com.sdzee.beans.Characterc ca)
	{
		
		EntityManager em = emf.createEntityManager();
		
		em.persist(ca);
		em.flush();
		
	}
	public Collection<Characterc> FindAllCharacter()
	{
		EntityManager em = emf.createEntityManager();
		Query query =em.createQuery(SelectAll);
		List<com.sdzee.beans.Characterc> listChara = (List<Characterc>)query.getResultList();
		return listChara;
	}
	//Find Character by their name
	public Collection<Characterc> FindCharacter(String character)
	{
		EntityManager em = emf.createEntityManager();
		Query query =em.createQuery(Select);
		query.setParameter(NOM, character);
		List<com.sdzee.beans.Characterc> listChara = query.getResultList();
		return listChara;
		
	}
	public Collection<Characterc> FindCharacterById(int id)
	{
		EntityManager em = emf.createEntityManager();
		Query query =em.createQuery(Select);
		query.setParameter(CHARAID, id);
		List<com.sdzee.beans.Characterc> listChara = query.getResultList();
		return listChara;
		
	}
	
}
