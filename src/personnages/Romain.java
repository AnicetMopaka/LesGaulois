package personnages;
import objets.Equipement;

public class Romain {
private String nom;
private int force;
private Equipement[] equipements ;
private int nbEquipement = 0;


public Romain(String nom, int force) {
	this.nom = nom;
	this.force = force;
	this.equipements = new Equipement[2];
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

public int getForce()
{
	return force;
}

public Equipement[] recevoirCoup(int forceCoup) {
	Equipement[] equipementEjecte = null;
	forceCoup = calculResistanceEquipement(forceCoup);
	force -= forceCoup;
	if (force >= 0) {
		parler("Aïe");
	}
	else {	
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
	}
	return equipementEjecte;
}



private int calculResistanceEquipement(int forceCoup) {
	String texte;
	texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
	int resistanceEquipement = 0;
	if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;i++) {
			if (equipements[i] != null) {
					
				if (equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
			} 	else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
					}
			}
		}
		texte += resistanceEquipement + "!";
	}
	parler(texte);
	forceCoup -= resistanceEquipement;
    if (forceCoup < 0) forceCoup = 0;
	return forceCoup;
}



private Equipement[] ejecterEquipement() {
	Equipement[] equipementEjecte = new Equipement[nbEquipement];
	System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
	int nbEquipementEjecte = 0;
	for (int i = 0; i < nbEquipement; i++) {
		if (equipements[i] != null) {
			equipementEjecte[nbEquipementEjecte] = equipements[i];
			nbEquipementEjecte++;
			equipements[i] = null;
		}
}
return equipementEjecte;
}


//public void recevoirCoup(int forceCoup)
//{
//	assert forceCoup > 0 ;
//	int forceInit = force ;
//	force -= forceCoup;

//    if (force < 1) {
//        force = 0;
//        parler("J'abandonne !");
//    } else {
//       parler("Aïe");
//    }
//    assert force < forceInit ;
//}


private void afficherMessage(String message, Equipement equipement) {
    if (equipement != null)
        System.out.println("Le soldat " + nom + " " + message + " " + equipement + ".");
    else
        System.out.println("Le soldat " + nom + " " + message);
}

public void sEquiper(Equipement equipement) {
	switch (nbEquipement) {
    case 0:
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        afficherMessage("s'équipe avec un", equipement);
        break;

    case 1:
        if (equipements[0] == equipement) {
            afficherMessage("possède déjà un", equipement);
        } else {
            equipements[nbEquipement] = equipement;
            nbEquipement++;
            afficherMessage("s'équipe avec un", equipement);
        }
        break;

    case 2:
        afficherMessage("est déjà bien protégé !", null);
        break;
} 
}

private boolean isInvariantVerified(Romain romain)
{
	return romain.force > 0 ;
		
}



public static void main(String[] args) {
	Romain minus = new Romain("Minus",6);

    minus.sEquiper(Equipement.CASQUE);
    minus.sEquiper(Equipement.CASQUE);
    minus.sEquiper(Equipement.BOUCLIER);
    minus.sEquiper(Equipement.CASQUE); 
    minus.recevoirCoup(5);
	
	
	
}

}
