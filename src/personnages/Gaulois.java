package personnages;
import objets.*;
import villagegaulois.Musee;



public class Gaulois {
private String nom;
private int effetPotion = 1;
private Village village;
private int force;
private int nbtrophees;
private Equipement[] trophees = new Equipement[100];
//private int force;


public void setVillage(Village village) 
{
	this.village = village ;
}

public Gaulois(String nom, int force) {
	this.nom = nom;
	this.force = force;
}


public void sePresenter() {
    if (village == null) {
        parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
        
    } else if (village.getChef() == this) {
        parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du " + village.getNom() + ".");
        
    } else {
        parler("Bonjour, je m'appelle " + nom + ". J'habite le " + village.getNom() + ".");
    }
}

public String getNom() {
return nom;
}
public void parler(String texte) {
System.out.println(prendreParole() + "\"" + texte + "\"");
}


private String prendreParole() {
	return "Le gaulois " + nom + " : ";
}


public void frapper(Romain romain) {
	System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
	Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
	for (int i = 0; trophee != null && i < trophee.length; i++,nbtrophees++) {
		this.trophees[nbtrophees] = trophee[i];
	}
}


//public void frapper(Romain romain) {
//    int forceCoup = (force * effetPotion) / 3;
//    System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom() + ".");
//    romain.recevoirCoup(forceCoup);
    
//    if (effetPotion > 1) {
//        effetPotion--;
//    }
//}

public void boirePotion(int forcePotion) {
    this.effetPotion = forcePotion; 
    parler("Merci Druide, je sens ma force décuplée !");
}


public void faireUneDonnation(Musee musee) {
    if (nbtrophees > 0) {
        System.out.println("Le gaulois " + nom + " : « Je donne au musee tous mes trophees :");
        
        // On parcourt le tableau des équipements du gaulois (souvent nommé 'trophees' dans cet exo)
        for (int i = 0; i < nbtrophees; i++) {
            Equipement e = trophees[i];
            
            // On transfère l'équipement au musée
            musee.donnerTrophees(this, e);
            
            // On affiche l'équipement donné
            System.out.println("- " + e); // Suppose que Equipement a une méthode toString()
            
            // On retire l'équipement de l'inventaire du Gaulois (optionnel mais logique)
            trophees[i] = null;
        }
        
        // On remet le compteur du gaulois à 0 car il a tout donné
        nbtrophees = 0;
        
        System.out.println("»"); // Fin de la citation
    }
}


@Override
public String toString() {
	return "Gaulois [nom = " + nom + ",force = " + force + ", effetPotion =" + effetPotion + "]" ;
	
	
}
public static void main(String[] args) {
	Gaulois asterix = new Gaulois("Astérix", 8);
	Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
    System.out.println(asterix);
    Village village = new Village("Village des Irréductibles", abraracourcix,30);
    village.ajouterVillageois(asterix);
    asterix.sePresenter();
}


}