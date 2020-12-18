package com.sdzee.servlets;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.sdzee.Dao.UtilisateurDao;
import com.sdzee.beans.Utilisateur;

public class ConnexionForm extends HttpServlet {
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD ="password";
	
	Map<String, String>erreur;
	
	public ConnexionForm() {
	
		// TODO Auto-generated constructor stub
		erreur = new HashMap<String, String>();
	}
	public Utilisateur ConnexionUtilisateur(HttpServletRequest req)
	{
		
		Utilisateur ut = new Utilisateur();
		UtilisateurDao utD = new UtilisateurDao();
		String login = req.getParameter(CHAMP_LOGIN);
		String password = req.getParameter(CHAMP_PASSWORD);
		try {
			ValidationLogin(login);
			ut.setLogin(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erreur.put(CHAMP_LOGIN, login);
			e.printStackTrace();
		}
		try {
			ValidationPassword(password);
			ut.setLogin(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erreur.put(CHAMP_PASSWORD,password );
			e.printStackTrace();
		}
		return utD.findUtilisateur(ut);
		
		
		
	}
	
	private void ValidationPassword(String password2)throws Exception {
		// TODO Auto-generated method stub
		if((password2.length() <= 0) && (password2.length() > 20))
		{
			throw new Exception("Le mot de passe ne reponds pas � la demande");
		}
	}
	private void ValidationLogin(String login2)throws Exception {
		// TODO Auto-generated method stub
		if((login2.length() <= 0) && (login2.length() > 20))
		{
			 throw new Exception("le login ne repond pas � la demande");
		}
	}
}
