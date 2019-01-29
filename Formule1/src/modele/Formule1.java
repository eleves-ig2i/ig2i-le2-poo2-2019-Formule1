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

// REMARQUES : TOUTES LES CLASSES HERITENT DE LA CLASSE OBJECT


public class Formule1 extends Voiture       // extends Voiture <==> Formule1 hérite de Voiture
{
    // Attributs
    private String sponsor;
    
    // Constructeurs
    public Formule1()
    {
        super();    // appel au constructeur de la classe mère.
        this.sponsor = "???";
    }

    public Formule1(String sponsor) 
    {
        this.sponsor = sponsor;
        this.setSponsor(sponsor);
    }

    public Formule1(String sponsor, String marque, int puissance, char carburant) 
    {
        super(marque, puissance, carburant);
        this.setSponsor(sponsor);
    }

    
    public String getSponsor() {
        return sponsor;
    }

    
    public void setSponsor(String sponsor) {
        if( sponsor != null)
        {
            this.sponsor = sponsor;
        }
        else
        {
            this.sponsor = "???";
        }
    }

    @Override
    public String toString() {
        return "Formule1{" + super.toString() + " sponsor=" + sponsor + '}';
    }
    
    public static void main(String[] args) {
        Formule1 twingo = new Formule1("NAYSSON");
        System.out.println(twingo.toString());
        twingo.setSponsor(null);
        System.out.println(twingo.getSponsor());    
        System.out.println(twingo.toString());
    }
    
     
    
    
    
    
    
    
}
