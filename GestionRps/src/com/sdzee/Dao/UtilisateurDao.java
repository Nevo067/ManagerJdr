package com.sdzee.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sdzee.beans.Utilisateur;

@Stateless
public class UtilisateurDao {
	

	
	
	    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
	    private static final String PARAM_EMAIL           = "email";

	    // Injection du manager, qui s'occupe de la connexion avec la BDD
	    @PersistenceContext( unitName = "bdd_sdzee_PU" )
	    private EntityManager       em;

	    // Enregistrement d'un nouvel utilisateur
	    public void creer( Utilisateur utilisateur ){
	            em.persist( utilisateur );
	    }

	    
	
}
