/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Nathan Salez
 */
public abstract class Voiture
{
    // Attributs
    private static int derniereImmatriculation = 0;
    private int immatriculation;
    private String marque;
    private Moteur moteur = new Moteur(); // Garantit qu'on a toujours un moteur non null
    private Personne conducteur;    // pas besoin d'avoir toujours un conducteur


    // Constructeurs
    /**
     * Par défaut, il n'y a pas de conducteur.
     */
    public Voiture()
    {
        this.marque = "MARQUE_STANDARD";
        derniereImmatriculation++;
        this.immatriculation = derniereImmatriculation;
        this.moteur = new Moteur();
        
        this.conducteur = null;
    }

    public Voiture (String marque)
    {
        this();
        if( marque != null )
        {
            this.marque = marque;
        }
    }

    public Voiture(String marque, int puissance, char carburant) {
        this(marque);
        this.moteur = new Moteur(puissance, carburant);    
    }

    public Voiture(String marque, Moteur moteur) {
        this(marque);
        this.moteur = new Moteur(moteur);    // Constructeur par copie, pour éviter les problèmes avec les pointeurs
    }

    public int getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public Moteur getCopieMoteur() {
        return new Moteur(this.moteur);     // Attention aux pointeurs !!
    }
    
    public int getPuissanceMoteur() {
        return this.moteur.getPuissance();
    }
    
    public char getCarburantMoteur()
    {
        return this.moteur.getCarburant();
    }
    
    public void setMoteur(Moteur moteur)
    {
        this.moteur = new Moteur(moteur);
    }

    public boolean estDisponible()
    {
        return (this.conducteur == null);
    }
    
    public boolean affecterConducteur(Personne conducteur)
    {
        if( conducteur == null || !this.estDisponible()  )
            // !conducteur.estPieton() n'est pas à mettre : on a déjà  affecté une voiture dans
            // la méthode affecter() de la classe Personne
        {
            return false;
        }
        
        if( conducteur.getImmatriculationVoiture() != this.immatriculation  )    
        //Dans le cas où on utilise directement cette méthode dans le main
            return false;
        
        this.conducteur = conducteur;
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Voiture{" + "immatriculation=" + immatriculation + ", marque=" + marque + ", moteur=" + moteur + '}';
    }
    
    public static void main(String[] args) {
        /*Moteur m1 = new Moteur(null);
        Moteur m2 = new Moteur(1000, 'E');
        Voiture v1 = new Voiture(null, m1);
        Voiture v2 = new Voiture("Ferrari", m2);
        Voiture v3 = new Voiture("Ferrari", m2);
        System.out.println("v1 : " + v1.toString());
        System.out.println("v2 : " + v2.toString());
        System.out.println("v3 : " + v3.toString());
        m2.setPuissance(1200);
        System.out.println("v2 : " + v2.toString());
        System.out.println("v3 : " + v3.toString()); */ 
    }
    

}
    


