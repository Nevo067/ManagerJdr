package ServletJob;

import javax.servlet.http.HttpServletRequest;

import com.sdzee.beans.Characterc;

public class FormCharacterJob {
	private static final String CharaPri = "CharaPri";
	private static final String Chara = "chara";
	public Characterc Createchara(HttpServletRequest req)
	{
		String [] charaPri = req.getParameterValues(CharaPri);
		String [] chara = req.getParameterValues(Chara);
		
		Characterc characters = new Characterc();
		
		characters.setNom(charaPri[0]);
		characters.setMana(charaPri[1]);
		characters.setStress(charaPri[2]);
		
		characters.setForce(Integer.parseInt(chara[0]));
		characters.setConstitution(Integer.parseInt(chara[1]));
		characters.setDexterite(Integer.parseInt(chara[2]));
		characters.setPerception(Integer.parseInt(chara[3]));
		characters.setCourage(Integer.parseInt(chara[4]));
		
		return characters;
		
		
		
	}
}
