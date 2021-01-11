package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
import com.sdzee.beans.Charactercss;
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
        * Name of button that change the form
        */
       private static final String BUTTON_PARAM_FORM = "formAdd";
       private static final String BUTTON_PARAM_EDIT = "formEdit";
       private static final String BUTTON_PARAM_DELETE = "formDelete";
       
       //Character that have to load on the edit page
       private static final String CHARA_EDIT ="charaEdit";
       private static final String CHARA_BOOL ="charaIsLoad";
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
		createListCharacter(ses, request);
		if(ses.getAttribute(SES_PARAM_FORM)== null)
		{
			ses.setAttribute(SES_PARAM_FORM,0);
			
		}
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		
		//Button of ListCharacter
		Utilisateur util = utilDao.findLogin((String) ses.getAttribute("login"));
		List<Charactercss>chaList =   (List<Charactercss>) chDao.FindCharacterByUtilisateurId(util.getIdUtilisateur());
		
		for (Charactercss charactercss : chaList) {
			String buttonName = "btn"+charactercss.getIdCharacterc();
			if(request.getParameter(buttonName) != null)
			{
				request.setAttribute(CHARA_EDIT, charactercss);
			}
		}
		
		
		//Button of FormCharacter
		if(request.getParameter("envoie") != null)
		{
			ses.setAttribute(SES_PARAM_FORM,0);
			// TODO Auto-generated method stub
			FormCharacterJob formCharacterJob = new FormCharacterJob();
			Charactercss ca = formCharacterJob.Createchara(request);
			Utilisateur utili = utilDao.findLogin((String) ses.getAttribute("login"));
			System.out.println(utili.toString());
			ca.setIdUtilisateur(utili.getIdUtilisateur());
			chDao.CreateCharacter(ca);
			createListCharacter(ses, request);
		}
		else if(request.getParameter("edit") != null)
		{
			
			FormCharacterJob formCharacterJob = new FormCharacterJob();
			Charactercss ca = formCharacterJob.CreateCharaById(request);
			Utilisateur utili = utilDao.findLogin((String) ses.getAttribute("login"));
			System.out.println(utili.toString());
			ca.setIdUtilisateur(utili.getIdUtilisateur());
			chDao.UpdateCharacter(ca);
			createListCharacter(ses, request);
			
		}
		else if(request.getParameter("supp")!=null)
		{
			FormCharacterJob formCharacterJob = new FormCharacterJob();
			Charactercss ca = formCharacterJob.CreateCharaById(request);
			Utilisateur utili = utilDao.findLogin((String) ses.getAttribute("login"));
			System.out.println(utili.toString());
			ca.setIdUtilisateur(utili.getIdUtilisateur());
			chDao.DeleteCharecter(ca);
			createListCharacter(ses, request);
		}
		
		if(request.getParameter(BUTTON_PARAM_FORM) != null)
		{
			ses.setAttribute(SES_PARAM_FORM,0);
		}
		else if(request.getParameter(BUTTON_PARAM_EDIT) != null)
		{
			createListCharacter(ses, request);
			
		}
		else if(request.getParameter(BUTTON_PARAM_DELETE) != null)
		{
			ses.setAttribute(SES_PARAM_FORM,2);
		}
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

	private void createListCharacter(HttpSession ses,HttpServletRequest req) {
		ses.setAttribute(SES_PARAM_FORM,1);
		Utilisateur utili = utilDao.findLogin((String) ses.getAttribute("login"));
		List<Charactercss>chaList =   (List<Charactercss>) chDao.FindCharacterByUtilisateurId(utili.getIdUtilisateur());
		System.out.println(chaList.size());
		
		List<String>nomList = new Vector<String>();
		for (Charactercss ca : chaList) {
			nomList.add(ca.getNom());
		}
		List<Integer>idList = new Vector<Integer>();
		for (Charactercss intes : chaList) {
			idList.add(intes.getIdCharacterc());
		}
		
		ses.setAttribute("listChara", nomList);
		ses.setAttribute("listId", idList);
		ses.setAttribute("listCharas", chaList);
		req.setAttribute("list", chaList);
		req.setAttribute("nbList", nomList.size());
	}

}
