package village_gaulois;

import objets.*;
import personnages.*;

public class Musee 
{
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement)
	{
		Trophee trophee = new Trophee(gaulois, equipement);
		
		trophees[nbTrophee] = trophee;
		nbTrophee++;
	}
	
	public String extraireInstructionsOCaml()
	{
		String chaine = "let musee = [\n";
		for(int i = 0; i < nbTrophee; i++)
		{
			chaine += "     \"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() + "\"";
			if(i != (nbTrophee - 1))
			{
				chaine += ";";
			}
			chaine += "\n";
		}
		chaine +=  "]";
		return chaine;
	}
}
