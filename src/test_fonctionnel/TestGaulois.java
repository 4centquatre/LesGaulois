package test_fonctionnel;

import personnages.*;
import objets.*;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 16);
		Romain minus = new Romain("Minus", 6);
		Romain brutus = new Romain("Brutus", 14);
		Druide panoramix = new Druide("Panoramix", 2);
		Chaudron chaudron = new Chaudron();
		
		panoramix.fabriquerPotion(4,3, chaudron);
		
		panoramix.booster(obelix, chaudron);
		panoramix.booster(asterix, chaudron);
			
		for(int i = 0; i < 3; i++)
		{
			asterix.frapper(brutus);
		}
	}
}
