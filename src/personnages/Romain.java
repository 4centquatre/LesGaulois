package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
	}
	
	public static void main(String[] args) {
		System.out.println("romain");
	}
}
