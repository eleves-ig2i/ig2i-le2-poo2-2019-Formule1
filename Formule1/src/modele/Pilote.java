/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author user
 */
public class Pilote extends Personne 
{
    // Attributs
    private int nbPrixGagnes;
    private int nbAbandons;

    
    // Constructeurs
    public Pilote() 
    {
        super();
        this.nbPrixGagnes = 0;
        this.nbAbandons = 0;
    }
    
    public Pilote(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
        this.nbPrixGagnes = 0;
        this.nbAbandons = 0;
    }

    public Pilote(int nbPrixGagnes, int nbAbandons, String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
        this.setNbPrixGagnes(nbPrixGagnes);
        this.setNbAbandons(nbAbandons);   
    }

    // Acceseurs
    public int getNbPrixGagnes() {
        return nbPrixGagnes;
    }

    public int getNbAbandons() {
        return nbAbandons;
    }
    
    // Mutateurs
    private void setNbPrixGagnes(int nbPrixGagnes)    
    {
        if( nbPrixGagnes >= 0)
            this.nbPrixGagnes = nbPrixGagnes;
        else
            this.nbPrixGagnes = 0;
    }

    private void setNbAbandons(int nbAbandons) {    
        if( nbAbandons >= 0)
            this.nbAbandons = nbAbandons;
        else
            this.nbAbandons = 0;
    }

    
    // Autres mÃ©thodes
    public void gagnerUnPrix() {
        this.nbPrixGagnes++;
    }
    
    public void abandonner()
    {
        this.nbAbandons++;
    }
    
    public void restituerUnPrix()
    {
        if( this.nbPrixGagnes > 0)
            this.nbPrixGagnes--;
    }

    @Override
    public String toString() {
        return "Pilote{" + super.toString() + " nbPrixGagnes=" + nbPrixGagnes + ", nbAbandons=" + nbAbandons + '}';
    }
    
    @Override
    public boolean estCompatible(Voiture v)
    {
        // Le pilote est compatible avec un Formule1 mais pas un Camion.
        return v instanceof Formule1;
    }
    
    public static void main(String[] args) {
        /*Pilote loicHecquet = new Pilote("HECQUET","Loïc","Bois de Boulogne-Sur-Mer");
        System.out.println(loicHecquet.toString());
        
        for(int i = 0; i < 12000; i++)
        {
            loicHecquet.abandonner();
            //loicHecquet.gagnerUnPrix();
        }
        System.out.println("Loic Hecquet a abandonné un certain nombre de fois.");
        System.out.println(loicHecquet.toString());
        
        loicHecquet.restituerUnPrix();
        System.out.println(loicHecquet.toString());*/
        
              // TEST QUESTION 6 TP2
        /*Moteur m1 = new Moteur();
        Voiture v1 = new Voiture("Ferrari", m1);
        Camion twingo = new Camion(200,"Twingo",100,Moteur.ESSENCE);
        Formule1 renault = new Formule1("NAYSSON");
        
        Pilote pilote1 = new Pilote("HECQUET","Loïc","Bois de Boulogne-Sur-Mer");
        Technicien technicien1 = new Technicien("Coupeur d'oranges","HECQUET","Clement","Afrique");
        System.out.println(pilote1.estCompatible(twingo));      // est censé afficher false
        System.out.println(pilote1.estCompatible(renault));     // .. true
        System.out.println(technicien1.estCompatible(twingo));  // true
        System.out.println(technicien1.estCompatible(renault)); // false
        
        System.out.println(pilote1.estCompatible(v1));     // false
        System.out.println(technicien1.estCompatible(v1));  // false*/
        
        
        // TEST QUESTION 7 TP2
        Camion c1 = new Camion(200,"Twingo",100,Moteur.ESSENCE);
        Formule1 f1 = new Formule1("NAYSSON");
        
        Pilote pilote1 = new Pilote("HECQUET","Loïc","Bois de Boulogne-Sur-Mer");
        Technicien technicien1 = new Technicien("Coupeur d'oranges","HECQUET","Clement","Afrique");
        
        
        // pilote     
        boolean succes = pilote1.affecter(c1);      // false
        System.out.println(succes);
        
        succes = pilote1.affecter(f1);      // true
        System.out.println(succes);
        succes = pilote1.restituer();      // true
        System.out.println(succes);
        
        // technicien
        
        succes = technicien1.affecter(f1);      // false
        System.out.println(succes);
        
        succes = technicien1.affecter(c1);      // true
        System.out.println(succes);
        succes = technicien1.restituer();      // true
        System.out.println(succes);
        
    }
    
    
    
    
    
}
