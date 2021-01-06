package com.sdzee.servlets;

import java.io.IOException;
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
import com.sdzee.Dao.UtilisateurDao;
import com.sdzee.beans.Charactercss;
import com.sdzee.beans.Utilisateur;

/**
 * Servlet implementation class ListCharacterServlet
 */
@WebServlet("/ListCharacterServlet")
public class ListCharacterServlet extends HttpServlet {
	private static final String Vue ="/WEB-INF/AffichageCharacter.jsp";
	private static final String FIELD_NOMLIST="nomList";
	private static final String FIELD_IDLIST="idList";
	private static final String FIELD_NUMBER ="numberOfList";
	private static final String FIElD_CHARA ="chara";
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CharacterDao chDao;
	
	@EJB
	UtilisateurDao utilDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCharacterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession();
		createListCharacter(request, ses);
		this.getServletContext().getRequestDispatcher(Vue).forward(request, response);

		
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession();
		
		
		doGet(request, response);
	}
	/**
	 * @param request
	 * @param ses
	 */
	private void createListCharacter(HttpServletRequest request, HttpSession ses) {
		Utilisateur utili = utilDao.findLogin((String) ses.getAttribute("login"));
		List<Charactercss>chaList =   (List<Charactercss>) chDao.FindCharacterById(utili.getIdUtilisateur());
		
		List<String>nomList	= new Vector<String>();
		List<Integer>idList = new Vector<Integer>();
		int numberOfCharacter = chaList.size();
		for (Charactercss cha : chaList) {
			nomList.add(cha.getNom());
			idList.add(cha.getIdCharacterc());
			
		}
		request.setAttribute(FIELD_NOMLIST, nomList);
		request.setAttribute(FIELD_IDLIST, idList);
		request.setAttribute(FIElD_CHARA, chaList);
		request.setAttribute(FIELD_NUMBER, numberOfCharacter);
	}
}
