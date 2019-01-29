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
public class Camion extends Voiture
{
    // Attributs
    private int tonnage;

    
    // Constructeurs
    public Camion() {
        super();
        this.tonnage = 0;
    }

    public Camion(int tonnage) {
       super();
       this.setTonnage(tonnage);
    }

    public Camion(int tonnage, String marque, int puissance, char carburant) {
        super(marque, puissance, carburant);
        this.setTonnage(tonnage);
    }

    
    // Mutateurs / accesseurs
    /**
     * La visibilité est mis en private, car l'utilisateur ne peut pas modifier le tonnage du camion.
     * @param tonnage 
     */
    private void setTonnage(int tonnage) {
       if( tonnage > 0)
       {
           this.tonnage = tonnage;
       }
       else
       {
           this.tonnage = 0;
       }
    }

    public int getTonnage() {
        return tonnage;
    }

    @Override
    public String toString() {
        return "Camion{" + super.toString() + " tonnage=" + tonnage + '}';
    }
    
    
    public static void main(String[] args) {
        Camion twingo = new Camion(200,"Twingo",100,Moteur.ESSENCE);        // ESSENCE TOUT SEUL NE MARCHE PAS !!!!!
        System.out.println(twingo.toString());
    }
    
    
    
    
    
    
    
    
    
}
