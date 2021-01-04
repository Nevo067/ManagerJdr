package com.sdzee.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.sdzee.beans.Utilisateur;


@Stateless
public class UtilisateurDao {
	
	    private static final String SELECTQUERY = "SELECT u FROM Utilisateur u WHERE u.login= :login";
	    private static final String SELECTUTIL = "SELECT u FROM Utilisateur u Where u.login = :login "
	    		+ "AND u.password = :password";
	    
	    private static final String PARAM_LOGIN = "login";
	    private static final String PARAM_PASS  = "password";

	    // Injection du manager, qui s'occupe de la connexion avec la BDD
	    @PersistenceUnit( unitName = "bdd_sdzee_PU" )
	    private EntityManagerFactory emf;

	    // Enregistrement d'un nouvel utilisateur
	    public void creer( Utilisateur utilisateur ){
	    		EntityManager em = emf.createEntityManager();
	    		
	            em.persist( utilisateur );
	            em.flush();
	            
	            
	            
	    }
	    public Utilisateur findLogin(String login)
	    {
	    	EntityManager em = emf.createEntityManager();
	    	Query requette = em.createQuery(SELECTQUERY);
	    	requette.setParameter(PARAM_LOGIN, login);
	    	Utilisateur ut = null;
	    	try {
	    		ut = (Utilisateur) requette.getSingleResult();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
	    	return ut;
	    }
	    public Utilisateur findUtilisateur(Utilisateur ut) throws NoResultException
	    {
	    	EntityManager em = emf.createEntityManager();
	    	System.out.println((em != null) +"test");
	    	
	    	Query requette = em.createQuery(SELECTUTIL);
	    	requette.setParameter(PARAM_LOGIN, ut.getLogin());
	    	requette.setParameter(PARAM_PASS, ut.getPassword());
	    	Utilisateur uts =null;
	    	try {
	    		 uts = (Utilisateur) requette.getSingleResult();
			} 
	    	catch (Exception E ) {
				// TODO: handle exception
			}
	    	
	    	
	    	return uts;
	    }

	    
	
}
