package objets;
import personnages.Gaulois;

public class Trophee {
    private Gaulois gaulois;
    private Equipement equipement;

    // Constructeur
    public Trophee(Gaulois gaulois, Equipement equipement) {
        this.gaulois = gaulois;
        this.equipement = equipement;
    }

    // Getters
    public Gaulois getGaulois() {
        return gaulois;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public String donnerNom() {
        return gaulois.getNom();
    }
}
