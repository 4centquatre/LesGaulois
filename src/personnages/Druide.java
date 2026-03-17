package personnages;

import personnages.*;
import objets.*;

public class Druide {
	private String nom;
	private int force;
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion, Chaudron chaudron)
	{
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
	}
	
	public void booster(Gaulois gaulois, Chaudron chaudron)
	{
		boolean contientPotion;
		String nomGaulois;
		
		contientPotion = chaudron.resterPotion();
		nomGaulois = gaulois.getNom();
		
		if(contientPotion)
		{
			if(nomGaulois == "Obelix")
			{
				parler("Non, " + nomGaulois + " Non !... Et tu le sais très bien !");
			}
			else
			{
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				
				parler("Tiens " + nomGaulois + " un peu de potion magique.");
			}
		}
		else
		{
			parler("Désolé " + nomGaulois + " il n'y a plus une seule goutte de potion.");
		}
	}

	public String getNom() {
		return nom;
	}
}
