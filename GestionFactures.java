package projet_java;

import java.util.Arrays;
import java.util.Date;

public class GestionFactures {
    private Facture[] tableauFactures;
    private int nombreElements;
    
    public GestionFactures(int taille) {
        tableauFactures = new Facture[taille];
        nombreElements = 0;
    }


    public GestionFactures(Facture[] factures) {
        tableauFactures = factures.clone();
        nombreElements = factures.length;
    }

    public void trierTableau() {
        Arrays.sort(tableauFactures, 0, nombreElements);
    }

    public void ajouterElement(Facture facture) {
        tableauFactures[nombreElements] = facture;
        nombreElements++;
    }

    public void supprimerElement(int index) {
        if (index >= 0 && index < nombreElements) {
            System.arraycopy(tableauFactures, index + 1, tableauFactures, index, nombreElements - index - 1);
            nombreElements--;
        }
    }

    public int compterElements() {
        return nombreElements;
    }

    public void inverserOrdre() {
        Facture[] temp = new Facture[nombreElements];
        for (int i = 0; i < nombreElements; i++) {
            temp[i] = tableauFactures[nombreElements - i - 1];
        }
        tableauFactures = temp;
    }

    public void afficherElements() {
        for (int i = 0; i < nombreElements; i++) {
            System.out.println(tableauFactures[i]);
        }
    }

    public Facture trouverElementMax() {
        if (nombreElements > 0) {
            Facture max = tableauFactures[0];
            for (int i = 1; i < nombreElements; i++) {
                if (tableauFactures[i].getMontantTotal() > max.getMontantTotal()) {
                    max = tableauFactures[i];
                }
            }
            return max;
        }
        return null;
    }

    public boolean estEgal(GestionFactures autreGestionFactures) {
        if (nombreElements != autreGestionFactures.compterElements()) {
            return false;
        }

        Facture[] tableauComparaison = autreGestionFactures.getTableauFactures();
        for (int i = 0; i < nombreElements; i++) {
            if (!tableauFactures[i].equals(tableauComparaison[i])) {
                return false;
            }
        }
        return true;
    }

    public Facture[] getTableauFactures() {
        return Arrays.copyOf(tableauFactures, nombreElements);
    }

    public static void main(String[] args) {
    
        GestionFactures gestionnaire = new GestionFactures(5);

     
        gestionnaire.ajouterElement(new Facture(1, new Date(), 100.0, true));
        gestionnaire.ajouterElement(new Facture(2, new Date(), 150.0, false));
        gestionnaire.ajouterElement(new Facture(3, new Date(), 200.0, true));

       
        System.out.println("Avant le tri : ");
        gestionnaire.afficherElements();

        
        gestionnaire.trierTableau();

        
        System.out.println("\nAprès le tri : ");
        gestionnaire.afficherElements();

        
        gestionnaire.supprimerElement(1);

    
        System.out.println("\nAprès suppression : ");
        gestionnaire.afficherElements();

        
        gestionnaire.inverserOrdre();

        System.out.println("\nAprès inversion : ");
        gestionnaire.afficherElements();

        
        System.out.println("\nÉlément avec le montant le plus élevé : ");
        System.out.println(gestionnaire.trouverElementMax());

        
        GestionFactures gestionnaire2 = new GestionFactures(gestionnaire.getTableauFactures());

     
        System.out.println("\nTest d'égalité : " + gestionnaire.estEgal(gestionnaire2));
    }
}
    
    

