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
import com.sdzee.Dao.UtilisateurDao;
import com.sdzee.beans.Charactercss;
import com.sdzee.beans.Utilisateur;

import ServletJob.DataLaunchDice;
import ServletJob.DiceJob;

/**
 * Servlet implementation class FightServlet
 */
@WebServlet("/FightServlet")
public class FightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/Fight.jsp";
	
	private static final String PARAM_LIST_CHARA="listChara";
	private static final String PARAM_BUTTON_LOAD="load";
	private static final String PARAM_NBCHARA="nbList";
	private static final String PARAM_CHARAFIGHT = "charaFight";
	
	private static final String FIELD_CHARA ="chara";
	private static final String PARAM_BUTTON_DICE = "dice";
	private static final String PARAM_DICE_VALUE = "listVal";
	private static final String PARAM_OBJET_DICE_VAL = "DiceJob";
	private static final String PARAM_NBBAL_DICE = "nbDice";

	
	
	@EJB
	UtilisateurDao utilDao;
	
	@EJB
	CharacterDao chDao;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		createLIstChara(request);
		HttpSession ses = request.getSession();
		if(ses.getAttribute(PARAM_OBJET_DICE_VAL) == null)
		{
			ses.setAttribute(PARAM_OBJET_DICE_VAL, new DataLaunchDice());
		}
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		createLIstChara(request);
		HttpSession ses = request.getSession();
		if(request.getParameter(PARAM_BUTTON_LOAD) != null)
		{
			InitChara(request);
		}
		else if(request.getParameter(PARAM_BUTTON_DICE) != null)
		{
			InitChara(request);
			List<Integer>listVal = DiceJob.RollMultiDice(100, 2);
			request.setAttribute(PARAM_DICE_VALUE, listVal);
			DataLaunchDice dataLaunchDice = (DataLaunchDice) ses.getAttribute(PARAM_OBJET_DICE_VAL);
			dataLaunchDice.AddList(listVal);
			ses.setAttribute(PARAM_OBJET_DICE_VAL, dataLaunchDice);
			request.setAttribute(PARAM_OBJET_DICE_VAL, dataLaunchDice);
			request.setAttribute(PARAM_DICE_VALUE, dataLaunchDice.getListVal());
			request.setAttribute(PARAM_NBBAL_DICE, dataLaunchDice.getListVal().size());
			
			
			
		}
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	private void InitChara(HttpServletRequest request) {
		Charactercss [] charaWhoFight = new Charactercss [2];
		charaWhoFight[0] = chDao.FindCharacterByCharaId(Integer.parseInt(request.getParameter(FIELD_CHARA+1)));
		charaWhoFight[1] = chDao.FindCharacterByCharaId(Integer.parseInt(request.getParameter(FIELD_CHARA+2)));
		request.setAttribute(PARAM_CHARAFIGHT, charaWhoFight);
	}
	//Create list of character 
	private void createLIstChara(HttpServletRequest request) {
		HttpSession ses = request.getSession();
		Utilisateur utili = utilDao.findLogin((String) ses.getAttribute("login"));
		
		List<Charactercss>chaList =   (List<Charactercss>) chDao.FindCharacterByUtilisateurId(utili.getIdUtilisateur());
		request.setAttribute(PARAM_LIST_CHARA, chaList);
		request.setAttribute(PARAM_NBCHARA, chaList.size());
	}

}
