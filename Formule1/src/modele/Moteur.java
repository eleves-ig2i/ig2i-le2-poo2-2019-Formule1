/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Représente le moteur d'une voiture
 * @author Nathan Salez
 */


public class Moteur
{
   // Attributs
    /**
     * Puissance en chevaux
     */
   private int puissance;

    /**
     * Carburant : essence ou diesel
     */
   private char carburant;


   // Constantes
    // final <===> const en C/C++
    // static <====> variables indépendantes des instances
    private final static int PUISSANCE_MIN = 600;
    public final static char ESSENCE = 'E';
    public final static char DIESEL = 'D';


   // Constructeurs

    /**
     * Par défaut, un moteur a de l'essence, avec une puissance minimale.
     */
    public Moteur()
    {
        this.puissance = PUISSANCE_MIN;
        this.carburant = ESSENCE;
    }


    /**
     * @param puissance
     * @param carburant
     */
    public Moteur(int puissance, char carburant)
    {
        this(); // Appel au constructeur par défaut
        // doit être la 1ere ligne dans le constructeur
        // utile en cas d'erreur.
        if( puissance > PUISSANCE_MIN )
        {
            this.puissance = puissance;
        }
        if( carburant == DIESEL )   // Si l'essence a été mis en paramètre, inutile de refaire une affectation (cf appel à this() )
        {
            this.carburant = carburant;
        }
    }


    /**
     * Si m est null, alors l'instance est crÃƒÂ©ÃƒÂ©e avec la mÃƒÂ©thode par dÃƒÂ©faut.
     * @param m
     */
    public Moteur(Moteur m)
    {
        this();
        if( m != null)  // <"null".puissance> n'a pas de sens !!!
        {
            this.carburant = m.carburant;
            this.puissance = m.puissance;
        }
        //this = m; ne marche pas (m et this sont des "pointeurs")
    }



    // Methodes

    // Getters
    public int getPuissance() {
        return puissance;
    }

    public char getCarburant() {
        return carburant;
    }

    // Setter
    /**
     * La modification n'est faite que si la puissance est strictement supérieure à la puissance minimale.
     * @param puissance
     */
    public void setPuissance(int puissance) {
        if( puissance > PUISSANCE_MIN) {
            this.puissance = puissance;
        }
    }


    @Override       
    public String toString() {
        return "Moteur{" +
                "puissance=" + puissance +
                ", carburant=" + carburant +
                '}';
    }


    // Méthode principale
    public static void main(String[] args) {        // Ecrire psvm pour voir apparaitre cette ligne
        Moteur exempleMoteurDefaut = new Moteur();
        Moteur exempleMoteurDonnees = new Moteur(1200,'D');
        Moteur exempleMoteurCopie = new Moteur(exempleMoteurDonnees);

        System.out.println(exempleMoteurDefaut);   // Ecrire sout
        System.out.println(exempleMoteurDonnees);
        System.out.println(exempleMoteurCopie);

        // Création d'instances "fausses"
        Moteur moteurErreur1 = new Moteur(-200,'F');
        Moteur moteurErreur2 = new Moteur(moteurErreur1);
        moteurErreur1.setPuissance(1500);
        Moteur moteurErreur3 = new Moteur(null);

        System.out.println(moteurErreur1);
        System.out.println(moteurErreur2);
        System.out.println(moteurErreur3);
    }
}

