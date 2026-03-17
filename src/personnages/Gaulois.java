package personnages;

import village_gaulois.*;

public class Gaulois {
	private String nom;
	private int force;
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
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		int forceCoup = force * effetPotion;
		romain.recevoirCoup(forceCoup / 3);
		if(effetPotion > 1)
		{
			effetPotion -= 1;
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
		if(chef)
		{
			parler("Bonjour, je m'appelle " + getNom() + ". Je suis le chef du village : " + village.getNom());
		}
		else if(village != null)
		{
			parler("Bonjour, je m'appelle " + getNom() + ". J'habite le village : " + village.getNom());
		}
		else
		{
			parler("Bonjour, je m'appelle " + getNom() + ". Je voyage de villages en villages");
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
