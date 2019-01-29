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
public class Ecurie 
{
    // Attributs
    private String nom;
    private int nbPersonnes;
    private int nbVoitures;
    private Personne[] equipe;
    private Voiture[] flotte;

    private final static int MAX_NB_PERSONNES = 5;
    private final static int MAX_NB_VOITURES = 5;
    
    
    // Constructeur
    public Ecurie(String nom)
    {
        this.setNom(nom);
        this.equipe = new Personne[MAX_NB_PERSONNES];
        this.flotte = new Voiture[MAX_NB_VOITURES];
        this.nbPersonnes = 0;
        this.nbVoitures = 0;
    }

    
    // Accesseurs
    public void setNom(String nom) {
        if( nom != null)
            this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public int getNbVoitures() {
        return nbVoitures;
    }

    @Override
    public String toString() {
        // Affichage des attributs "simples"
        String printString = "Ecurie{" + "nom=" + nom + ", nbPersonnes=" + nbPersonnes + ", nbVoitures=" + nbVoitures + ", equipe=[";
        // Affichage de equipe
        for(int i = 0; i < nbPersonnes; i++)
        {
            printString += this.equipe[i].toString() + "\n";
        }
        printString += "]}, flotte=[";
        
        // Affichage de flotte
        for(int i = 0; i < nbVoitures; i++)
        {
            printString += this.flotte[i].toString() + "\n";
        }
        printString += "]}";
        
        return printString;
        //return "Ecurie{" + "nom=" + nom + ", nbPersonnes=" + nbPersonnes + ", nbVoitures=" + nbVoitures + ", equipe=" + equipe + ", flotte=" + flotte + '}';
    }
    
    public boolean estPresent(Personne p)
    {
        if( p != null)
        {
            for(int i = 0; i < nbPersonnes; i++)
            {
                if( this.equipe[i].getNumeroIdentification() == p.getNumeroIdentification() )
                    return true;
            }
        }     
        return false;
    }
    
    
    public boolean estPresent(Voiture v)
    {
        if( v != null)
        {
            for(int i = 0; i < nbVoitures; i++)
            {
                if( this.flotte[i].getImmatriculation() == v.getImmatriculation() )
                    return true;
            }
        }
        return false;
    }
    
    
    public boolean embaucher(Personne p)
    {
        if( !this.estPresent(p) && this.nbPersonnes < MAX_NB_PERSONNES )    // si p est null alors this.estPresent(p) renvoie false
        {
            this.equipe[this.nbPersonnes] = p;
            this.nbPersonnes++;
            return true;
        }
        else
        {
            return false;
        } 
    }
    
    
    public boolean acheter(Voiture v)
    {
        if( !this.estPresent(v) && this.nbVoitures < MAX_NB_VOITURES )
        {
            this.flotte[this.nbVoitures] = v;
            this.nbVoitures++;
            return true;
        }
        else
        {
            return false;
        } 
    }
    
    
    private Personne localiserPersonne(int id)
    {
        for(int i = 0; i < nbPersonnes; i++)
        {
            if( this.equipe[i].getNumeroIdentification() == id)
                return this.equipe[i];
        }
        return null;
    }
    
    
    private Voiture localiserVoiture(int immat)
    {
        for(int i = 0; i < nbVoitures; i++)
        {
            if( this.flotte[i].getImmatriculation() == immat)
                return this.flotte[i];
        }
        return null;
    }
    
    /**
     * affecte la voiture immatriculÃ©e immat Ã  la personne identifiÃ©e par id 
     * si la voiture est dans la flotte et la personne dans lâ€™Ã©quipe de lâ€™Ã©curie.
     * @param id
     * @param immat
     * @return 
     */
    public boolean affecter(int id, int immat)
    {
        // affecte la voiture immatriculÃ©e immat Ã  la personne identifiÃ©e par id 
        // si la voiture est dans la flotte et la personne dans lâ€™Ã©quipe de lâ€™Ã©curie.
        
        // POLYMORPHISME :
        // Personne p = new Personne(); // MARCHE PAS !!!

        Personne p = localiserPersonne(id);     // On a le droit de faire Ã§a 
        if( p != null)
            return p.affecter( localiserVoiture(immat));
        else
            return false;
    }   
    
    
    public boolean restituer(int id)
    {
        Personne p = localiserPersonne(id);
        if( p != null)
            return p.restituer();
        else
            return false;
    }
    
            
    public static void main(String[] args) {
        Ecurie renault = new Ecurie("Renault");    
        Pilote pilote1 = new Pilote("HECQUET","LoÃ¯c","Bois de Boulogne-Sur-Mer");
        Technicien technicien1 = new Technicien("Coupeur d'oranges","HECQUET","Clement","Afrique");
        Camion camion1 = new Camion(200,"Twingo",100,Moteur.ESSENCE);
        
        renault.embaucher(pilote1);
        renault.embaucher(technicien1);
        renault.acheter(camion1);
        renault.affecter(technicien1.getNumeroIdentification(),camion1.getImmatriculation());
        boolean succes = renault.restituer(technicien1.getNumeroIdentification() );
        System.out.println(succes);
        
        
        /*boolean succes = renault.embaucher(pilote1);  // Test question 13
        System.out.println(succes);
        System.out.println(renault.toString());
        
        succes = renault.embaucher(pilote1);
        System.out.println(succes);
        System.out.println(renault.toString());
        
        succes = renault.embaucher(technicien1);
        System.out.println(succes);
        System.out.println(renault.toString());*/
        
        // Test question 14
        /*renault.embaucher(pilote1);
        renault.embaucher(technicien1);
        boolean succes = renault.localiserPersonne(pilote1.getNumeroIdentification())*/
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
