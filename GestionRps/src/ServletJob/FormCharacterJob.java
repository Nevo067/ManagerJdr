package ServletJob;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.beans.Charactercss;

public class FormCharacterJob {
	private static final String CharaPri = "CharaPri";
	private static final String Chara = "chara";
	private static final String PARAM_IDCHARA = "idChara";
	public Charactercss Createchara(HttpServletRequest req)
	{
		String [] charaPri = req.getParameterValues(CharaPri);
		String [] chara = req.getParameterValues(Chara);
		
		Charactercss characters = new Charactercss();
		
		
		
		characters.setNom(charaPri[0]);
		characters.setMana(charaPri[1]);
		characters.setStress(charaPri[2]);
		//You musn't be a null
		characters.setForce( chara[0].isEmpty() ? Integer.parseInt(chara[0]) : 0);
		characters.setConstitution( chara[1].isEmpty() ? Integer.parseInt(chara[1]) : 0);
		characters.setDexterite(chara[2].isEmpty() ? Integer.parseInt(chara[2]) : 0);
		characters.setPerception(chara[3].isEmpty() ? Integer.parseInt(chara[3]) : 0);
		characters.setCourage(chara[4].isEmpty() ? Integer.parseInt(chara[4]) : 0);
		
		return characters;
		
		
		
	}
	public Charactercss CreateCharaById(HttpServletRequest req)
	{
		Charactercss ca =Createchara(req);
		ca.setIdCharacterc(Integer.parseInt(req.getParameter(PARAM_IDCHARA)));
		return ca;
	}
}
