package com.sdzee.Dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	    @PersistenceContext( unitName = "bdd_sdzee_PU" )
	    private EntityManager em;

	    // Enregistrement d'un nouvel utilisateur
	    public void creer( Utilisateur utilisateur ){
	            em.persist( utilisateur );
	    }
	    public Utilisateur findLogin(String login)
	    {
	    	Query requette = em.createQuery(SELECTQUERY);
	    	requette.setParameter(PARAM_LOGIN, login);
	    	Utilisateur ut = (Utilisateur) requette.getSingleResult();
	    	return ut;
	    }
	    public Utilisateur findUtilisateur(Utilisateur ut)
	    {
	    	System.out.println((em != null) +"test");
	    	
	    	Query requette = em.createQuery(SELECTUTIL);
	    	requette.setParameter(PARAM_LOGIN, ut.getLogin());
	    	requette.setParameter(PARAM_PASS, ut.getPassword());
	    	Utilisateur uts = (Utilisateur) requette.getSingleResult();
	    	
	    	return uts;
	    }

	    
	
}
