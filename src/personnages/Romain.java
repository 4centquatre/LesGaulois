package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
		assert isInvariantVerified() : "La force doit être positive !";
	}
	
	private boolean isInvariantVerified()
	{
		return force >= 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	public void frapper(Gaulois gaulois) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + gaulois.getNom());
		gaulois.recevoirCoup(force);
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculerResistanceEquipement(forceCoup);
		
		if(forceCoup > 0)
		{
			equipementEjecte = ejecterEquipement();
		}
		else
		{
			forceCoup = 0;
		}
		
		if(forceCoup >= force)
		{
			force = 0;
		}
		else
		{
			force -= forceCoup;
		}

		if(force == 0) 
		{
			parler("J'Abandonne !");
		}
		else
		{
			parler("Aïe");
		}
		
		return equipementEjecte;
	}
	
	private int calculerResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) 
				{
					resistanceEquipement += 6;
				} 
				else 
				{
					resistanceEquipement += 3;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + getNom() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) 
		{
			if(equipements[i] != null)
			{
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	public void sEquiper(Equipement equipement) 
	{
		String debut = "Le soldat " + getNom();
		
        switch (nbEquipement) {

            case 2:
                System.out.println(debut + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) 
                {
                	System.out.println(debut + " possède déjà un " + equipement);
                } 
                else 
                {
                	System.out.println(debut + " s'équipe avec un " + equipement);
                	equipements[1] = equipement;
                	nbEquipement++;
                }
                break;
            case 0:
            	System.out.println(debut + " s'équipe avec un " + equipement);
            	equipements[0] = equipement;
            	nbEquipement++;
            	break;
        }
    }
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
