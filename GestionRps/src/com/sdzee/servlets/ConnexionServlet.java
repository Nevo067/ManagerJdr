package com.sdzee.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.Dao.UtilisateurDao;
import com.sdzee.beans.Utilisateur;

public class ConnexionServlet extends HttpServlet {

	private static final String Vue ="/WEB-INF/Connexion.jsp";
	private static final String login ="login";
	private static final String password ="password";
	@EJB
	UtilisateurDao utDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(Vue).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession ses = req.getSession();
		 ses.setAttribute("estConnecter", true);
		 ConnexionForm con = new ConnexionForm();
		 
		 Utilisateur us =con.ConnexionUtilisateur(req,utDao);
		 if(us != null)
		 {
			 req.setAttribute("erreur", con.erreur.size());
			 if(con.erreur.size()==0)
			 {
				 ses.setAttribute("login", us.getLogin());
				 ses.setAttribute("password", us.getPassword());
				 ses.setAttribute("isConnected", true);
			 }
		 }
		 
		 
		 this.getServletContext().getRequestDispatcher(Vue).forward(req, resp);
		 
		 
	}
}
