package personnages;

public class Druide {
	private String nom;
	private int force;
	private int quantitePotion; 
    private int forcePotion; 
    private Chaudron chaudron;
    
    
    public Druide(String nom, int force) {
        this.nom = nom;
        this.force = force;
        this.chaudron = new Chaudron();
    }
    
	public String getNom() {
		return nom;
		}
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	private String prendreParole() {
	return "Le druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
        this.quantitePotion = quantite;
        this.forcePotion = forcePotion;

        remplirChaudron(quantite, forcePotion);

        parler("J’ai concocté " + quantite + " doses de potion magique. "
                + "Elle a une force de " + forcePotion + ".");
	}
		
        public void remplirChaudron(int quantite, int forcePotion) {
            if (chaudron != null) {
                chaudron.setQuantite(quantite);
                chaudron.setForcePotion(forcePotion);
            }
            this.quantitePotion = quantite;
            this.forcePotion = forcePotion;
        }
        
        public void booster(Gaulois gaulois) {
            if (chaudron.resterPotion()) {
                String nomGaulois = gaulois.getNom();

                if (nomGaulois.equals("Obélix")) {
                    parler("Non, " + nomGaulois + " ! Non ! Et tu le sais très bien !");
                } else {
                    int forcePotion = chaudron.prendreLouche();
                    gaulois.boirePotion(forcePotion);
                    parler("Tiens, " + nomGaulois + ", un peu de potion magique !");
                }
            } else {
                parler("Désolé " + gaulois.getNom() + ", il n’y a plus une seule goutte de potion.");
            }
        }
}
