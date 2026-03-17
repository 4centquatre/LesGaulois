package village_gaulois;

import personnages.*;
import objets.*;

public class Village {
	private String nom;
	private int nbVillageois;
	private Gaulois chef;
	private Gaulois[] villageois;
	private int nbVillageoisMax;
	
	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
		this.nom = nom;
		this.nbVillageois = 0;
		this.chef = chef;
		this.nbVillageoisMax = nbVillageoisMax;
		this.villageois = new Gaulois[nbVillageoisMax];
		chef.setVillage(this);
	}

	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef()
	{
		return chef;
	}
	
	@Override
	public String toString() {
		return "Village [nom=" + nom + "]";
	}

	public void ajouterVillageois(Gaulois gaulois)
	{
		gaulois.setVillage(this);
		this.villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverVillageois(int numVillageois)
	{
		if(this.villageois[numVillageois-1] == null)
		{
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
		else
		{
			return this.villageois[numVillageois-1];
		}
	}
	
	public void afficherVillage()
	{
		System.out.println("Dans le village " + getNom() + " du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
		
		for(int i = 0; i < nbVillageois; i++)
		{
			System.out.println(" - " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args)
	{
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois doublepolemix = new Gaulois("Doublepolémix", 4);
		
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		
		village.trouverVillageois(30);
		village.ajouterVillageois(asterix);
		village.ajouterVillageois(obelix);
		village.afficherVillage();
		
		abraracourcix.sePresenter();
		asterix.sePresenter();
		obelix.sePresenter();
		doublepolemix.sePresenter();
	}
}
