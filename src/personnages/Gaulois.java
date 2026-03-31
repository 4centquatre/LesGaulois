package personnages;

import village_gaulois.*;
import objets.Equipement;

public class Gaulois {
	private String nom;
//	private int force;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion;
	private Village village;
	private Boolean chef = false;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = 1;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village)
	{
		this.village = village;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() 
	{
		return "Le gaulois " + getNom() + " : ";
	}
	
//	@Override
//	public String toString() {
//		return nom;
//	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		int forceCoup = force * effetPotion;
//		romain.recevoirCoup(forceCoup / 3);
//		if(effetPotion > 1)
//		{
//			effetPotion -= 1;
//		}
//	}
	
	public void frapper(Romain romain) 
	{
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRomain = romain.recevoirCoup((force / 3) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) 
		{
			effetPotion = 1;
		}
		for (int i = 0; tropheesRomain != null && i < tropheesRomain.length; i++, nbTrophees++) 
		{
			this.trophees[nbTrophees] = tropheesRomain[i];
		}
	}
	
	public void recevoirCoup(int forceCoup) {
		force = force - forceCoup;
		if(force < 1)
		{
			force = 0;
			parler("J'abandonne ! ");
		}
		else
		{
			parler("Aie !");
		}
	}
	
	public void boirePotion(int forcePotion)
	{
		effetPotion = forcePotion;
	}
	
	public void sePresenter()
	{
		String debut = "Bonjour, je m'appelle " + getNom();
		
		if(Boolean.TRUE.equals(chef))
		{
			parler(debut + ". Je suis le chef du village : " + village.getNom());
		}
		else if(village != null)
		{
			parler(debut + ". J'habite le village : " + village.getNom());
		}
		else
		{
			parler(debut + ". Je voyage de villages en villages");
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 16);
		Romain romain = new Romain("Minus", 10);
		
		System.out.println(asterix);
		asterix.frapper(romain);
		obelix.frapper(romain);
	}
}
