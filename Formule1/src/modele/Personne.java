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
public abstract class Personne {
    // Attributs
    private int numeroIdentification;
    private String nom;
    private String prenom;
    private String adresse;
    /**
     * Si voiture vaut null, la Personne n'en conduit pas
     */
    private Voiture voiture;
    
    // Attributs statiques
    private static int dernierNumeroIdentification = 0;
    
    
    // Constructeurs
    
    /**
     * Constructeur par défaut de la classe Personne.
     * Les valeurs des attributs (hors identification sont par défaut :
     * nom : "NOM"
     * prenom : "PRENOM"
     * adresse : "ADRESSE"
     */
    public Personne() {
        
        dernierNumeroIdentification++;
        this.numeroIdentification = dernierNumeroIdentification;
        
        this.nom = "NOM";
        this.prenom = "PRENOM";
        this.adresse = "ADRESSE";
        
        this.voiture = null;
    }

    /**
     * Le constructeur par défaut est utilisé pour les attributs dont l'argument correspondant vaut 'null'
     * @param nom
     * @param prenom
     * @param adresse 
     */
    public Personne(String nom, String prenom, String adresse) {
        this();
       
        if( nom != null && !nom.equals("")) {     // nom != "" ne marche pas
            this.nom = nom;
        }
        
        if( prenom != null && !prenom.equals("")) {
            this.prenom = prenom;
        }
        
        if( adresse != null && !adresse.equals("")) {
            this.adresse = adresse;
        }
    }

    
    // Accesseurs et mutateurs
    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    /**
     * Effectue la modification si le paramètre adresse ne vaut pas null
     * @param adresse 
     */
    public void setAdresse(String adresse) {
        if( adresse != null && !adresse.equals("") )  
            this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Personne{" + "numeroIdentification=" + numeroIdentification + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + '}';
    }
    
    
    public boolean estPieton()
    {
        /*if( this.voiture == null )
            return true;
        else
            return false;*/
        
        return (this.voiture == null);
    }
    
    /**
     * 
     * @return -1 si la voiture n'existe pas
     */
    public int getImmatriculationVoiture()
    {
        if( this.voiture == null)
            return -1;
        
        return this.voiture.getImmatriculation();
    }
    
    
    public boolean affecter(Voiture voiture)
    {
        if( voiture == null || !this.estPieton() || !voiture.estDisponible() || !this.estCompatible(voiture) )    
        //La voiture n'existe pas OU la personne a déjà  une voiture OU ...
        {
            return false;
        }
        
        // this.voiture = new Voiture(voiture); ne marche pas (pas de constructeur prévu pour ça)
        this.voiture = voiture;
        voiture.affecterConducteur(this);
        
        return true;
    }
    
    
    public boolean restituer()
    {
        if( this.estPieton() )
        {
            return false;
        }
        
        this.voiture = null;
        
        return true;
    }
    
    public abstract boolean estCompatible(Voiture v);
    
    public static void main(String[] args) {
       
        /*Personne p = new Personne();
        Personne p1 = new Personne("Salez","Naysson",""); 
        Personne p2 = new Personne(null,"Clement",null);
        System.out.println("------CONSTRUCTEURS------");
        System.out.println(p);
        System.out.println(p1);
        System.out.println(p2);
        
        p.setAdresse("Nouvelle Adresse");
        p1.setAdresse(null);
        System.out.println("------MUTATEURS------");
        System.out.println(p);
        System.out.println(p1);
        
        
        Voiture v1 = new Voiture();
        Voiture v2 = new Voiture();
        
        boolean succes = p.affecter(null);
        System.out.println(succes);     // est censé afficher false
        
        succes = p.affecter(v1);
        //System.out.println(succes);     // est censé afficher true
        
        /*succes = p.affecter(v2);
        System.out.println(succes);     // est censé afficher false
        
        succes = p1.affecter(v1);
        System.out.println(succes);     // est censé afficher true (pour l'instant)
        
        // p a une voiture
        succes = p.restituer();
        System.out.println(succes);     // est censé afficher true
        
        succes = p.restituer();
        System.out.println(succes);     // est censé afficher false*/
        
        
        
      
        
    }
    
    
    
    
    
    
    
    
    
    
}
