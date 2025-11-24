package personnages;

public class Chaudron {
	private int quantite;
	private int forcePotion;
	
	public boolean restePotion() {
		return quantite > 0;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setForcePotion(int forcePotion) {
		this.forcePotion = forcePotion;
	}
	
	public void remplirChaudron(int quantite, int forcePotion) {
        this.quantite = quantite;
        this.forcePotion = forcePotion;
        
        System.out.println("→ Le chaudron contient désormais " + quantite
            + " doses de potion magique de force " + forcePotion + ".");
    }
	
	public boolean resterPotion() {
        return quantite > 0;
    }

    public int prendreLouche() {
        if (quantite > 0) {
            quantite--;
            return forcePotion;
        } else {
            return 0;
        }
    }
	
}
