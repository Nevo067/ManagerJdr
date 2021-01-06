package com.sdzee.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.Dao.UtilisateurDao;
import com.sdzee.beans.Charactercss;
import com.sdzee.beans.Utilisateur;

import ServletJob.FormCharacterJob;
import ServletJob.FormUtilisateurJob;

/**
 * Servlet implementation class UtilisateurPageServlet
 */
@WebServlet("/UtilisateurPageServlet")
public class UtilisateurPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE = "/WEB-INF/UtilisateurPage.jsp";
    private static final String FIELD_IS_CHANGED= "isChanged";
    
    @EJB
    UtilisateurDao utilDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurPageServlet() {
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
		FormUtilisateurJob form = new FormUtilisateurJob();
		Utilisateur ca = form.CreateUtil(request);
		try {
			utilDao.Update(ca);
			request.setAttribute(FIELD_IS_CHANGED, "true");
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
		
	}

}
