package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import objets.Equipement;

import village_gaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.fabriquerPotion(5, 3);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		while ((minus.getForce() > 1) && asterix.getForce() <= minus.getForce()) 
		{
			asterix.frapper(minus);
		}
		if(minus.getForce() > 0)
		{
			minus.parler("Alors " + asterix.getNom() + " on fait moins le malin face à mon équipement, Hi ! Hi !");
			obelix.parler(asterix.getNom() + ", tu veux un peu d'aide ?");
			obelix.frapper(minus);
			while ((minus.getForce() > 1) && obelix.getForce() <= minus.getForce()) 
			{
				obelix.frapper(minus);
			}
		}
	
//		milexcus.parler("UN GAU... UN GAUGAU...");
		
//		obelix.frapper(milexcus);
//		while(milexcus.getForce() > 1) 
//		{
//			obelix.frapper(milexcus);
//		}


		Musee musee = new Musee();
		asterix.faireUneDonation(musee);
		System.out.println(musee.extraireInstructionsOCaml());
	}

}
