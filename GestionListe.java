package projet_java;
import java.util.*;

public class GestionListe<T> {
    private List<T> liste;

    public GestionListe() {
        liste = new ArrayList<>();
    }

    public void alimenterListe(List<T> elements) {
        liste.addAll(elements);
    }

    public void afficherListe() {
        for (T element : liste) {
            System.out.println(element);
        }
    }

    public void parcourirAvecIterateur() {
        Iterator<T> iterator = liste.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void insererElement(int index, T element) {
        liste.add(index, element);
    }

    public T recupererElement(int index) {
        return liste.get(index);
    }

    public void supprimerElement(T element) {
        liste.remove(element);
    }

    public boolean rechercherElement(T element) {
        return liste.contains(element);
    }

    public void trierListe(Comparator<T> comparator) {
        Collections.sort(liste, comparator);
    }

    public List<T> copierListe() {
        return new ArrayList<>(liste);
    }

    public void melangerElements() {
        Collections.shuffle(liste);
    }

    public void inverserElements() {
        Collections.reverse(liste);
    }

    public List<T> extrairePartieListe(int debut, int fin) {
        return liste.subList(debut, fin);
    }

    public boolean comparerListes(List<T> autreListe) {
        return liste.equals(autreListe);
    }

    public void echangerElements(int index1, int index2) {
        Collections.swap(liste, index1, index2);
    }

    public void viderListe() {
        liste.clear();
    }

    public boolean estVide() {
        return liste.isEmpty();
    }

    public static void main(String[] args) {
      
        GestionListe<Integer> gestionnaireListe = new GestionListe<>();

        gestionnaireListe.alimenterListe(Arrays.asList(1, 3, 5, 7, 9));

      
        System.out.println("Affichage de la liste :");
        gestionnaireListe.afficherListe();

  
        System.out.println("\nParcours de la liste avec un itérateur :");
        gestionnaireListe.parcourirAvecIterateur();

       
        gestionnaireListe.insererElement(2, 4);

        
        gestionnaireListe.supprimerElement(5);

       
        System.out.println("\nAffichage de la liste après modifications :");
        gestionnaireListe.afficherListe();

        
        List<Integer> autreListe = Arrays.asList(1, 3, 4, 7, 9);
        System.out.println("\nComparaison avec une autre liste : " + gestionnaireListe.comparerListes(autreListe));

        
    }
}

