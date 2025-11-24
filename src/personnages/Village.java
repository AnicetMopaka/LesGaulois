package personnages;

public class Village {
	private String nom ; 
	private int nbVillageois = 0 ;
	private Gaulois chef ;
	public Gaulois[] Villageois ;
	
	
	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
        this.nom = nom;  
        this.chef = chef ;
        this.Villageois = new Gaulois[nbVillageoisMax];
    }
	

	public String getNom() {
		return nom;
		
	}
	public Gaulois getChef() {
        return chef;
    }
	public void ajouterVillageois(Gaulois gaulois) {
        if (nbVillageois < Villageois.length) {
            Villageois[nbVillageois] = gaulois;   
            nbVillageois++;                        
            gaulois.setVillage(this);             
        } else {
            System.out.println("Le village est plein !");
        }
    }
	
	public Gaulois trouverVillageois(int numVillageois) {
		int indice = numVillageois - 1;

	    if (indice >= 0 && indice < nbVillageois) {
	        return Villageois[indice];
	    } else {
	        System.out.println("Il n’y a pas autant d’habitants dans notre village !");
	        return null;
	    }
	}
	private void afficherVillageois() {
		System.out.println("Dans le village des \" " + nom + " \" du chef " + chef.getNom() + " vivent les légendaires : \n");
		if (nbVillageois == 0) {
	        System.out.println("(aucun villageois pour le moment)");
	    } else {
	        for (int i = 0; i < nbVillageois; i++) {
	            System.out.println("- " + Villageois[i].getNom());
	        }
	    }
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix,30);
		village.ajouterVillageois(abraracourcix);
		Gaulois asterix  = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		 System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
		Gaulois obelix  = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		Gaulois doublePolemix  = new Gaulois("DoublePolemix", 4);
		
		asterix.sePresenter();
		obelix.sePresenter();
		abraracourcix.sePresenter(); 
		doublePolemix.sePresenter();
		
		
		
		
	}

}
