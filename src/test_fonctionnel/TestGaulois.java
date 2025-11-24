package test_fonctionnel;

import personnages.Chaudron;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {

	public static void main(String[] args) {
		Romain brutus = new Romain("Brutus", 14);
        Chaudron chaudron = new Chaudron();
        Druide panoramix = new Druide("Panoramix", 2, chaudron);
        Gaulois asterix = new Gaulois("Astérix", 8);
        Gaulois obelix = new Gaulois("Obélix", 25);

        panoramix.fabriquerPotion(4, 3);
        panoramix.booster(obelix);
        panoramix.booster(asterix);

        for (int i = 1; i <= 3; i++) {
            asterix.frapper(brutus);
        }
	}

}
