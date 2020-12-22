package com.sdzee.Dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.sdzee.beans.Competence;
@Stateless
public class CompetenceDao {
	

	//Requette
	private static final String SelectAll="SELECT * from Competence";
	private static final String Select ="SELECT * from Competence where Nom =:nom";
	//Param
	private static final String NOM = "nom";
	//Entity manager
	@PersistenceUnit( unitName = "bdd_sdzee_PU" )
    private EntityManagerFactory emf;
	
	public void CreateCompetence(com.sdzee.beans.Competence ca)
	{
		EntityManager em = emf.createEntityManager();
		em.persist(ca);
	}
	public Collection<Competence> FindAllCompetence()
	{
		EntityManager em = emf.createEntityManager();
		Query query =em.createQuery(SelectAll);
		List<com.sdzee.beans.Competence> listChara = (List<Competence>)query.getResultList();
		return listChara;
	}
	//Find Competence by their name
	public Collection<Competence> FindCompetence(String Competence)
	{
		EntityManager em = emf.createEntityManager();
		Query query =em.createQuery(Select);
		query.setParameter(NOM, Competence);
		List<com.sdzee.beans.Competence> listChara = query.getResultList();
		return listChara;
		
	}

}
