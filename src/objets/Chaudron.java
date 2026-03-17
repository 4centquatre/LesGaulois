package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public Chaudron() {
		this.quantitePotion = 0;
		this.forcePotion = 0;
	}
	
	public void remplirChaudron(int quantite, int forcePotion)
	{
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public boolean resterPotion()
	{
		if(quantitePotion == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public int prendreLouche()
	{
		if(quantitePotion > 1)
		{
			quantitePotion -= 1;
		}
		else
		{
			forcePotion = 0;
		}
		return forcePotion;
	}
}
