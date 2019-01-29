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
public class Technicien extends Personne
{
    private String specialite;

    //Constructeurs
    public Technicien() 
    {
        super();
        this.specialite = "RIEN";
    }

    public Technicien(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
        this.specialite = "RIEN";
    }

    public Technicien(String specialite, String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
        if( specialite != null)
            this.specialite = specialite;
        else
            this.specialite = "RIEN";
    }
    
    // ACCESSEURS
    public String getSpecialite() {
        return specialite;
    }
    
    // MUTATEURS
    public void setSpecialite(String specialite) {
        if( specialite != null)
            this.specialite = specialite;
        else
            this.specialite = "RIEN";
    }

    @Override
    public String toString() {
        return "Technicien{" + super.toString() + " specialite=" + specialite + '}';
    }
    
    @Override
    public boolean estCompatible(Voiture v)
    {
        // Le technicien est compatible avec un Formule1 mais pas un Camion.
        return v instanceof Camion;   
    }
    
    public static void main(String[] args) {
        Technicien oui = new Technicien("Coupeur d'oranges","HECQUET","Clement","Afrique");
        System.out.println(oui.toString());
        
        oui.setSpecialite(null);
        System.out.println(oui.toString());
    }
    
}
