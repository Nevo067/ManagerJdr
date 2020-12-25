package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.Dao.CharacterDao;
import com.sdzee.Dao.CompetenceDao;
import com.sdzee.Dao.UtilisateurDao;
import com.sdzee.beans.Characterc;
import com.sdzee.beans.Utilisateur;

import ServletJob.FormCharacterJob;

/**
 * Servlet implementation class FormCharacter
 */
@WebServlet("/FormCharacter")
public class FormCharacter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static final String VUE ="/WEB-INF/FormCharacter.jsp";
       /**
        * if equals to 0 = insert
        * if equals to 1 = edit
        * if equals to 2 = delete
        */
       private static final String SES_PARAM_FORM = "formEdit";
       
       /*
        * Name of button to change the form
        */
       private static final String BUTTON_PARAM_FORM = "formAdd";
       private static final String BUTTON_PARAM_EDIT = "formEdit";
       private static final String BUTTON_PARAM_DELETE = "formDelete";
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
		HttpSession ses = request.getSession();
		if(ses.getAttribute(SES_PARAM_FORM)== null)
		{
			ses.setAttribute(SES_PARAM_FORM,1);
		}
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		if(request.getParameter("envoie") != null)
		{
			ses.setAttribute(SES_PARAM_FORM,0);
			// TODO Auto-generated method stub
			FormCharacterJob formCharacterJob = new FormCharacterJob();
			Characterc ca = formCharacterJob.Createchara(request);
			Utilisateur utili = utilDao.findLogin((String) ses.getAttribute("login"));
			System.out.println(utili.toString());
			ca.setIdUtilisateur(utili.getIdUtilisateur());
			chDao.CreateCharacter(ca);
		}
		
		if(request.getParameter(BUTTON_PARAM_FORM) != null)
		{
			ses.setAttribute(SES_PARAM_FORM,0);
		}
		else if(request.getParameter(BUTTON_PARAM_EDIT) != null)
		{
			ses.setAttribute(SES_PARAM_FORM,1);
			Utilisateur utili = utilDao.findLogin((String) ses.getAttribute("login"));
			List<Characterc>chaList = (List<Characterc>) chDao.FindCharacterById(utili.getIdUtilisateur());
			
		}
		else if(request.getParameter(BUTTON_PARAM_DELETE) != null)
		{
			ses.setAttribute(SES_PARAM_FORM,2);
		}
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

}
