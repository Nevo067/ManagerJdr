package ServletJob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.Utilisateur;



public class FormUtilisateurJob {
	private static final String FIELD_LOGIN = "login";
	private static final String FIELD_MDP = "mdp";
	
	public Utilisateur CreateUtil(HttpServletRequest req)
	{
		HttpSession ses = req.getSession();
		
		//init Utilisateur
		Utilisateur util = new Utilisateur();
		
		String login = req.getParameter(FIELD_LOGIN);
		String mdp = req.getParameter(FIELD_MDP);
		if(login != null)
		{
			util.setLogin(login);
		}
		else
		{
			util.setLogin((String) ses.getAttribute(FIELD_LOGIN));
		}
		
		if(mdp != null)
		{
			util.setPassword(mdp);
		}
		else
		{
			util.setPassword((String) ses.getAttribute(FIELD_MDP));
		}
		return util;
		
	}
	
}
