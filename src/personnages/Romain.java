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
		if(force >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getNom() {
		return nom;
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
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "La force du coup reçu doit être positive !";
		
		int forceAvant = force;
		force = force - forceCoup;
		
		if(force < 1)
		{
			force = 0;
			parler("J'abandonne !");
		}
		else
		{
			parler("Aïe !");
		}
		
		assert forceAvant < force : "La force d'un Romain doit diminué !";
		
		assert isInvariantVerified() : "La force doit être positive !";
	}
	
	public void sEquiper(Equipement equipement) {

        switch (nbEquipement) {

            case 2:
                System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) 
                {
                	System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement);
                } 
                else 
                {
                	System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement);
                	equipements[1] = equipement;
                	nbEquipement++;
                }
                break;
            case 0:
            	System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement);
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
