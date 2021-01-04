package com.sdzee.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.sdzee.beans.Charactercss;

import com.sdzee.beans.Utilisateur;
@Stateless
public class CharacterDao {

	//Requette
	private static final String SelectAll="SELECT * from CHARACTERC";
	private static final String Select ="SELECT u from CHARACTERC u where u.nom =:nom";
	private static final String SelectByEdit ="SELECT u FROM Charactercss u WHERE u.idUtilisateur = :CHARAID";
	//Param
	private static final String NOM = "nom";
	private static final String CHARAID = "CHARAID";
	
	//Entity manager
	@PersistenceUnit( unitName = "bdd_sdzee_PU" )
    private EntityManagerFactory emf;
	
	public void CreateCharacter(com.sdzee.beans.Charactercss ca)
	{
		
		EntityManager em = emf.createEntityManager();
		
		em.persist(ca);
		em.flush();
		
	}
	public Collection<Charactercss> FindAllCharacter()
	{
		EntityManager em = emf.createEntityManager();
		List<com.sdzee.beans.Charactercss> listChara = null;
		try {
			Query query =em.createQuery(SelectAll);
			listChara = (List<Charactercss>)query.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			listChara = new ArrayList<Charactercss>();
		}
		return listChara;
	}
	//Find Character by their name
	public Collection<Charactercss> FindCharacter(String character)
	{
		
		EntityManager em = emf.createEntityManager();
		List<com.sdzee.beans.Charactercss> listChara = null;
		try {
			Query query =em.createQuery(SelectAll);
			query.setParameter(NOM, character);
			listChara = (List<Charactercss>)query.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			listChara = new ArrayList<Charactercss>();
		}
		return listChara;
		
	}
	public Collection<Charactercss> FindCharacterById(int id)
	{
		
		EntityManager em = emf.createEntityManager();
		List<com.sdzee.beans.Charactercss> listChara = null;
		Query query =em.createQuery(SelectByEdit);
		try {
			
			query.setParameter(CHARAID,((Integer) id));
			listChara = (List<Charactercss>)query.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			listChara = new ArrayList<Charactercss>();
		}
		return listChara;
		
	}
		
		
	
	
}
