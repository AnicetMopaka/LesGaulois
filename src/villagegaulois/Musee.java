package villagegaulois;

import objets.*;
import personnages.*;

public class Musee {
    private Trophee[] trophees = new Trophee[200];
    private int nbTrophee = 0;

    public void donnerTrophees(Gaulois g, Equipement e) {
        if (nbTrophee < trophees.length) {
            Trophee t = new Trophee(g, e);
            trophees[nbTrophee] = t;
            nbTrophee++;
        } else {
            System.out.println("Le musée est plein !");
        }
    }
    
    public String extraireInstructionsOCaml() {
        String ocaml = "let musee = [\n";

        for (int i = 0; i < nbTrophee; i++) {
        	
            Trophee troph = trophees[i];

            
            ocaml += "    \"" + troph.donnerNom() + "\", \"" + troph.getEquipement() + "\"";

            if (i < nbTrophee - 1) {
                ocaml += ";";
            }
            
            ocaml += "\n";
        }

        ocaml += "]";
        return ocaml;
    }
}
