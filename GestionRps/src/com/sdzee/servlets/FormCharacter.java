package com.sdzee.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.Dao.CharacterDao;
import com.sdzee.Dao.CompetenceDao;
import com.sdzee.Dao.UtilisateurDao;
import com.sdzee.beans.Characterc;

import ServletJob.FormCharacterJob;

/**
 * Servlet implementation class FormCharacter
 */
@WebServlet("/FormCharacter")
public class FormCharacter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static final String VUE ="/WEB-INF/FormCharacter.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    @EJB   
    CharacterDao chDao;
    @EJB
    CompetenceDao compDao;
    @EJB
	UtilisateurDao utilDao;
   
       
    public FormCharacter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// TODO Auto-generated method stub
		FormCharacterJob formCharacterJob = new FormCharacterJob();
		Characterc ca = formCharacterJob.Createchara(request);
		chDao.CreateCharacter(ca);
		
	}

}
