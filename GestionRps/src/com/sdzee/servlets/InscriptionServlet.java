package com.sdzee.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.Dao.UtilisateurDao;
import com.sdzee.beans.Utilisateur;

public class InscriptionServlet extends HttpServlet {
	
	public static final String Vue = "/WEB-INF/Incription.jsp";  
	private static final String LOGIN ="login";
	private static final String PASSWORD = "password";
	
	@EJB
	UtilisateurDao utD ;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(Vue).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String>erreurs = new HashMap<String, String>();
		String resultat = "TTT";
		
		InscriptionForm form = new InscriptionForm();
		
		Utilisateur ut=form.InscriptionUtilisateur(req,utD);
		// TODO Auto-generated method stub
		/*
		String login = req.getParameter(LOGIN);
		String password = req.getParameter(PASSWORD);
		//Erreur
		try {
			ValidationLogin(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erreurs.put(LOGIN, e.getMessage());
		}
		try {
			ValidationPassword(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			erreurs.put(PASSWORD, password);
		}
		if(erreurs.isEmpty())
		{
			resultat = "Inscription";
		}
		else
		{
			resultat = "erreur"+erreurs.size();
		}
		*/
		//super.doPost(req, resp);
		req.setAttribute("resultat", resultat);
		req.setAttribute("login", ut.getLogin());
		req.setAttribute("password", ut.getPassword());
		this.getServletContext().getRequestDispatcher(Vue).forward(req, resp);
	}
	private void ValidationPassword(String password2)throws Exception {
		// TODO Auto-generated method stub
		if((password2.length() <= 0) && (password2.length() > 20))
		{
			throw new Exception("Le mot de passe ne reponds pas à la demande");
		}
	}
	private void ValidationLogin(String login2)throws Exception {
		// TODO Auto-generated method stub
		if((login2.length() <= 0) && (login2.length() > 20))
		{
			 throw new Exception("le login ne repond pas à la demande");
		}
	}
}
